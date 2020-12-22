package mon.sof.project.sys.sysInfoItem.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class SysInfoItemVo {

    @TableField(exist = false)
    private String dataType;

    @TableField(exist = false)
    private String nullableName;

    /**
     * 拼接好的数据类型
     */
    @TableField(exist = false)
    private String fullDataType;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getNullableName() {
        return nullableName;
    }

    public void setNullableName(String nullableName) {
        this.nullableName = nullableName;
    }

    public String getFullDataType() {
        return fullDataType;
    }

    public void setFullDataType(String fullDataType) {
        this.fullDataType = fullDataType;
    }
}
