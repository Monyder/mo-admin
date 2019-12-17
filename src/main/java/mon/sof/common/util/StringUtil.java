package mon.sof.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.IDN;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 字符串工具类
 *
 */
public class StringUtil {

	/**
	 * 空值
	 */
	public static final String EMPTY = "";

	private static final String DEFAULT_SEPERATOR = ",";

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	/**
	 * 判断字符串不为空
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !(str == null || str.length() == 0);
	}

	/**
	 * 判断去掉首尾空格后的字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static boolean isEmptyAfterTrim(String str) {
		return isEmpty(str) || str.trim().length() == 0;
	}

	/**
	 * 得到指定分割符之前的str（str中左起第一个分割符之前）
	 * 
	 * @param str 源字符串
	 * @param separator 分割符
	 * @return 指定分割符之前的str
	 */
	public static String substringBefore(String str, String separator) {
		if (isEmptyAfterTrim(str) || separator == null)
			return str;
		if (separator.length() == 0)
			return EMPTY;
		int pos = indexOfIgnoreCase(str, separator);
		if (pos == -1)
			return str;
		return str.substring(0, pos);
	}

	/**
	 * 得到指定分割符之后的str（str中左起第一个分割符之后）
	 * 
	 * @param str 源字符串
	 * @param separator 分割符
	 * @return 指定分割符之后的str
	 */
	public static String substringAfter(String str, String separator) {
		if (str == null || str.trim().equals(EMPTY))
			return str;
		if (separator == null)
			return EMPTY;
		int pos = indexOfIgnoreCase(str, separator);
		if (pos == -1)
			return EMPTY;
		return str.substring(pos + separator.length());
	}

	/**
	 * 得到搜索字符在str中的位置下标（左起第一个，大小写不敏感）
	 * 
	 * @param str
	 *            源字符串
	 * @param searchStr
	 *            要搜索的字符串
	 * @return 搜索字符在str中的位置下标（左起第一个）
	 */
	public static int indexOfIgnoreCase(String str, String searchStr) {
		return indexOfIgnoreCase(str, searchStr, 0);
	}

	/**
	 * 得到搜索字符在str中的位置下标（左起startPos个字符之后，大小写不敏感）
	 * 
	 * @param str
	 *            源字符串
	 * @param searchStr
	 *            要搜索的字符串
	 * @param startPos
	 *            搜索开始位置
	 * @return 得到搜索字符在str中的位置下标（左起startPos个字符之后）
	 */
	public static int indexOfIgnoreCase(String str, String searchStr,
			int startPos) {
		int spos = startPos;
		if (str == null || searchStr == null)
			return -1;
		if (spos < 0) {
			spos = 0;
		}
		int endLimit = (str.length() - searchStr.length()) + 1;
		if (spos > endLimit)
			return -1;
		if (searchStr.length() == 0)
			return spos;
		for (int i = spos; i < endLimit; i++) {
			if (str.regionMatches(true, i, searchStr, 0, searchStr.length()))
				return i;
		}
		return -1;
	}

	/**
	 * 将字符串以separator分割成数组返回
	 * 
	 * @param str
	 *            待操作的字符串
	 * @param separator
	 *            分割符
	 * @return 分割后的数组
	 * 
	 */
	public static String[] split2Array(String str, String separator) {
		if (StringUtil.isEmptyAfterTrim(str)) {
			return new String[0];
		}
		if (StringUtil.isEmpty(separator)) {
			return StringUtils.split(str, DEFAULT_SEPERATOR);
		} else {
			return StringUtils.split(str, separator);
		}
	}

	/**
	 * 将字符串数组拼接成字符串
	 * 
	 * @param strArray
	 *            字符串数组
	 * @param separator
	 *            分隔符
	 * @return
	 * 
	 */
	public static String combineToString(String[] strArray, String separator) {
		StringBuilder result = new StringBuilder();
		for (String str : strArray) {
			result.append(str).append(separator);
		}
		if (result.length() > 0) {
			result.setLength(result.length() - 1);
		}
		return result.toString();
	}

	/**
	 * 将字符串List拼接成字符串
	 * 
	 * @param strList
	 *            字符串List
	 * @param separator
	 *            分隔符
	 * @return
	 * 
	 */
	public static String combineToString(List<String> strList, String separator) {
		return combineToString(strList.toArray(new String[strList.size()]),
				separator);
	}

	/**
	 * 获取经Punycode编码前的字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String toUnicode(String str) {
		return str == null ? null : IDN.toUnicode(str);
	}

	/**
	 * 获取经Punycode编码前的字符串集合
	 * 
	 * @param array
	 * @return
	 */
	public static List<String> toUnicode(String[] array) {
		List<String> result = new ArrayList<String>();
		for (String str : array) {
			result.add(str == null ? null : IDN.toUnicode(str));
		}
		return result;
	}

	/**
	 * 获取经Punycode编码前的字符串集合
	 * 
	 * @param array
	 * @return
	 */
	public static String[] toUnicodeForArray(String[] array) {
		if (array == null) {
			return null;
		}
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i] == null ? null : IDN.toUnicode(array[i]);
		}
		return result;
	}

	/**
	 * 实体toString
	 * 
	 * @param bean
	 * @return
	 */
	public static String toStringFromBean(Object bean) {
		if (bean == null) {
			return null;
		}
		return ToStringBuilder
				.reflectionToString(bean, DateStyle.getInstance());
	}

	/**
	 * 日期类型转换
	 *
	 * @see
	 */
	private static class DateStyle extends ToStringStyle {

		private static final long serialVersionUID = 7960393990252319916L;

		private static ToStringStyle instance = new DateStyle();

		public static ToStringStyle getInstance() {
			return instance;
		}

		public DateStyle() {
			super();
			this.setContentStart("[");
			this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
			this.setFieldSeparatorAtStart(true);
			this.setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
		}

		@Override
		protected void appendDetail(StringBuffer buffer, String fieldName,
				Object value) {
			if (value instanceof Date) {
				value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(value);
			}
			buffer.append(value);
		}

	}

	
	/**
	 * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
	 * 例如：helloWorld->HELLO_WORLD
	 * @param name 转换前的驼峰式命名的字符串
	 * @return 转换后下划线大写方式命名的字符串
	 */
	public static String underscoreName(String name) {
	    StringBuilder result = new StringBuilder();
	    if (name != null && name.length() > 0) {
	        // 将第一个字符处理成大写
	        result.append(name.substring(0, 1).toUpperCase());
	        // 循环处理其余字符
	        for (int i = 1; i < name.length(); i++) {
	            String s = name.substring(i, i + 1);
	            // 在大写字母前添加下划线
	            if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
	                result.append("_");
	            }
	            // 其他字符直接转成大写
	            result.append(s.toUpperCase());
	        }
	    }
	    return result.toString();
	}
	 
	/**
	 * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
	 * 例如：HELLO_WORLD->helloWorld
	 * @param name 转换前的下划线大写方式命名的字符串
	 * @return 转换后的驼峰式命名的字符串
	 */
	public static String camelName(String name) {
	    StringBuilder result = new StringBuilder();
	    // 快速检查
	    if (name == null || name.isEmpty()) {
	        // 没必要转换
	        return "";
	    } else if (!name.contains("_")) {
	        // 不含下划线，仅将首字母小写
	        return name.substring(0, 1).toLowerCase() + name.substring(1);
	    }
	    // 用下划线将原始字符串分割
	    String camels[] = name.split("_");
	    for (String camel :  camels) {
	        // 跳过原始字符串中开头、结尾的下换线或双重下划线
	        if (camel.isEmpty()) {
	            continue;
	        }
	        // 处理真正的驼峰片段
	        if (result.length() == 0) {
	            // 第一个驼峰片段，全部字母都小写
	            result.append(camel.toLowerCase());
	        } else {
	            // 其他的驼峰片段，首字母大写
	            result.append(camel.substring(0, 1).toUpperCase());
	            result.append(camel.substring(1).toLowerCase());
	        }
	    }
	    return result.toString();
	}
	
	/**
	 * 异常转成字符串,并带有详细的堆栈信息
	 * 
	 * @param throwable
	 * @return
	 */
	public static String toStringFromThrowableWithStackTrace(Throwable throwable) {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();

	}
	
	
	

	public static String nvl(String expr1) {
		return expr1 == null ? "" : expr1;
	}

	public static String nvl(String expr1, String expr2) {
		return expr1 == null ? expr2 : expr1;
	}
	
	public static String firstCharUpperCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	public static String firstCharLowerCase(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}
}
