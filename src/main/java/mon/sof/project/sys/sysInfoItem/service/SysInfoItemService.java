package mon.sof.project.sys.sysInfoItem.service;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mon.sof.common.orm.Resp;
import mon.sof.common.tool.PublicInterfaceHandle;
import mon.sof.project.sys.sysDataType.entity.SysDataType;
import mon.sof.project.sys.sysDataType.service.SysDataTypeService;
import mon.sof.project.sys.sysInfoItem.entity.IsDefaultEnum;
import mon.sof.project.sys.sysInfoItem.entity.NullableEnum;
import mon.sof.project.sys.sysInfoItem.entity.SysInfoItem;
import mon.sof.project.sys.sysInfoItem.mapper.SysInfoItemMapper;
import mon.sof.common.orm.IBaseAction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.common.orm.AbstractBaseAction;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 信息项表 服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysInfoItemService extends AbstractBaseAction<SysInfoItemMapper, SysInfoItem> {

    @Autowired
    private SysInfoItemMapper sysinfoitemMapper;

    @Autowired
    private SysDataTypeService sysDataTypeService;

    @Override
    public IBaseAction<SysInfoItem> getMapper() {
        return sysinfoitemMapper;
    }

    public void delInfoSetByCode(List<SysInfoItem> list) {
        List<String> strings = new ArrayList<>();
        ((PublicInterfaceHandle<SysInfoItem>) list1 -> {
            for (SysInfoItem sysInfoItem : list1) {
                strings.add(sysInfoItem.getInfosetCode());
            }
        }).edit(list);
        QueryWrapper<SysInfoItem> sysInfoItemQueryWrapper = new QueryWrapper<>();
        sysInfoItemQueryWrapper.in("infoset_code", strings);
        sysinfoitemMapper.delete(sysInfoItemQueryWrapper);

    }

    public void addInfoItem(String code) {
        SysInfoItem sysInfoItem = new SysInfoItem();
        sysInfoItem.setInfosetCode(code);
        sysInfoItem.setCode("id");
        sysInfoItem.setName("主键");
        QueryWrapper<SysDataType> sysDataTypeQueryWrapper = new QueryWrapper<>();
        sysDataTypeQueryWrapper.eq("code", "bigint");
        SysDataType sysDataType = sysDataTypeService.getOne(sysDataTypeQueryWrapper);
        sysInfoItem.setDataTypeId(sysDataType.getId());
        sysInfoItem.setLength(20);
        sysInfoItem.setNullable(NullableEnum.YES.getCode());
        sysInfoItem.setRemark("主键");
        sysInfoItem.setIsDefault(IsDefaultEnum.YES.getCode());
        sysInfoItem.setSort(1);
        sysinfoitemMapper.insert(sysInfoItem);
    }

    public void addInfoItem(SysInfoItem sysInfoItem) {
        sysInfoItem.setNullable(NullableEnum.NO.getCode());
        sysinfoitemMapper.insert(sysInfoItem);
        sysInfoItem.setSort(sysInfoItem.getId().intValue());
        sysinfoitemMapper.updateById(sysInfoItem);
    }

    public void createColumn(SysInfoItem sysInfoItem) {
        SysDataType sysDataType = sysDataTypeService.getById(sysInfoItem.getDataTypeId());
        String datatype = createDatatype(sysDataType.getCode(), sysInfoItem.getLength(), sysInfoItem.getPrecisionSet());
        sysInfoItem.setFullDataType(datatype);
        sysinfoitemMapper.createColumn(sysInfoItem);
    }


    private String createDatatype(String datatype, Integer clength, Integer precision) {
        if (StrUtil.isEmpty(datatype)) {
            return null;
        }
        if (!Optional.ofNullable(clength).isPresent()) {
            return datatype;
        }
        StringBuffer buffer = new StringBuffer(datatype);
        buffer.append("(");
        buffer.append(clength);
        if (Optional.ofNullable(precision).isPresent()) {
            buffer.append(",");
            buffer.append(precision);
        }
        buffer.append(")");
        return buffer.toString();
    }


    public void delInfoItemById(SysInfoItem sysInfoItem) {
        Map<String, Object> map = new HashMap<>();
        map.put("upperInfosetCode", sysInfoItem.getInfosetCode());
        map.put("upperCode", sysInfoItem.getCode());
        sysinfoitemMapper.deleteById(sysInfoItem.getId());
        sysinfoitemMapper.dropColumn(map);
    }

    public void upInfoItem(SysInfoItem sysInfoItem) {
        SysDataType sysDataType = sysDataTypeService.getById(sysInfoItem.getDataTypeId());
        String datatype = createDatatype(sysDataType.getCode(), sysInfoItem.getLength(), sysInfoItem.getPrecisionSet());
        sysInfoItem.setFullDataType(datatype);
        sysinfoitemMapper.updateById(sysInfoItem);
        sysinfoitemMapper.modifyColumn(sysInfoItem);
    }

    public Resp topMoveColumn(SysInfoItem byId) {
        Map<String, Object> map = new HashMap<>();
        map.put("sort", byId.getSort());
        map.put("infosetCode", byId.getInfosetCode());
        //上一条数据
        SysInfoItem sysinfoitem = sysinfoitemMapper.searchUpData(map);
        if (!Optional.ofNullable(sysinfoitem).isPresent() || sysinfoitem.getCode().equals("id"))
            return Resp.err("已经是第一条记录，不能移动！");
        Optional.ofNullable(sysinfoitem).ifPresent(sysInfoItem -> {
            SysInfoItem sysInfoItemCopy = ObjectUtil.cloneIfPossible(sysInfoItem);
            sysInfoItem.setSort(byId.getSort());
            sysinfoitemMapper.updateById(sysInfoItem);
            byId.setSort(sysInfoItemCopy.getSort());
            sysinfoitemMapper.updateById(byId);
            Map<String, Object> map1 = new HashMap<>();
            map1.put("upperInfosetCode", sysInfoItem.getInfosetCode());
            map1.put("upperCode", sysInfoItem.getCode());
            map1.put("fullDatatype", createDatatype(sysDataTypeService.getById(sysInfoItem.getDataTypeId()).getCode(), sysInfoItem.getLength(), sysInfoItem.getPrecisionSet()));
            map1.put("fieldColumn", byId.getCode());
            sysinfoitemMapper.updateColumnOrder(map1);
        });
        return Resp.ok();
    }

    public Resp bottomMoveColumn(SysInfoItem byId) {
        Map<String, Object> map = new HashMap<>();
        map.put("sort", byId.getSort());
        map.put("infosetCode", byId.getInfosetCode());
        //上一条数据
        SysInfoItem sysinfoitem = sysinfoitemMapper.searchDownData(map);
        if (!Optional.ofNullable(sysinfoitem).isPresent())
            return Resp.err("已经是最后一条记录，不能移动！");
        Optional.ofNullable(sysinfoitem).ifPresent(sysInfoItem -> {
            SysInfoItem sysInfoItemCopy = ObjectUtil.cloneIfPossible(sysInfoItem);
            sysInfoItem.setSort(byId.getSort());
            sysinfoitemMapper.updateById(sysInfoItem);
            byId.setSort(sysInfoItemCopy.getSort());
            sysinfoitemMapper.updateById(byId);
            Map<String, Object> map1 = new HashMap<>();
            map1.put("upperInfosetCode", byId.getInfosetCode());
            map1.put("upperCode", byId.getCode());
            map1.put("fullDatatype", createDatatype(sysDataTypeService.getById(byId.getDataTypeId()).getCode(), byId.getLength(), byId.getPrecisionSet()));
            map1.put("fieldColumn", sysInfoItem.getCode());
            sysinfoitemMapper.updateColumnOrder(map1);
        });
        return Resp.ok();
    }
}
