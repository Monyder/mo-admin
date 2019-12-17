package mon.sof.common.excel;

import mon.sof.common.util.PathUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public  class ImportExcel {

    private static Logger log = LoggerFactory.getLogger(ImportExcel.class);


    public List<Map<String,Object>> faceUp(MultipartFile file) throws Exception {
        String excelPath = PathUtil.getClassPath()
                + getFileName("temp" + File.separator + "excel", file.getOriginalFilename());
        file.transferTo(new File(excelPath));
        File excel = new File(excelPath);
        List<Map<String,Object>> excelList = new ArrayList<>();
        if (excel.isFile() && excel.exists()) {   //判断文件是否存在

            String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
            Workbook wb;
            //根据文件后缀（xls/xlsx）进行判断
            if ( "xls".equals(split[1])){
                FileInputStream fis = new FileInputStream(excel);   //文件流对象
                wb = new HSSFWorkbook(fis);
            }else if ("xlsx".equals(split[1])){
                wb = new XSSFWorkbook(OPCPackage.open(excel));
            }else {
                throw new IOException("文件类型错误！");
            }

            //开始解析
            Sheet sheet = wb.getSheetAt(0);     //读取sheet 0
            int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
            int lastRowIndex = sheet.getLastRowNum();
            for(int i = firstRowIndex; i <= lastRowIndex; i++) {   //遍历行
                Row row = sheet.getRow(i);
                if (row != null) {
                    Map<String, Object> map = new HashMap<>();
                    for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {   //遍历列
                        Cell column = row.getCell(j);
                        if (column != null) {
                            String cellValue = null;
                            if("xls".equals(split[1])){
                                 cellValue = getCellValue((HSSFCell) column);
                            }else if("xlsx".equals(split[1])){
                                 cellValue = getXssCellValue((XSSFCell) column);
                            }
                            log.debug("key++++"+sheet.getRow(0).getCell(j).toString());
                            log.debug("value++++"+cellValue);
                            //map.put(sheet.getRow(0).getCell(j).toString(),column.toString());
                            map.put(sheet.getRow(0).getCell(j).toString(),cellValue);
                        }else{
                            throw new IOException("excel文件第["+column.getColumnIndex()+1+"]行有错误！");
                        }
                    }
                    excelList.add(map);
                }
            }

        } else {
            throw new IOException("未找到文件！");
        }
        return excelList;
    }

    /**
     * 获得Hsscell内容
     *
     * @param cell
     * @return
     */
    public String getCellValue(HSSFCell cell) {
        String value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_FORMULA:
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    DecimalFormat df = new DecimalFormat("0");
                    value = df.format(cell.getNumericCellValue());
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue().trim();
                    break;
                default:
                    value = "";
                    break;
            }
        }
        return value.trim();
    }

    public String getXssCellValue(XSSFCell cell) {
        String value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_FORMULA:
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
                    DecimalFormat df = new DecimalFormat("0");
                    value = df.format(cell.getNumericCellValue());
                    break;
                case XSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue().trim();
                    break;
                default:
                    value = "";
                    break;
            }
        }
        return value.trim();
    }


    // 返回文件的相对路径
    private String getFileName(String type, String title) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat fileFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        StringBuilder fileName = new StringBuilder();
        StringBuilder fileDir = new StringBuilder();

        Date now = new Date();

        fileName.append(fileFormat.format(now)).append(title.substring(title.lastIndexOf(".")));

        fileDir.append("/upload").append("/").append(type).append("/").append(dateFormat.format(now));
        //fileDir.append("/upload");
        String filePath = fileDir.toString();

        String basePath = this.getClass().getClassLoader().getResource("").getPath();
		/*int index = basePath.indexOf("classes");
		String realPath = basePath.substring(0, index);*/

        String realPath = basePath.substring(1) + filePath;
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return filePath + "/" + fileName;
    }
}
