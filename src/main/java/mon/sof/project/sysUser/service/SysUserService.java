package mon.sof.project.sysUser.service;

import mon.sof.project.sysUser.entity.SysUser;
import mon.sof.project.sysUser.mapper.SysUserMapper;
import mon.sof.common.orm.IBaseAction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.common.orm.AbstractBaseAction;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-10-15
 */
@Service
public class SysUserService extends AbstractBaseAction<SysUserMapper, SysUser> {

    @Autowired
    private SysUserMapper sysuserMapper;

    @Override
    public IBaseAction<SysUser> getMapper() {
        return sysuserMapper;
    }
}
