package mon.sof.project.sysLog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
public class SysLog implements Serializable {


    private static final long serialVersionUID=1L;


      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date operatingTime;

    /**
     * 操作ip
     */
    private String ip;

    /**
     * 操作功能
     */
    private String func;

    /**
     * 备注
     */
    private String remarks;

    private String spareOne;

    private String spareTwo;

    private String spareThree;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(Date operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
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
        return "SysLog{" +
        "id=" + id +
        ", operator=" + operator +
        ", operatingTime=" + operatingTime +
        ", ip=" + ip +
        ", func=" + func +
        ", remarks=" + remarks +
        ", spareOne=" + spareOne +
        ", spareTwo=" + spareTwo +
        ", spareThree=" + spareThree +
        "}";
    }
}
