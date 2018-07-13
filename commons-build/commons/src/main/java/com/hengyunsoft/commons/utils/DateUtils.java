package com.hengyunsoft.commons.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述：日期工具类
 * 修改人：zhaopengfei
 * 修改时间：2018/4/24
 */
public class DateUtils {
    private DateUtils() {
    }

    public static final int NEXT_DAY = 5;
    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public final static String DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

    /**
     * 格式化日期,返回格式为 HH:mm:ss 例:12:24:24
     *
     * @param d 日期
     * @return
     */
    public static String getStringTime(Date d) {
        Date date = d;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 yyyy-MM-dd
     *
     * @param d 日期
     * @return
     */
    public static String getStringDate(Date d) {
        Date date = d;
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 dd ,即对应的天数.
     *
     * @param d 日期
     * @return
     */
    public static String getStringDay(Date d) {
        Date date = d;
        SimpleDateFormat df = new SimpleDateFormat("dd");
        return df.format(date);
    }

    /**
     * 根据传入的格式格式化日期.默认格式为MM月dd日
     *
     * @param d 日期
     * @param f 格式
     * @return
     */
    public static String formatDateToString(Date d, String f) {
        Date date = d;
        String format = f;
        if (date == null) {
            date = new Date();
        }
        if (format == null) {
            format = "MM月dd日";
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 给定日期后增加多少天后的日期
     *
     * @param date 日期
     * @param days 天数
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(date);
            cal.add(Calendar.DATE, days);

        } catch (Exception e) {
            // e.printStackTrace();
        }
        return cal.getTime();

    }

    /**
     * 将string类型解析为日期类型
     *
     * @param dateStr
     * @param format  需要解析的格式
     * @return
     */
    public static Date toDate(String dateStr, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 比较日期,如果date1 小于date2 则返回负数(即天数,如-5表示小于5天)
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int subDays(Date date1, Date date2) {
        long d1 = toDate(getStringDate(date1), DEFAULT_DATE_FORMAT).getTime();
        long d2 = toDate(getStringDate(date2), DEFAULT_DATE_FORMAT).getTime();
        return (int) (d1 - d2) / (1000 * 60 * 60 * 24);

    }

    /**
     * 根据传入的String返回对应的date
     *
     * @param dateString
     * @return
     */
    public static Date getDateByDateString(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 检测给定的日期是否在指定的时间内
     *
     * @param date      日期
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static boolean isDateInRange(Date date, Date startDate, Date endDate) {
        if (null == date || null == startDate || null == endDate) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String dateStr = df.format(date);
        String startDateStr = df.format(startDate);
        String endDateStr = df.format(endDate);
        return isDateInRange(dateStr, startDateStr, endDateStr);
    }

    /**
     * 检测给定的日期是否在指定的时间内
     *
     * @param date      日期
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static boolean isDateInRange(String date, String startDate,
                                        String endDate) {
        if (null == date || null == startDate || null == endDate) {
            return false;
        }
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    /**
     * @param @param  currTime
     * @param @param  startTime
     * @param @param  endTime
     * @param @return 设定文件
     * @return boolean    返回类型
     * @throws
     * @Title: isDateTimeInRange
     * @Description: check date time in range
     */
    public static boolean isDateTimeInRange(Date currTime, Date startTime, Date endTime) {
        if (null == currTime || null == startTime || null == endTime) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        String timeStr = df.format(currTime);
        String startTimeStr = df.format(startTime);
        String endTimeStr = df.format(endTime);
        return isDateInRange(timeStr, startTimeStr, endTimeStr);
    }

    /**
     * 比较两个日期的大小
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(Date date1, Date date2) {
        if (null == date1 || null == date2) {
            return 0;
        }
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String date1Str = df.format(date1);
        String date2Str = df.format(date2);
        return date1Str.compareTo(date2Str);
    }

    /**
     * 获取开始日期和结束日期的第一个工作日
     *
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static String getFirstWorkday(String startDateStr, String endDateStr) {
        String result = null;
        DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        try {
            Date startDate = df.parse(startDateStr);
            Date endDate = df.parse(endDateStr);
            Calendar startDateCal = Calendar.getInstance();
            Calendar endDateCal = Calendar.getInstance();

            startDateCal.setTime(startDate);
            endDateCal.setTime(endDate);
            while (!isWorkday(startDateCal.getTime())) {
                startDateCal.add(Calendar.DATE, 1);
            }

            if (startDateCal.compareTo(endDateCal) <= 0) {
                result = df.format(startDateCal.getTime());
            }
        } catch (ParseException e) {
            result = startDateStr;
        }
        return result;
    }

    /**
     * 获取开始日期和结束日期的第一个假日
     *
     * @param startDateStr
     * @param endDateStr
     * @return
     */
    public static String getFirstHoliday(String startDateStr, String endDateStr) {
        String result = null;
        DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        try {
            Date startDate = df.parse(startDateStr);
            Date endDate = df.parse(endDateStr);
            Calendar startDateCal = Calendar.getInstance();
            Calendar endDateCal = Calendar.getInstance();

            startDateCal.setTime(startDate);
            endDateCal.setTime(endDate);
            while (isWorkday(startDateCal.getTime())) {
                startDateCal.add(Calendar.DATE, 1);
            }

            if (startDateCal.compareTo(endDateCal) <= 0) {
                result = df.format(startDateCal.getTime());
            }
        } catch (ParseException e) {
            result = startDateStr;
        }
        return result;
    }

    /**
     * 检测给定的日期是否是工作日
     *
     * @param date
     * @return
     */
    public static boolean isWorkday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return day != 1 && day != 7;
    }

    /**
     * 检测给定的日期是否是工作日
     *
     * @param dateStr
     * @return
     */
    public static boolean isWorkday(String dateStr) {
        boolean result = false;
        DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Date date;
        try {
            date = df.parse(dateStr);
            result = isWorkday(date);
        } catch (Exception e) {
            // donothing
        }
        return result;
    }

    public static long subDays2(Date date1, Date date2) {
        long d1 = DateUtils.toDate(DateUtils.getStringDate(date1), DEFAULT_DATE_FORMAT).getTime();
        long d2 = DateUtils.toDate(DateUtils.getStringDate(date2), DEFAULT_DATE_FORMAT).getTime();
        return (d1 - d2) / (1000 * 60 * 60 * 24);

    }

    /**
     * 时间计算,在原有的时间基础上增加类型和时间
     *
     * @param date
     * @param TYPE     Calendar.DAY_OF_MONTH,Calendar.DAY_OF_WEEK ,Calendar.DAY_OF_YEAR
     * @param datetime
     * @return
     */
    public static Date countDate(Date date, int TYPE, int datetime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(TYPE, datetime);
        return cal.getTime();
    }

    /**
     * date转换为string
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 以"yyyy-MM-dd HH:mm:ss"形式返回当前系统时间
     *
     * @return
     */
    public static String getSystemDateTime() {
        SimpleDateFormat simpledateformat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return simpledateformat.format(new Date()).toString();
    }

    /**
     * 以"yyyyMMddHHmmss"形式返回当前系统时间
     *
     * @return
     */
    public static String getDateTime() {  // 这是UNSAP要求的格式

        SimpleDateFormat simpledateformat = new SimpleDateFormat(
                "yyyyMMddHHmmss");
        return simpledateformat.format(new Date()).toString();
    }

    /**
     * 以"yyyyMMdd"形式返回当前系统时间
     *
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat simpledateformat = new SimpleDateFormat(
                "yyyyMMdd");
        return simpledateformat.format(new Date()).toString();
    }

    /**
     * 以"yyyyMMdd"形式返回当前系统时间
     *
     * @return
     */
    public static String getSomeDate(Date someDate) {
        SimpleDateFormat simpledateformat = new SimpleDateFormat(
                "yyyyMMdd");
        return simpledateformat.format(someDate).toString();
    }

    /**
     * 以"yyyy-MM-dd"形式返回当前系统时间
     *
     * @return
     */
    public static String getSystemDate() {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        return simpledateformat.format(new Date()).toString();
    }

    /**
     * 以"HH:mm:ss"形式返回当前系统时间
     *
     * @return
     */
    public static String getSystemTime() {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm:ss");
        return simpledateformat.format(new Date()).toString();
    }

    /**
     * 使用指定的格式返回当前系统时间
     *
     * @param s 时间格式
     * @return
     */
    public static String getSystemDateTime(String s) {
        try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
            return simpledateformat.format(new Date()).toString();
        } catch (Exception exception) {
            //exception.printStackTrace();
        }
        return null;
    }

    /**
     * 按给定参数返回Date对象
     *
     * @param DateTime 时间对象格式为("yyyy-MM-dd HH:mm:ss");
     * @return
     */
    public static Date getDate(String DateTime) {
        SimpleDateFormat simpledateformat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return simpledateformat.parse(DateTime, new ParsePosition(0));
    }

    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 得到date当前月最后一天距离现在的天数
     *
     * @param date
     * @return
     */
    public static int getMonthLastDayDistNow(Date date) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1900);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH));
        int lastDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastDays - c.get(Calendar.DAY_OF_MONTH) + 1;
    }

    /**
     * 得到date当前月的天数
     *
     * @param date
     * @return
     */
    public static int getMonthDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1900);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH));
        int lastDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return lastDays;
    }

    /**
     * 得到当前时间前一天的时间
     *
     * @return
     */
    public static String getForwardDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    //当前时间下一天的时间
    public static String getNextDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    //得到具体时间的日期格式
    public static String getFormatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }


    /**
     * 得到本月的日期
     *
     * @return
     */
    public static String getForwardMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(cal.getTime());

    }

    //得到当前月
    public static String getNowMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(cal.getTime());

    }


    /**
     * 得到当前日期的本周周一时间
     *
     * @return
     */
    public static String getForwardWeekStartTime() {
        int mondayPlus = weekDays();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(monday);


    }

    /**
     * 得到当前日期本周的周日时间
     *
     * @return
     */
    public static String getForwardWeekEndTime() {
        int mondayPlus = weekDays();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = currentDate.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(monday);


    }


//    private static int getMondayPlus() {
//        Calendar cd = Calendar.getInstance();
//        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
//        if (dayOfWeek == 1) {
//            return -6;
//        } else {
//            return 2 - dayOfWeek;
//        }
//    }

    /**
     * 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
     *
     * @return
     */
    private static int weekDays() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;


    }


    /**
     * 得到日期后几天的日期时间
     *
     * @return
     */
    public static String getNextDay(String nowDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        try {
            cal.setTime(sdf.parse(nowDate));
            //cal.add(Calendar.DATE,5);
            cal.add(Calendar.DATE, NEXT_DAY); //update by bill 2010-07-20

        } catch (ParseException e) {
            //e.printStackTrace();
        }
        return sdf.format(cal.getTime());

    }

    /**
     * 得到日期后几天的日期时间
     *
     * @param d dd
     * @return
     */
    public static Date getNextDay(Date d) {
        Date date = d;
        if (date == null) {
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, NEXT_DAY);

        return cal.getTime();
    }

    /**
     * 返回两个日期相差的天数
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int getDistDates(Date startDate, Date endDate) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            startDate=sdf.parse(sdf.format(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            endDate=sdf.parse(sdf.format(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 返回两个日期相差的小时
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static Double getDistHour(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        return Double.valueOf(Math.abs((timeend - timestart)) / (1000 * 60 * 60.0));
    }

    /**
     * 返回两个日期相差的分钟
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static Double getDistMinute(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        return Double.valueOf(Math.abs((timeend - timestart)) / (1000 * 60.0));
    }

    public static Float getFloatDistHour(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        return Float.valueOf(timeend - timestart) / (1000 * 60 * 60);
    }



    public static Float getFloatDistMsec(Date startDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        return Float.valueOf(timeend - timestart);
    }
    /**
     * 根据日期获得所在周的日期
     *
     * @param mdate
     * @return
     */
    @SuppressWarnings("deprecation")
    public static List<Date> getWeekList(Date mdate) {
        int b = mdate.getDay();
        Date fdate;
        List<Date> list = new ArrayList<Date>();
        Long fTime = mdate.getTime() - b * 24 * 3600000;
        for (int a = 0; a < 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a, fdate);
        }
        return list;
    }

    /**
     * 将日期转换成字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2String(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String result = null;
        sdf.setLenient(false);
        try {
            result = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将字符转换成日期
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date format(String dateStr, String format) {
        Date date = null;
        SimpleDateFormat sdateFormat = new SimpleDateFormat(format);
        sdateFormat.setLenient(false);
        try {
            date = sdateFormat.parse(dateStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    public static void main(String[] args) {
        Date startDate = getDate("2017-09-15 09:00:00");
        ;
        Date endDate = getDate("2017-11-15 17:30:00");
        int dist = getDistDates( startDate,endDate);
        System.out.print(dist);
    }

    /**
     * 将时间字符串转换成Date类型时间
     *
     * @param date yyyy-MM-dd HH:mm:ss 类型的时间字符串
     * @return 字符串对应的Date类型时间
     */
    public static Date string2Date(String date) {
        return string2Date(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param date   日期字符串 例如：0000-00-00 00:00:00
     * @param format 格式化字符串，例如：yyyy-MM-dd HH:mm:ss
     * @return Date 日期类型
     */
    public static Date string2Date(String date, String format) {
        Date d = null;
        SimpleDateFormat sf = null;
        try {
            sf = new SimpleDateFormat(format);
            d = sf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            d = null;
        }
        return d;
    }

    /**
     * 给当前时间增加固定秒数
     *
     * @param date
     * @param
     * @return
     */
    public static Date getDateBySecond(Date date, Integer second) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime() + second * 1000);
        date = cal.getTime();
        return date;
    }

    /**
     * 获取当年的第一天
     *
     * @param
     * @return
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     *
     * @return
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 根据Long（毫秒）获取当前月的开始时间
     *
     * @param date
     * @return
     */
    public static Long getFirstByDate(Long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String sst = (sdf.format(new Date(date)) + "-01 00:00:00");
        return DateUtils.string2Date(sst).getTime();
    }

    /**
     * 根据Long（毫秒）获取当前月的结束时间
     *
     * @param date
     * @return
     */
    public static Long getLastDayByDate(Long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date));
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String set = format.format(calendar.getTime()) + " 23:59:59";
        return DateUtils.string2Date(set).getTime();
    }

    /**
     * 获取月份第一天
     *
     * @param
     * @return
     * @author zhaopengfei@hengyunsoft.com
     * @version 1.0.0,
     * create 2017/6/10 14:18
     * @since GYDBDC1.0.0
     */
    public static Date getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取月份最后一天
     *
     * @param
     * @return
     * @author zhaopengfei@hengyunsoft.com
     * @version 1.0.0,
     * create 2017/6/10 14:18
     * @since GYDBDC1.0.0
     */
    public static Date getMonthLastDay(Date date) {
        //创建日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);     //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        return calendar.getTime();
    }

}