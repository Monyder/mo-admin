package mon.sof.project.sysUser.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class SysUserVo {

    @TableField(exist = false)
    private String roleIdName;

    public String getRoleIdName() {
        return roleIdName;
    }

    public void setRoleIdName(String roleIdName) {
        this.roleIdName = roleIdName;
    }
}
