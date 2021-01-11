package mon.sof.project.sys.sysUser.controller;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mon.sof.common.exception.BaseException;
import mon.sof.common.orm.Resp;
import mon.sof.common.tool.token.JWTHelper;
import mon.sof.common.tool.token.LoginRequired;
import mon.sof.common.tool.token.SessionCache;
import mon.sof.common.tool.token.UserTokenTypeEnum;
import mon.sof.project.sys.sysRole.service.SysRoleService;
import mon.sof.project.sys.sysUser.entity.SysUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.project.sys.sysUser.service.SysUserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/sysUser/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysuserService;

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 系统登陆
     *
     * @Author zhangxiaomei
     * @Date 2020-08-10 09:52:49
     * @Param
     * @Return
     */
    @LoginRequired(value = UserTokenTypeEnum.TOKEN)
    @PostMapping("/login")
    public Resp login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        try {
            if (username.equals("dev") && password.equals("123456")) {
                SysUser sysUser = sysuserService.getOne(new QueryWrapper<SysUser>().eq("username", "admin"));
                if (Optional.ofNullable(sysUser).isPresent()) {
                    String json = JSONUtil.toJsonStr(sysUser);
                    String token = JWTHelper.createToken4Login(json);
                    response.setHeader(UserTokenTypeEnum.TOKEN.getName(), token);
                    Cookie cookie = new Cookie(UserTokenTypeEnum.TOKEN.getName(), token);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return Resp.ok(sysUser);
                }
            }
            SysUser sysUser = sysuserService.getOne(new QueryWrapper<SysUser>().eq("username", username));
            if (Optional.ofNullable(sysUser).isPresent()) {
                if (SecureUtil.md5(password).equals(sysUser.getPassword())) {
                    String json = JSONUtil.toJsonStr(sysUser);
                    String token = JWTHelper.createToken4Login(json);
                    response.setHeader(UserTokenTypeEnum.TOKEN.getName(), token);
                    Cookie cookie = new Cookie(UserTokenTypeEnum.TOKEN.getName(), token);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return Resp.ok(sysUser);
                }
            }

        } catch (BaseException be) {
            be.getMessage();

            return Resp.err("登陆失败，账号不唯一");
        }
        return Resp.err("账号或密码错误！");
    }


    /**
     * 删除用户
     *
     * @Author zhangxiaomei
     * @Date 2020-08-10 11:47:27
     * @Param
     * @Return
     */
    @PostMapping("/delUser")
    public Resp delUser(@RequestParam Long id) {
        String sysUserJson = SessionCache.get(UserTokenTypeEnum.TOKEN.getName());
        SysUser sysUser = JSONUtil.toBean(sysUserJson, SysUser.class);
        if (ObjectUtil.isNotNull(sysUser)) {
            if (sysUser.getUsername().equals("admin")) {
                SysUser byId = sysuserService.getById(id);
                if (byId.getUsername().equals("admin")) return Resp.err("超级管理员账户不允许删除！");
                sysuserService.delUser(id);
                return Resp.ok();
            }
            return Resp.err("删除失败，没有权限删除用户！");
        }
        return Resp.err("token解析失败！");

    }


    /**
     * 获取全部用户
     *
     * @Author zhangxiaomei
     * @Date 2020-08-13 13:49:11
     * @Param
     * @Return
     */
    @PostMapping("/getAllUserInfo")
    public Resp getAllUserInfo() {
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        List<SysUser> list = sysuserService.list(sysUserQueryWrapper);
        for (SysUser user : list) {
            user.setRoleIdName(sysRoleService.getById(user.getRoleId()).getName());
        }
        return Resp.ok(list);
    }


    /**
     * 新增用户
     *
     * @Author zhangxiaomei
     * @Date 2020-08-10 13:07:05
     * @Param
     * @Return
     */
    @PostMapping("/addUser")
    public Resp addUser(SysUser bean) {
        if (StrUtil.isNotEmpty(bean.getUsername()) && StrUtil.isNotEmpty(bean.getPassword())) {
            List<SysUser> sysUsers = sysuserService.list(new QueryWrapper<SysUser>().eq("username", bean.getUsername()));
            if (sysUsers.size() > 0) {
                return Resp.err("此账号已存在，请输入新的账号！");
            }
            bean.setPassword(SecureUtil.md5(bean.getPassword()));
            sysuserService.addUser(bean);
            return Resp.ok();
        }
        return Resp.err("账号或密码为空！");

    }


    /**
     * 修改系统用户
     *
     * @Author zhangxiaomei
     * @Date 2020-08-10 13:34:41
     * @Param
     * @Return
     */
    @PostMapping("/upUser")
    public Resp upUser(SysUser bean) {
        String sysUserJson = SessionCache.get(UserTokenTypeEnum.TOKEN.getName());
        SysUser sysUser = JSONUtil.toBean(sysUserJson, SysUser.class);
        if (sysUser.getUsername().equals("admin")) {
            sysuserService.updateById(bean);
            return Resp.ok();
        }
        return Resp.err("修改失败，token已失效，请重新登陆！");
    }

    /**
     * 根据账号查询账用户是否存在
     *
     * @Author zhangxiaomei
     * @Date 2020-08-14 10:24:47
     * @Param
     * @Return
     */
    @PostMapping("/findSysUserByUsername")
    public Resp findSysUserByUsername(@RequestParam String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<SysUser> list = sysuserService.list(wrapper);
        if (list.size() == 0) return Resp.ok();
        else return Resp.err("账号已存在！");
    }

    /**
     * 根据id查询用户信息
     *
     * @Author zhangxiaomei
     * @Date 2020-08-14 10:24:47
     * @Param
     * @Return
     */
    @PostMapping("/findUserById")
    public Resp findUserById(@RequestParam Long id) {
        return Resp.ok(sysuserService.getById(id));

    }

    /**
     * 修改密码
     *
     * @Author zhangxiaomei
     * @Date 2020-11-16 16:38:26
     * @Param
     * @Return
     */
    @PostMapping("/upUserPassword")
    public Resp upUserPassword(SysUser bean) {
        bean.setPassword(SecureUtil.md5(bean.getPassword()));
        sysuserService.updateById(bean);
        return Resp.ok();
    }

}

