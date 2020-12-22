package mon.sof.project.sys.sysInfoItem.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 信息项表 服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
@Service
public class SysInfoItemService extends AbstractBaseAction<SysInfoItemMapper, SysInfoItem> {

    @Autowired
    private SysInfoItemMapper sysinfoitemMapper;

    @Autowired
    private SysDataTypeService sysDataTypeService;

    @Override
    public IBaseAction<SysInfoItem> getMapper() {
        return sysinfoitemMapper;
    }

    @Transactional(rollbackFor = Exception.class)
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

    @Transactional(rollbackFor = Exception.class)
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

    @Transactional(rollbackFor = Exception.class)
    public void addInfoItem(SysInfoItem sysInfoItem) {
        sysInfoItem.setNullable(NullableEnum.NO.getCode());
        sysinfoitemMapper.insert(sysInfoItem);
        sysInfoItem.setSort(sysInfoItem.getId().intValue());
        sysinfoitemMapper.updateById(sysInfoItem);
    }

    @Transactional(rollbackFor = Exception.class)
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


}
