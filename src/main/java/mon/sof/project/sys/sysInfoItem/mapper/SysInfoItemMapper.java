package mon.sof.project.sys.sysInfoItem.mapper;

import mon.sof.project.sys.sysInfoItem.entity.SysInfoItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mon.sof.common.orm.IBaseAction;
/**
 * <p>
 * 信息项表 Mapper 接口
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
public interface SysInfoItemMapper extends BaseMapper<SysInfoItem>,IBaseAction<SysInfoItem> {

}
