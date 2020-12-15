package mon.sof.project.sysMenu.controller;


import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mon.sof.common.exception.BaseException;
import mon.sof.common.orm.Resp;
import mon.sof.common.tool.token.SessionCache;
import mon.sof.common.tool.token.UserTokenTypeEnum;
import mon.sof.project.sysLog.advice.Log;
import mon.sof.project.sysMenu.entity.NodeTypeEnum;
import mon.sof.project.sysMenu.entity.SysMenu;
import mon.sof.project.sysMenu.entity.SysMenuVo;
import mon.sof.project.sysMenu.util.TreeNodeHandle;
import mon.sof.project.sysRole.entity.SysRole;
import mon.sof.project.sysRole.service.SysRoleService;
import mon.sof.project.sysUser.entity.SysUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.project.sysMenu.service.SysMenuService;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/sysMenu/sys-menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysmenuService;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 前台获取菜单
     *
     * @Author zhangxiaomei
     * @Date 2020-08-12 13:30:27
     * @Param
     * @Return
     */
    @PostMapping("/getSysMenu")
    public Resp getSysMenu() {
        String userJson = SessionCache.get(UserTokenTypeEnum.TOKEN.getName());
        SysUser user = JSONUtil.toBean(userJson, SysUser.class);
        SysRole byId = sysRoleService.getById(user.getRoleId());
        if (byId.getStatus() == 1) return Resp.err("当前登录用户角色已失效，请联系管理人员！");
        if (StrUtil.isEmpty(byId.getMenuIds())) return Resp.err("当前登录用户角色未赋予权限，请联系管理人员！");
        String[] menuIds = byId.getMenuIds().split(",");
        QueryWrapper<SysMenu> sysMenuQueryWrapper = new QueryWrapper<>();
        sysMenuQueryWrapper.in("id", menuIds);
        List<SysMenu> list = sysmenuService.list(sysMenuQueryWrapper);
        List<Tree<String>> trees = TreeNodeHandle.handleMenu(list);
        return Resp.ok(trees);
    }


    /**
     * 获取菜单详情
     *
     * @Author zhangxiaomei
     * @Date 2020-08-24 11:40:51
     * @Param
     * @Return
     */
    @PostMapping("/getSysMenuByNodePid")
    public Resp getSysMenuByNodePid(@RequestParam(defaultValue = "0") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize,
                                         SysMenuVo ids) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<SysMenu> sysMenuQueryWrapper = new QueryWrapper<>();
        sysMenuQueryWrapper.in("id", ids.getIds());
        sysMenuQueryWrapper.orderByAsc("roder_code");
        List<SysMenu> list = sysmenuService.list(sysMenuQueryWrapper);
        for (SysMenu sysMenu : list) {
            sysMenu.setNodeTypeName(NodeTypeEnum.findNameByCode(sysMenu.getNodeType()));
            if (sysMenu.getNodePid() != 0) {
                sysMenu.setNodePidName(sysmenuService.getById(sysMenu.getNodePid()).getNodeName());
            }
        }
        PageInfo<SysMenu> sysMenuPageInfo = new PageInfo<>(list);
        return Resp.ok(sysMenuPageInfo);

    }

    /**
     * 新增菜单
     *
     * @Author zhangxiaomei
     * @Date 2020-08-25 16:46:08
     * @Param
     * @Return
     */
    @PostMapping("/addMenu")
    @Log(func = "菜单功能", remarks = "新增菜单操作")
    public Resp addMenu(SysMenu sysMenu) {
        boolean save = sysmenuService.save(sysMenu);
        if (save) {
            List<SysMenu> list = sysmenuService.list(new QueryWrapper<>());
            this.initSysRoleMenuIds(list);
            return Resp.ok(sysMenu);
        }
        return Resp.err("菜单新增失败！");
    }

    private void initSysRoleMenuIds(List<SysMenu> list) throws BaseException {
        StringBuffer sb = new StringBuffer();
        for (SysMenu sysMenu : list) {
            sb.append(sysMenu.getId()).append(",");
        }
        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        sysRoleQueryWrapper.eq("code", "Admin");
        SysRole sysRole = sysRoleService.getOne(sysRoleQueryWrapper);
        sysRole.setMenuIds(sb.toString());
        sysRoleService.updateById(sysRole);

    }

    /**
     * 修改菜单
     *
     * @Author zhangxiaomei
     * @Date 2020-08-25 16:46:08
     * @Param
     * @Return
     */
    @Log(func = "菜单功能", remarks = "修改菜单操作")
    @PostMapping("/updateMenu")
    public Resp upDateMenu(SysMenu sysMenu) {
        sysmenuService.updateById(sysMenu);
        return Resp.ok(sysMenu);
    }


    /**
     * 删除菜单
     *
     * @Author zhangxiaomei
     * @Date 2020-08-26 16:26:41
     * @Param
     * @Return
     */
    @Log(func = "菜单功能", remarks = "删除菜单操作")
    @PostMapping("/deleteMenu")
    public Resp deleteMenu(@RequestParam Long id) {
        sysmenuService.removeById(id);
        return Resp.ok();
    }

}

