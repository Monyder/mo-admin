package mon.sof.project.sysMenu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysMenuVo {

    @TableField(exist = false)
    private Long[] ids;

    @TableField(exist = false)
    private String nodePidName;

    @TableField(exist = false)
    private String nodeTypeName;

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

    public String getNodePidName() {
        return nodePidName;
    }

    public void setNodePidName(String nodePidName) {
        this.nodePidName = nodePidName;
    }

    public String getNodeTypeName() {
        return nodeTypeName;
    }

    public void setNodeTypeName(String nodeTypeName) {
        this.nodeTypeName = nodeTypeName;
    }
}
