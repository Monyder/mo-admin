package mon.sof.project.sysRole.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRoleVo {

    @TableField(exist = false)
    private Long[] ids;

    @TableField(exist = false)
    private String statusName;

    @TableField(exist = false)
    private String authorityName;

    @TableField(exist = false)
    private String isAreaName;


    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getIsAreaName() {
        return isAreaName;
    }

    public void setIsAreaName(String isAreaName) {
        this.isAreaName = isAreaName;
    }
}
