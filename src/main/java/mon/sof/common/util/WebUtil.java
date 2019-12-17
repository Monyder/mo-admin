package mon.sof.common.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class WebUtil {
	
	/**
	 * 判断是否是ajax请求
	 * 
	 * @param httpRequest
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest httpRequest) {
		String requestType = httpRequest.getHeader("X-Requested-With");
		return requestType != null && requestType.equals("XMLHttpRequest");
	}

	/**
	 * 获取发起Http请求的客户端IP
	 * 
	 * @param httpRequest
	 * @return
	 */
	public static String parseCustomIp(HttpServletRequest httpRequest) {
		final String HEADER_X_FORWARDED_FOR = "X-FORWARDED-FOR";

		String remoteAddr = httpRequest.getRemoteAddr();
		String x = httpRequest.getHeader(HEADER_X_FORWARDED_FOR);
		if (x != null) {
			remoteAddr = x;
			int idx = remoteAddr.indexOf(',');
			if (idx > -1) {
				remoteAddr = remoteAddr.substring(0, idx);
			}
		}
		return remoteAddr;
	}

	public static String getIp(HttpServletRequest request) {
		if (request == null)
			return "";
		String ip = request.getHeader("X-Requested-For");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取HTTP请求客户端的浏览器类型
	 * 
	 * @param request
	 * @return
	 */
	public static String getBrowser(HttpServletRequest request) {
		String browser = request.getHeader("User-Agent");
		if (browser.indexOf("MSIE") > 0) {
			return "IE";
		}
		if (browser.indexOf("Firefox") > 0) {
			return "Firefox";
		}
		if (browser.indexOf("Chrome") > 0) {
			return "Chrome";
		}
		if (browser.indexOf("Safari") > 0) {
			return "Safari";
		}
		if (browser.indexOf("Camino") > 0) {
			return "Camino";
		}
		if (browser.indexOf("Gecko/") > 0) {
			return "Gecko";
		}
		return "IE";
	}

	/**
	 * android : 所有android设备 mac os : iphone ipad windows
	 * phone:Nokia等windows系统的手机 获取HTTP请求客户端的浏览器类型
	 *
	 * @return
	 */
	public static boolean isMobileDevice(String requestHeader) {
		String[] deviceArray = new String[] { "android", "mac os",
				"windows phone" };
		if (requestHeader == null)
			return false;
		requestHeader = requestHeader.toLowerCase();
		for (int i = 0; i < deviceArray.length; i++) {
			if (requestHeader.indexOf(deviceArray[i]) > 0) {
				return true;
			}
		}
		return false;
	}
}
