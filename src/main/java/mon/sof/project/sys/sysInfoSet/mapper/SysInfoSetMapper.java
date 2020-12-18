package mon.sof.project.sys.sysInfoSet.mapper;

import mon.sof.project.sys.sysInfoSet.entity.SysInfoSet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mon.sof.common.orm.IBaseAction;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 信息集表 Mapper 接口
 * </p>
 *
 * @author zxm
 * @since 2020-12-16
 */
public interface SysInfoSetMapper extends BaseMapper<SysInfoSet>, IBaseAction<SysInfoSet> {

    void createTable(@Param("sysInfoSet") SysInfoSet sysInfoSet);

    void dropTable(@Param("code") String code);
}
