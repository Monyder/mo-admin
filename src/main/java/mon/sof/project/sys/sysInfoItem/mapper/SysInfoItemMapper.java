package mon.sof.project.sys.sysInfoItem.mapper;

import mon.sof.project.sys.sysInfoItem.entity.SysInfoItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mon.sof.common.orm.IBaseAction;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信息项表 Mapper 接口
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
public interface SysInfoItemMapper extends BaseMapper<SysInfoItem>, IBaseAction<SysInfoItem> {

    void createColumn(@Param("sysInfoItem") SysInfoItem sysInfoItem);

    void dropColumn(@Param("params") Map<String, Object> map);

    void modifyColumn(@Param("sysInfoItem") SysInfoItem sysInfoItem);

    SysInfoItem searchUpData(@Param("params") Map<String, Object> map);

    void updateColumnOrder(@Param("params") Map<String, Object> map1);

    SysInfoItem searchDownData(@Param("params") Map<String, Object> map);
}
