package mon.sof.project.sys.sysUser.mapper;

import mon.sof.project.sys.sysUser.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mon.sof.common.orm.IBaseAction;
/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author zxm
 * @since 2020-10-15
 */
public interface SysUserMapper extends BaseMapper<SysUser>,IBaseAction<SysUser> {

}
