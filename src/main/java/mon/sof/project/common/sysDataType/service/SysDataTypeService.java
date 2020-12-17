package mon.sof.project.common.sysDataType.service;

import mon.sof.project.common.sysDataType.entity.SysDataType;
import mon.sof.project.common.sysDataType.mapper.SysDataTypeMapper;
import mon.sof.common.orm.IBaseAction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.common.orm.AbstractBaseAction;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
@Service
public class SysDataTypeService extends AbstractBaseAction<SysDataTypeMapper, SysDataType> {

    @Autowired
    private SysDataTypeMapper sysdatatypeMapper;

    @Override
    public IBaseAction<SysDataType> getMapper() {
        return sysdatatypeMapper;
    }
}
