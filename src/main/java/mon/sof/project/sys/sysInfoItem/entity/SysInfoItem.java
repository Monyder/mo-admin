package mon.sof.project.sys.sysInfoItem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 信息项表
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
public class SysInfoItem extends SysInfoItemVo implements Serializable {


    private static final long serialVersionUID = 1L;


      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 信息集编码
     */
    private String infosetCode;

    /**
     * 字段编码
     */
    private String code;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 数据类型
     */
    private Long dataTypeId;

    /**
     * 字段长度
     */
    private Integer length;

    /**
     * 小数点精确度
     */
    private Integer precisionSet;

    /**
     * 可否为空 必填
     */
    private Integer nullable;

    /**
     * 编码类型
     */
    private String codeType;

    /**
     * 字段注释
     */
    private String remark;

    /**
     * 是否为默认字段0是 1否
     */
    private Integer isDefault;

    /**
     * 数据库类型  目前只支持mysql
     */
    private String databaseType;

    /**
     * 序号
     */
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfosetCode() {
        return infosetCode;
    }

    public void setInfosetCode(String infosetCode) {
        this.infosetCode = infosetCode;
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

    public Long getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(Long dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPrecisionSet() {
        return precisionSet;
    }

    public void setPrecisionSet(Integer precisionSet) {
        this.precisionSet = precisionSet;
    }

    public Integer getNullable() {
        return nullable;
    }

    public void setNullable(Integer nullable) {
        this.nullable = nullable;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
