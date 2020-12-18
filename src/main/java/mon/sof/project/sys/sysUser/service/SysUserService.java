package mon.sof.project.sys.sysUser.service;

import mon.sof.project.sys.sysUser.entity.SysUser;
import mon.sof.project.sys.sysUser.mapper.SysUserMapper;
import mon.sof.common.orm.IBaseAction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.common.orm.AbstractBaseAction;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    public void addUser(SysUser bean) {
        sysuserMapper.insert(bean);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delUser(Long id) {
        sysuserMapper.deleteById(id);
    }
}
