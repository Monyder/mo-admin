package mon.sof.project.sysMenu.service;

import mon.sof.project.sysMenu.entity.SysMenu;
import mon.sof.project.sysMenu.mapper.SysMenuMapper;
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
public class SysMenuService extends AbstractBaseAction<SysMenuMapper, SysMenu> {

    @Autowired
    private SysMenuMapper sysmenuMapper;

    @Override
    public IBaseAction<SysMenu> getMapper() {
        return sysmenuMapper;
    }
}
