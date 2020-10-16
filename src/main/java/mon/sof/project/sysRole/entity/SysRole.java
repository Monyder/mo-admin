package mon.sof.project.sysRole.entity;

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
public class SysRole extends SysRoleVo implements Serializable {


    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色
     */
    private String name;

    /**
     * 角色状态，0有效1无效
     */
    private Integer status;

    /**
     * 存储目录表主键 逗号分隔
     */
    private String menuIds;

    /**
     * 0 可读可写，1读
     */
    private Integer authority;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer orders;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = menuIds;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", code=" + code +
                ", name=" + name +
                ", status=" + status +
                ", menuIds=" + menuIds +
                ", authority=" + authority +
                ", remark=" + remark +
                ", orders=" + orders +
                "}";
    }
}
