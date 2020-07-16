package mon.sof.project.legalDate.service;

import mon.sof.project.legalDate.entity.LegalDate;
import mon.sof.project.legalDate.mapper.LegalDateMapper;
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
 * @since 2020-03-17
 */
@Service
public class LegalDateService extends AbstractBaseAction<LegalDateMapper, LegalDate> {


    /**
     * 1111
     */
    @Autowired
    LegalDateMapper LegalDateMappers;

    @Override
    public IBaseAction<LegalDate> getMapper() {
        return LegalDateMappers;
    }
}
