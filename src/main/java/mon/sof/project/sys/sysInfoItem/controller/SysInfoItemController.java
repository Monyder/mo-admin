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

}

