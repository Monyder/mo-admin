package mon.sof.project.sys.sysInfoSet.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mon.sof.common.orm.Resp;
import mon.sof.project.sys.sysInfoItem.entity.SysInfoItem;
import mon.sof.project.sys.sysInfoItem.service.SysInfoItemService;
import mon.sof.project.sys.sysInfoSet.entity.IsSysEnum;
import mon.sof.project.sys.sysInfoSet.entity.SysInfoSet;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.project.sys.sysInfoSet.service.SysInfoSetService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 信息集表 前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-12-16
 */
@RestController
@RequestMapping("/sysInfoSet/sys-info-set")
public class SysInfoSetController {

    @Autowired
    private SysInfoSetService sysinfosetService;

    @Autowired
    private SysInfoItemService sysInfoItemService;


    /**
     * 查询信息集列表
     *
     * @Author zhangxiaomei
     * @Date 2020-12-16 15:35:27
     * @Param [pageNum, pageSize]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/findSysInfoSet")
    public Resp findSysInfoSet(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "") String code) {
        QueryWrapper<SysInfoSet> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        if(StrUtil.isNotEmpty(code)){
            wrapper.like("code", code);
        }
        IPage<SysInfoSet> page = new Page<>(pageNum, pageSize);
        IPage<SysInfoSet> pageList = sysinfosetService.page(page, wrapper);
        for (SysInfoSet record : pageList.getRecords()) {
            record.setIsSysName(IsSysEnum.findNameByCode(record.getIsSys()));
        }
        return Resp.ok(pageList);
    }

    /**
     * 添加信息集
     *
     * @Author zhangxiaomei
     * @Date 2020-12-16 16:13:44
     * @Param [sysInfoSet]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/addInfoSet")
    public Resp addInfoSet(SysInfoSet sysInfoSet) {
        sysInfoSet.setCreateTime(new Date());
        QueryWrapper<SysInfoSet> wrapper = new QueryWrapper<>();
        wrapper.eq("code", sysInfoSet.getCode());
        List<SysInfoSet> list = sysinfosetService.list(wrapper);
        if (list.size() > 0) return Resp.err("当前字符编码以重复，请输入新的字符编码！");
        Integer code = IsSysEnum.findCodeByName(sysInfoSet.getIsSysName());
        if (!Optional.ofNullable(code).isPresent()) {
            return Resp.err("请重新选择是否是系统表！");
        }
        sysInfoSet.setIsSys(code);
        sysinfosetService.addInfoSet(sysInfoSet);
        sysinfosetService.createTable(sysInfoSet);
        sysInfoItemService.addInfoItem(sysInfoSet.getCode());
        return Resp.ok();
    }

    /**
     * 修改信息集
     *
     * @Author zhangxiaomei
     * @Date 2020-12-18 10:57:20
     * @Param [sysInfoSet]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/upInfoSet")
    public Resp upInfoSet(@RequestParam Long id,
                          @RequestParam String name,
                          @RequestParam String remark) {
        SysInfoSet byId = sysinfosetService.getById(id);
        byId.setName(name);
        byId.setRemark(remark);
        byId.setCreateTime(new Date());
        sysinfosetService.updateById(byId);
        return Resp.ok();
    }

    /**
     * 删除信息集
     *
     * @Author zhangxiaomei
     * @Date 2020-12-17 16:18:50
     * @Param [code]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/delInfoSetByCode")
    public Resp delInfoSetByCode(@RequestParam String code) {
        QueryWrapper<SysInfoSet> wrapper = new QueryWrapper<>();
        wrapper.eq("code", code);
        SysInfoSet sysInfoSet = sysinfosetService.getOne(wrapper);
        QueryWrapper<SysInfoItem> sysInfoItemWrapper = new QueryWrapper<>();
        sysInfoItemWrapper.eq("infoset_code", sysInfoSet.getCode());
        List<SysInfoItem> list = sysInfoItemService.list(sysInfoItemWrapper);
        sysInfoItemService.delInfoSetByCode(list);
        sysinfosetService.delInfoSetByCode(code);
        return Resp.ok();
    }

}

