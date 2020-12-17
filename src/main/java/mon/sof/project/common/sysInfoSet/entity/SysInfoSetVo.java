package mon.sof.project.common.sysInfoSet.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class SysInfoSetVo {

    @TableField(exist = false)
    private String isSysName;

    public String getIsSysName() {
        return isSysName;
    }

    public void setIsSysName(String isSysName) {
        this.isSysName = isSysName;
    }
}
