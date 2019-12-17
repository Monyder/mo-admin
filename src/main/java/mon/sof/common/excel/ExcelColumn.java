package mon.sof.common.excel;

import java.util.ArrayList;
import java.util.List;

public class ExcelColumn {
	/**
	 * 列索引
	 */
	private int index;
	/**
	 * 列名
	 */
	private String name;
	/**
	 * 是否关联文件
	 */
	private boolean isUnionFile = false;
	/**
	 * 文件后缀
	 */
	private String suffix;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 不可为空
	 */
	private boolean isNotNull;
	/**
	 * 长度
	 */
	private int dataLength;
	/**
	 * 校验规则
	 */
	private List<ExcelUtil.Validator> validators;
	/**
	 * 
	 */
	private ExcelUtil.Formatter formatter;
	/**
	 * 是否必填
	 */
	private boolean required = false;

	/**
	 * 构造方法
	 * 
	 * @param index
	 *            索引
	 */
	public ExcelColumn(int index) {
		this.index = index;
	}

	/**
	 * 获得列名
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:04:49
	 * @return 列名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置列名
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:05:07
	 * @param name
	 *            列明
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取列索引
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:05:19
	 * @return 列索引
	 */
	public int getIndex() {
		return index;
	}

	public boolean isUnionFile() {
		return isUnionFile;
	}

	public void setUnionFile(boolean isUnionFile) {
		this.isUnionFile = isUnionFile;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isNotNull() {
		return isNotNull;
	}

	public void setNotNull(boolean isNotNull) {
		this.isNotNull = isNotNull;
	}

	public int getDataLength() {
		return dataLength;
	}

	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}

	public List<ExcelUtil.Validator> getValidators() {
		return validators;
	}

	public void setValidators(List<ExcelUtil.Validator> validators) {
		this.validators = validators;
	}

	public void setValidator(ExcelUtil.Validator validator) {
		this.validators = new ArrayList<ExcelUtil.Validator>();
		this.validators.add(validator);
	}

	public ExcelUtil.Formatter getFormatter() {
		return formatter;
	}

	public void setFormatter(ExcelUtil.Formatter formatter) {
		this.formatter = formatter;
	}

	public boolean getRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}
