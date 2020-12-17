package mon.sof.project.common.sysMenu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zxm
 * @since 2020-10-15
 */
public class SysMenu extends SysMenuVo implements Serializable {


    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String nodeName;

    /**
     * 上级菜单ID
     */
    private Long nodePid;

    /**
     * 排序号
     */
    private Integer roderCode;

    /**
     * 节点类型，0菜单，1按钮；按钮不能有下级菜单
     */
    private Integer nodeType;

    /**
     * 节点路径
     */
    private String nodePath;

    /**
     * 节点组件
     */
    private String nodeComponent;

    /**
     * 节点图标
     */
    private String nodeIconcls;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 预留字段1
     */
    private String spareOne;

    /**
     * 预留字段2
     */
    private String spareTwo;

    /**
     * 预留字段3
     */
    private String spareThree;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Long getNodePid() {
        return nodePid;
    }

    public void setNodePid(Long nodePid) {
        this.nodePid = nodePid;
    }

    public Integer getRoderCode() {
        return roderCode;
    }

    public void setRoderCode(Integer roderCode) {
        this.roderCode = roderCode;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodePath() {
        return nodePath;
    }

    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }

    public String getNodeComponent() {
        return nodeComponent;
    }

    public void setNodeComponent(String nodeComponent) {
        this.nodeComponent = nodeComponent;
    }

    public String getNodeIconcls() {
        return nodeIconcls;
    }

    public void setNodeIconcls(String nodeIconcls) {
        this.nodeIconcls = nodeIconcls;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSpareOne() {
        return spareOne;
    }

    public void setSpareOne(String spareOne) {
        this.spareOne = spareOne;
    }

    public String getSpareTwo() {
        return spareTwo;
    }

    public void setSpareTwo(String spareTwo) {
        this.spareTwo = spareTwo;
    }

    public String getSpareThree() {
        return spareThree;
    }

    public void setSpareThree(String spareThree) {
        this.spareThree = spareThree;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", nodeName=" + nodeName +
                ", nodePid=" + nodePid +
                ", roderCode=" + roderCode +
                ", nodeType=" + nodeType +
                ", nodePath=" + nodePath +
                ", nodeComponent=" + nodeComponent +
                ", nodeIconcls=" + nodeIconcls +
                ", remarks=" + remarks +
                ", spareOne=" + spareOne +
                ", spareTwo=" + spareTwo +
                ", spareThree=" + spareThree +
                "}";
    }
}
