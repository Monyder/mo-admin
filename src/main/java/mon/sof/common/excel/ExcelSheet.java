package mon.sof.common.excel;

import java.util.List;
import java.util.Map;

import jxl.Sheet;

/**
 * Title: ChinactSaaS
 * <p>
 * Description: sheet类
 * <p>
 * Copyright: Copyright (c) 2008
 * <p>
 * Company: 
 * 
 * @author TangHe
 * @version 1.0.0
 */
public class ExcelSheet {
	/**
	 * 行对象
	 */
	private ExcelRow excelRow = null;
	/**
	 * sheet索引
	 */
	private int sheetIndex = 0;
	/**
	 * sheet标题
	 */
	private String sheetTitle;
	/**
	 * 标题行索引（从0开始算起）
	 */
	private int titleRowIndex = 2;

	/**
	 * 内容
	 */
	private List<?> contentObjects;
	private List<Map<String, Object>> contentMaps;
	/**
	 * 映射类
	 */
	private Class mapperClass;
	
	private Sheet sheet;

	/**
	 * 构造方法
	 * 
	 * @throws SystemErrorExcetion
	 *             自定义异常
	 */
	public ExcelSheet(int index) {
		this.sheetIndex = index;
	}

	/**
	 * 获取行
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:02:42
	 * @return 行
	 * @throws SystemErrorExcetion
	 *             自定义异常
	 */
	public ExcelRow getRow() {
		if (excelRow == null) {
			excelRow = new ExcelRow();
		}
		return excelRow;
	}

	/**
	 * 获取sheet索引
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:02:50
	 * @return 索引
	 */
	public int getSheetIndex() {
		return sheetIndex;
	}

	public String getSheetTitle() {
		return sheetTitle;
	}

	public void setSheetTitle(String sheetTitle) {
		this.sheetTitle = sheetTitle;
	}

	public List<?> getContentObjects() {
		return contentObjects;
	}

	/**
	 * 新的设置sheet内容的方法比较简单但是耗性能
	 * 
	 * @author TangHe
	 * @date 2013年11月15日 下午4:38:57
	 * @param contentObjects
	 *            内容
	 */
	public void setContentObjects(List<?> contentObjects) {
		this.contentObjects = contentObjects;
	}

	public List<Map<String, Object>> getContentMaps() {
		return contentMaps;
	}

	public void setContentMaps(List<Map<String, Object>> contentMaps) {
		this.contentMaps = contentMaps;
	}

	public Class getMapperClass() {
		return mapperClass;
	}

	/**
	 * 设置映射类
	 * 
	 * @author TangHe
	 * @date 2013年11月15日 下午4:40:03
	 * @param mapperClass
	 *            映射类
	 */
	public void setMapperClass(Class mapperClass) {
		this.mapperClass = mapperClass;
	}
	/**
	 * 标题行索引（从0开始算起）
	 */
	public int getTitleRowIndex() {
		return titleRowIndex;
	}
	/**
	 * 标题行索引（从0开始算起）
	 */
	public void setTitleRowIndex(int titleRowIndex) {
		this.titleRowIndex = titleRowIndex;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

}
