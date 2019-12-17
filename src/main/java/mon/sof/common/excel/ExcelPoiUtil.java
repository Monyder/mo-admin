package mon.sof.common.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 用poi处理excel的工具类
 * 
 * @author zhangxiaomei
 * @created 2014-12-21 下午5:00:36
 * @since v1.0
 * @see
 */
public class ExcelPoiUtil {
	/**
	 * 创建空文档
	 * 
	 * @created 2014年12月29日19:30:14
	 * @since v1.0
	 */
	public static HSSFWorkbook create() {
		HSSFWorkbook workbook = null;
		workbook = new HSSFWorkbook();
		return workbook;
	}

	/**
	 * 根据模板创建文档
	 * 
	 * @param templatePath
	 *            文档路径 如 F:/test.xls
	 * @created 2014-12-21 下午5:00:36
	 * @since v1.0
	 */
	public static HSSFWorkbook create(String templatePath) {
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(new FileInputStream(templatePath));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return workbook;
	} 
    /**
     * 读excel
     * 2018年6月21日14:51:58
     * @author zhangtc
     * @param path
     * @return
     */
    public static List<Map<String,Object>>  readXls(String path){
        InputStream is;
        XSSFWorkbook xssfWorkbook = null;
		try {
			is = new FileInputStream(path);
			xssfWorkbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Map<String,Object>> resultMapList = new ArrayList<Map<String,Object>>();
        //Sheet
    	XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        Map<String,Object> resultMap = null;
        // 循环行Row
	    for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
        	XSSFRow  xssfRow  = xssfSheet.getRow(rowNum);
        	if (xssfRow == null) {
                 continue;
            }
    		for(int column=0;column<xssfRow.getLastCellNum();column++){
    			Cell cell = xssfRow.getCell(column,Row.CREATE_NULL_AS_BLANK);
    			resultMap = new HashMap<String,Object>();
    			switch(cell.getCellType()){
    			case Cell.CELL_TYPE_BLANK:
    				resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), "");
    				break;
    			case Cell.CELL_TYPE_BOOLEAN:
    				resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), Boolean.toString(cell.getBooleanCellValue()));
    				break;
    			case Cell.CELL_TYPE_ERROR:
    				resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), "");
    				break;
    			case Cell.CELL_TYPE_FORMULA:
    				cell.setCellType(Cell.CELL_TYPE_STRING);
    				resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), cell.getStringCellValue());
    				break;
    			case Cell.CELL_TYPE_NUMERIC:
    				if (DateUtil.isCellDateFormatted(cell)) {
    					resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), String.valueOf(cell.getDateCellValue()));
    				} else {
    					cell.setCellType(Cell.CELL_TYPE_STRING);
    					String temp = cell.getStringCellValue();
    					// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
    					if (temp.indexOf(".") > -1) {
    						resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), String.valueOf(new Double(temp)).trim());
    					} else {
    						resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), temp.trim());
    					}
    				}
    				break;
    			case Cell.CELL_TYPE_STRING:
    				resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), cell.getStringCellValue().trim());
    				break;
    			default:
    				resultMap.put(xssfSheet.getRow(0).getCell(column).getStringCellValue(), "");
    				break;
    			}
    			resultMapList.add(resultMap);
    		}
        }
        return resultMapList;
    }
    
    public static void main(String[] args) {
    	//读取xlsx
        List<Map<String, Object>> resultMapList = readXls("C:\\Users\\liye\\Desktop\\demo.xlsx");
        for(int n=0;n<resultMapList.size();n++){
        	Map<String, Object> resultMap = resultMapList.get(n);
        	for (String key : resultMap.keySet()) {  
    		   System.out.println(resultMap.get(key));  
            } 
        }
	}
}
