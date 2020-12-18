package mon.sof.project.sys.sysInfoItem.service;

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
        sysInfoItem.setOrders(1);
        sysinfoitemMapper.insert(sysInfoItem);
    }
}
