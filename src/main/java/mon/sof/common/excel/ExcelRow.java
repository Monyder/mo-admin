package mon.sof.common.excel;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: ChinactSaaS
 * <p>
 * Description: 列工具
 * <p>
 * Copyright: Copyright (c) 2008
 * <p>
 * Company: 
 * 
 * @author TangHe
 * @version 1.0.0
 */
public class ExcelRow {
	/**
	 * 列
	 */
	private Map<Integer, ExcelColumn> excelColumns = new HashMap<Integer, ExcelColumn>();

	/**
	 * 获取列
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:03:52
	 * @param index
	 *            列索引
	 * @return 列
	 */
	public ExcelColumn getColumn(int index) {
		if (excelColumns.get(index) == null) {
			excelColumns.put(index, new ExcelColumn(index));
		}

		return excelColumns.get(index);
	}

	/**
	 * 获取当前行的所有列
	 * 
	 * @author TangHe
	 * @date 2013年11月14日 下午3:04:06
	 * @return 所有列
	 */
	public Map<Integer, ExcelColumn> getExcelColumns() {
		return excelColumns;
	}

}
