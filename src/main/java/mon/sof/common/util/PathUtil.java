package mon.sof.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 获取项目路径工具
 *
 */
public class PathUtil {
	
	/**
	 * 获取webContent路径（web环境下可用）
	 * 
	 * @Title: getRealPath
	 * @Description:
	 * @return %web容器%/project/
	 */
	public static String getRealPath() {
		String basePath = PathUtil.class.getClassLoader().getResource("").getPath();
		int index = basePath.indexOf("WEB-INF");
		return basePath.substring(0, index);
	}
	/**
	 * 获取webinfo路径（web环境下可用）
	 * 
	 * @Title: getRealPath
	 * @Description:
	 * @return %web容器%/project/
	 */
	public static String getWebinfoRealPath() {
		String basePath = PathUtil.class.getClassLoader().getResource("").getPath();
		int index = basePath.indexOf("classes");
		return  basePath.substring(0, index);
	}
	
	
	/**
	 * 获取classes的路径
	 * @return
	 */
	public static String getClassPath() {
		String basePath = PathUtil.class.getClassLoader().getResource("").getPath();
		return basePath;
	}

	/**
	 * 获取项目全路径
	 * 
	 * @Title: getFullPath
	 * @Description:
	 * @param request HttpServletRequest
	 * @return http://localhost:8008/project
	 */
	public static String getFullPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
	}
	/**
	 * 追加当前日期到给定的路径后面，给定路径末尾不必带文件夹分隔符
	 * @param sPath  原路径
	 * @return
	 */
	public static String appendCurDateFilePath(String sPath) {
		String date = DateFormatUtil.getInstance("yyyy-MM-dd").format(new Date());
		String path = sPath + "/" + date;
		return path;
	}
	
	public static void main(String[] args) {
		System.out.println(getRealPath());System.out.println(getClassPath());
	}
}
