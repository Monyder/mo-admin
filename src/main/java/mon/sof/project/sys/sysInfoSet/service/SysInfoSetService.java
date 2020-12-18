package mon.sof.project.sys.sysInfoSet.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mon.sof.project.sys.sysInfoSet.entity.SysInfoSet;
import mon.sof.project.sys.sysInfoSet.mapper.SysInfoSetMapper;
import mon.sof.common.orm.IBaseAction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.common.orm.AbstractBaseAction;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * 信息集表 服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-16
 */
@Service
public class SysInfoSetService extends AbstractBaseAction<SysInfoSetMapper, SysInfoSet> {

    @Autowired
    private SysInfoSetMapper sysinfosetMapper;

    @Override
    public IBaseAction<SysInfoSet> getMapper() {
        return sysinfosetMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public void addInfoSet(SysInfoSet sysInfoSet) {
        sysinfosetMapper.insert(sysInfoSet);
    }

    @Transactional(rollbackFor = Exception.class)
    public void createTable(SysInfoSet sysInfoSet) {
        sysinfosetMapper.createTable(sysInfoSet);
    }


    @Transactional(rollbackFor = Exception.class)
    public void delInfoSetByCode(String code) {
        QueryWrapper<SysInfoSet> sysInfoItemQueryWrapper = new QueryWrapper<>();
        sysInfoItemQueryWrapper.eq("code", code);
        sysinfosetMapper.delete(sysInfoItemQueryWrapper);
        sysinfosetMapper.dropTable(code);
    }
}
