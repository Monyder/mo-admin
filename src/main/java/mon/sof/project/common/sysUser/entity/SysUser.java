package mon.sof.project.common.sysUser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author zxm
 * @since 2020-10-15
 */
public class SysUser extends SysUserVo implements Serializable {


    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 角色id，逗号分隔存储
     */
    private Long roleId;

    /**
     * 名字
     */
    private String name;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 备注
     */
    private String remark;

    private String spareOne;

    private String spareTwo;

    private String spareThree;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "SysUser{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", roleId=" + roleId +
                ", name=" + name +
                ", phone=" + phone +
                ", remark=" + remark +
                ", spareOne=" + spareOne +
                ", spareTwo=" + spareTwo +
                ", spareThree=" + spareThree +
                "}";
    }
}
