package mon.sof.project.sysLog.service;

import mon.sof.project.sysLog.entity.SysLog;
import mon.sof.project.sysLog.mapper.SysLogMapper;
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
public class SysLogService extends AbstractBaseAction<SysLogMapper, SysLog> {

    @Autowired
    private SysLogMapper syslogMapper;

    @Override
    public IBaseAction<SysLog> getMapper() {
        return syslogMapper;
    }
}
