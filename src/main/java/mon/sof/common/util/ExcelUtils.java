package mon.sof.common.util;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangtc
 */
public class ExcelUtils {
	
	public static Map<Integer, String> findEnum(Class<?> clazz) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		try {
			Method getCode = clazz.getMethod("getCode");
			Method getName = clazz.getMethod("getName");
			
			// 得到enum的所有实例
			Object[] objs = clazz.getEnumConstants();
			
			for (Object obj : objs) {
				map.put((Integer) getCode.invoke(obj), (String) getName.invoke(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * 导出数据
	 * 
	 * @param templateFileName 模板文件位置
	 * @param targetFile 目标位置
	 */
	public static void generateExcel(String templateFileName, String targetFile, Map<String, Object> dataMap) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(templateFileName);
			XLSTransformer transformer = new XLSTransformer();
			HSSFWorkbook workBook = (HSSFWorkbook) transformer.transformXLS(is, dataMap);
			os = new FileOutputStream(targetFile);
			workBook.write(os);
			os.flush();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * 下载文件
	 */
	public static void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filename = request.getParameter("name");
		String conditionPath = request.getParameter("path");
		
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
				// firefox浏览器
				filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
			} else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
				// IE浏览器
				filename = URLEncoder.encode(filename, "UTF-8");
			} else {
				// IE浏览器
				filename = URLEncoder.encode(filename, "UTF-8");
			}
			
			response.reset();
			response.setContentType("unknown");
			response.setHeader("Content-Disposition", "attachment; filename=" + filename.replace(" ", ""));
			os = response.getOutputStream();
			fis = new FileInputStream(conditionPath);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = fis.read(b)) > 0) {
				os.write(b, 0, i);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			fis.close();
			os.flush();
			os.close();
			new File(conditionPath).delete();
		}
	}
	
}
