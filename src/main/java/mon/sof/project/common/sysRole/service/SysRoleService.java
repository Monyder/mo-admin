package mon.sof.project.common.sysRole.service;

import mon.sof.project.common.sysRole.entity.SysRole;
import mon.sof.project.common.sysRole.mapper.SysRoleMapper;
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
 * @since 2020-10-15
 */
@Service
public class SysRoleService extends AbstractBaseAction<SysRoleMapper, SysRole> {

    @Autowired
    private SysRoleMapper sysroleMapper;

    @Override
    public IBaseAction<SysRole> getMapper() {
        return sysroleMapper;
    }
}
