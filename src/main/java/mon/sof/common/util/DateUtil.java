package mon.sof.common.util;

import org.apache.commons.lang.time.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	/**
	 * 一天的毫秒数
	 */
	private static final long msOfOneDay = 1000 * 60 * 60 * 24L; 
	
	/**
	 * 获取一天的毫秒数
	 * @return
	 */
	public static long getMsOfOneDay(){
		return msOfOneDay;
	}
	/**
	 * 获取一年中最小的时间
	 * 
	 * @param year
	 * @return
	 */
	public static Date getMinOfYear(int year) {
		Date date = new Date(0);
		date = DateUtils.setYears(date, Integer.valueOf(year));
		date = DateUtils.setMonths(date, 0);
		date = DateUtils.setDays(date, 1);
		date = DateUtils.setHours(date, 0);
		date = DateUtils.setMinutes(date, 0);
		date = DateUtils.setMilliseconds(date, 0);
		return date;
	}

	/**
	 * 获取一月中最小的时间
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getMinOfMonth(int year, int month) {
		Date date = new Date(0);
		date = DateUtils.setYears(date, Integer.valueOf(year));
		date = DateUtils.setMonths(date, month - 1);
		date = DateUtils.setDays(date, 1);
		date = DateUtils.setHours(date, 0);
		date = DateUtils.setMinutes(date, 0);
		date = DateUtils.setMilliseconds(date, 0);
		return date;
	}

	/**
	 * 获取一月中最大的时间
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getMaxOfMonth(int year, int month) {
		Date endDate = new Date(0);
		endDate = DateUtils.setYears(endDate, Integer.valueOf(year));
		endDate = DateUtils.addMonths(endDate, month);
		endDate = DateUtils.setDays(endDate, 1);
		endDate = DateUtils.setHours(endDate, 0);
		endDate = DateUtils.setMinutes(endDate, 0);
		endDate = DateUtils.setMilliseconds(endDate, 0);
		endDate = DateUtils.addMilliseconds(endDate, -1);

		return endDate;
	}

	/**
	 * 获取一天中最小的时间
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getMinOfDay(int year, int month, int day) {
		Date date = new Date(0);
		date = DateUtils.setYears(date, Integer.valueOf(year));
		date = DateUtils.setMonths(date, month - 1);
		date = DateUtils.setDays(date, day);
		date = DateUtils.setHours(date, 0);
		date = DateUtils.setSeconds(date, 0);
		date = DateUtils.setMinutes(date, 0);
		date = DateUtils.setMilliseconds(date, 0);
		return date;
	}

	/**
	 * 获取一天中最大的时间
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getMaxOfDay(int year, int month, int day) {
		Date endDate = new Date(0);
		endDate = DateUtils.setYears(endDate, Integer.valueOf(year));
		endDate = DateUtils.addMonths(endDate, month - 1);
		endDate = DateUtils.setDays(endDate, day + 1);
		endDate = DateUtils.setHours(endDate, 0);
		endDate = DateUtils.setMinutes(endDate, 0);
		endDate = DateUtils.setSeconds(endDate, 0);
		endDate = DateUtils.setMilliseconds(endDate, 0);
		endDate = DateUtils.addMilliseconds(endDate, -1);
		return endDate;
	}
	
	/**
	 * 获取一天中最大的时间
	 * 
	 * @return
	 */
	public static Date getMaxOfDay(Date date) {
		date = DateUtils.setHours(date, 0);
		date = DateUtils.setMinutes(date, 0);
		date = DateUtils.setSeconds(date, 0);
		date = DateUtils.setMilliseconds(date, 0);
		date = DateUtils.addMilliseconds(date, (int)getMsOfOneDay()-1);
		return date;
	}
	
	/**
	 * 获取一天中最小的时间
	 * 
	 * @return
	 */
	public static Date getMinOfDay(Date date) {
		date = DateUtils.setHours(date, 0);
		date = DateUtils.setMinutes(date, 0);
		date = DateUtils.setSeconds(date, 0);
		date = DateUtils.setMilliseconds(date, 0);
		return date;
	}
	
	
	/**
	 * 获取一年中最大的时间
	 * 
	 * @param year
	 * @return
	 */
	public static Date getMaxOfYear(int year) {
		Date endData = new Date(0);
		endData = DateUtils.setYears(endData, Integer.valueOf(year));
		endData = DateUtils.setMonths(endData, 0);
		endData = DateUtils.setDays(endData, 1);
		endData = DateUtils.setHours(endData, 0);
		endData = DateUtils.setMinutes(endData, 0);
		endData = DateUtils.setMilliseconds(endData, 0);
		endData = DateUtils.addYears(endData, 1);
		endData = DateUtils.addMilliseconds(endData, -1);

		return endData;
	}

	/**
	 * 获取一个日期的月份
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getMonthOfDate(Date date) {
		Calendar calendar = DateUtils.toCalendar(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取一个日期的年份
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getYearOfDate(Date date) {
		Calendar calendar = DateUtils.toCalendar(date);
		return calendar.get(Calendar.YEAR);
	}

	public static Integer getDayOfDate(Date date) {
		Calendar calendar = DateUtils.toCalendar(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 给日期加上一天可以为负数
	 * 
	 * @Title: addDay
	 * @Description:
	 * @param day
	 *            需要加的天数，如果是昨天则为-1
	 * @return 处理过的日期
	 */
	public static Date addDay(Date date, Integer day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的季度开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentQuarterStartDate(Date date) {
		Calendar c = DateUtils.toCalendar(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		if (currentMonth >= 1 && currentMonth <= 3)
			c.set(Calendar.MONTH, 0);
		else if (currentMonth >= 4 && currentMonth <= 6)
			c.set(Calendar.MONTH, 3);
		else if (currentMonth >= 7 && currentMonth <= 9)
			c.set(Calendar.MONTH, 4);
		else if (currentMonth >= 10 && currentMonth <= 12)
			c.set(Calendar.MONTH, 9);
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取季度结束日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentQuarterEndDate(Date date) {
		Calendar c = DateUtils.toCalendar(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		if (currentMonth >= 1 && currentMonth <= 3) {
			c.set(Calendar.MONTH, 2);
			c.set(Calendar.DATE, 31);
		} else if (currentMonth >= 4 && currentMonth <= 6) {
			c.set(Calendar.MONTH, 5);
			c.set(Calendar.DATE, 30);
		} else if (currentMonth >= 7 && currentMonth <= 9) {
			c.set(Calendar.MONTH, 8);
			c.set(Calendar.DATE, 30);
		} else if (currentMonth >= 10 && currentMonth <= 12) {
			c.set(Calendar.MONTH, 11);
			c.set(Calendar.DATE, 31);
		}

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 遇到周六日返回顺延后的日期
	 * @param date
	 * @return
	 */
	public static Date postponeSatAndSun(Date date) {
		Calendar calendar = DateUtils.toCalendar(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek==7){//周六
			calendar.add(Calendar.DATE, 2);//跳到周一
		}else if(dayOfWeek==1){//周日
			calendar.add(Calendar.DATE, 1);//跳到周一
		}
		return calendar.getTime();
	}

	/**
	 * 将日期增加指定的月数
	 * @param date
	 * @param monthNum
	 * @return
	 */
	public static Date addMonth(Date date ,int monthNum) {
		Calendar calendar = DateUtils.toCalendar(date);
		calendar.add(Calendar.MONTH, monthNum);
		return calendar.getTime();
	}
	
	
	/**
	 * 获取两个日期之间的日期
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return 日期集合
	 */
	public static List<Date> getBetweenDates(Date start, Date end) {
	    List<Date> result = new ArrayList<Date>();
	    Calendar tempStart = Calendar.getInstance();
	    tempStart.setTime(start);
	    tempStart.add(Calendar.MONTH, 0);
	    Calendar tempEnd = Calendar.getInstance();
	    tempEnd.setTime(end);
	    while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
	        result.add(tempStart.getTime());
	        tempStart.add(Calendar.MONTH, 1);
	    }
	    return result;
	}

}
