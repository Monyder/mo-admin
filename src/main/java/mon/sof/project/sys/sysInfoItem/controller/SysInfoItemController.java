package mon.sof.project.sys.sysInfoItem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mon.sof.common.orm.Resp;
import mon.sof.project.sys.sysDataType.entity.SysDataType;
import mon.sof.project.sys.sysDataType.service.SysDataTypeService;
import mon.sof.project.sys.sysInfoItem.entity.NullableEnum;
import mon.sof.project.sys.sysInfoItem.entity.SysInfoItem;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.project.sys.sysInfoItem.service.SysInfoItemService;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 信息项表 前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
@RestController
@RequestMapping("/sysInfoItem/sys-info-item")
public class SysInfoItemController {

    @Autowired
    private SysInfoItemService sysinfoitemService;

    @Autowired
    private SysDataTypeService sysDataTypeService;


    /**
     * 获取信息集表字段
     *
     * @Author zhangxiaomei
     * @Date 2020-12-21 16:05:59
     * @Param [infoSetCode]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/findInfoItemBySetCode")
    public Resp findInfoItemBySetCode(@RequestParam String infoSetCode) {
        QueryWrapper<SysInfoItem> sysInfoItemQueryWrapper = new QueryWrapper<>();
        sysInfoItemQueryWrapper.eq("infoset_code", infoSetCode);
        sysInfoItemQueryWrapper.orderByAsc("sort");
        List<SysInfoItem> list = sysinfoitemService.list(sysInfoItemQueryWrapper);
        for (SysInfoItem sysInfoItem : list) {
            sysInfoItem.setDataType(sysDataTypeService.getById(sysInfoItem.getDataTypeId()).getCode());
            sysInfoItem.setNullableName(NullableEnum.findNameByCode(sysInfoItem.getNullable()));
        }
        return Resp.ok(list);
    }

    /**
     * 添加字段
     *
     * @Author zhangxiaomei
     * @Date 2020-12-22 17:06:38
     * @Param [sysInfoItem]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/addInfoItem")
    public Resp addInfoItem(SysInfoItem sysInfoItem) {
        SysDataType sysDataType = sysDataTypeService.getById(sysInfoItem.getDataTypeId());
        if (sysDataType.getCode().equals("float") && !Optional.ofNullable(sysInfoItem.getLength()).isPresent()) {
            return Resp.err("请输入字段长度！");
        }
        if (sysDataType.getCode().equals("float") && !Optional.ofNullable(sysInfoItem.getPrecisionSet()).isPresent()) {
            return Resp.err("请输入字段精度！");
        }
        if (sysDataType.getCode().equals("float") && sysInfoItem.getLength() < sysInfoItem.getPrecisionSet()) {
            return Resp.err("字段长度数值必须大于小数点精度数值！");
        }
        if (sysDataType.getCode().equals("varchar") && !Optional.ofNullable(sysInfoItem.getLength()).isPresent()) {
            return Resp.err("请输入字段长度！");
        }
        QueryWrapper<SysInfoItem> sysInfoItemQueryWrapper = new QueryWrapper<>();
        sysInfoItemQueryWrapper.eq("infoset_code", sysInfoItem.getInfosetCode());
        sysInfoItemQueryWrapper.eq("code", sysInfoItem.getCode());
        List<SysInfoItem> list = sysinfoitemService.list(sysInfoItemQueryWrapper);
        if (list.size() > 0) {
            return Resp.err("当前字段编码重复，请输入新字段编码");
        }
        sysinfoitemService.addInfoItem(sysInfoItem);
        sysinfoitemService.createColumn(sysInfoItem);
        return Resp.ok();

    }

    /**
     * 删除字段
     *
     * @Author zhangxiaomei
     * @Date 2020-12-23 09:38:12
     * @Param [id]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/delInfoItemById")
    public Resp delInfoItemById(@RequestParam Long id) {
        SysInfoItem byId = sysinfoitemService.getById(id);
        if (byId.getIsDefault() == 0) return Resp.err("系统字段不允许删除！");
        sysinfoitemService.delInfoItemById(byId);
        return Resp.ok();
    }

    /**
     * 修改字段
     *
     * @Author zhangxiaomei
     * @Date 2020-12-23 11:36:32
     * @Param [sysInfoItem]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/upInfoItem")
    public Resp upInfoItem(SysInfoItem sysInfoItem) {
        if (sysInfoItem.getIsDefault() == 0) return Resp.err("系统字段不允许修改！");
        sysinfoitemService.upInfoItem(sysInfoItem);
        return Resp.ok();

    }

    /**
     * 上（移动字段）
     *
     * @Author zhangxiaomei
     * @Date 2020-12-23 14:50:37
     * @Param [id]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/topMoveColumn")
    public Resp topMoveColumn(@RequestParam Long id) {
        SysInfoItem byId = sysinfoitemService.getById(id);
        return sysinfoitemService.topMoveColumn(byId);
    }

    /**
     * 下（移动字段）
     *
     * @Author zhangxiaomei
     * @Date 2020-12-23 14:50:37
     * @Param [id]
     * @Return mon.sof.common.orm.Resp
     */
    @PostMapping("/bottomMoveColumn")
    public Resp bottomMoveColumn(@RequestParam Long id) {
        SysInfoItem byId = sysinfoitemService.getById(id);
        return sysinfoitemService.bottomMoveColumn(byId);
    }

}

