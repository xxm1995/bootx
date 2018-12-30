package site.xxm.gen.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 */
public class DateUtils {
    private static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";


    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 计算距离现在多久，非精确
     *
     * @param date
     * @return
     */
    public static String getTimeBefore(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "天";
        } else if (hour > 0) {
            r += hour + "小时";
        } else if (min > 0) {
            r += min + "分";
        } else if (s > 0) {
            r += s + "秒";
        }
        r += "前";
        return r;
    }

    /**
     * 计算距离现在多久，精确
     *
     * @param date
     * @return
     */
    public static String getTimeBeforeAccurate(Date date) {
        Date now = new Date();
        long l = now.getTime() - date.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String r = "";
        if (day > 0) {
            r += day + "天";
        }
        if (hour > 0) {
            r += hour + "小时";
        }
        if (min > 0) {
            r += min + "分";
        }
        if (s > 0) {
            r += s + "秒";
        }
        r += "前";
        return r;
    }

    /**
     * 得到本周周一
     *
     * @return yyyy-MM-dd
     */
    public static String getStartOfWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 1);
        return format.format(c.getTime());
    }

    /**
     * 得到下周周一
     *
     * @return yyyy-MM-dd
     */
    public static String getStartOfNextWeek() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 8);
        return format.format(c.getTime());
    }
    /**
     * 得到本月一号
     *
     * @return yyyy-MM-dd
     */
    public static String getStartOfMoon() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(c.getTime());
    }
    /**
     * 得到下月一号
     *
     * @return yyyy-MM-dd
     */
    public static String getStartOfNextMoon() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(c.getTime());
    }

    /**
     * 得到本季度一号
     *
     * @return yyyy-MM-dd
     */
    public static String getStartOfQuarter() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth < 4)
            c.set(Calendar.MONTH, 0);
        else if (currentMonth >= 4 && currentMonth < 7)
            c.set(Calendar.MONTH, 3);
        else if (currentMonth >= 7 && currentMonth < 10)
            c.set(Calendar.MONTH, 6);
        else if (currentMonth >= 10 && currentMonth <= 12)
            c.set(Calendar.MONTH, 9);
        c.set(Calendar.DATE, 1);
        return format.format(c.getTime());
    }

    /**
     * 得到下季度一号
     *
     * @return yyyy-MM-dd
     */
    public static String getStartOfNextQuarter() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 4;
        if (currentMonth >= 1 && currentMonth < 4)
            c.set(Calendar.MONTH, 0);
        else if (currentMonth >= 4 && currentMonth < 7)
            c.set(Calendar.MONTH, 3);
        else if (currentMonth >= 7 && currentMonth < 10)
            c.set(Calendar.MONTH, 6);
        else if (currentMonth >= 10 && currentMonth <= 12)
            c.set(Calendar.MONTH, 9);
        c.set(Calendar.DATE, 1);
        return format.format(c.getTime());
    }
    /**
     * 得到本年的第一天
     *
     * @return yyyy-MM-dd
     */
    public static String getStartOfYear() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DATE, 1);
        return format.format(c.getTime());
    }
    /**
     * 得到下年的第一天
     *
     * @return yyyy-MM-dd
     */
    public static String getStartOfNextYear() {
        Calendar c = Calendar.getInstance();
        c.add( Calendar.YEAR, 1 );
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DATE, 1);
        return format.format(c.getTime());
    }
}
