package cn.bootx.system.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 /**   
  * 自定义spring时间格式化器
  * @author xxm  
  * @date 2018/12/4 10:52 
  * @version V1.0   
  */
public class StringToDateConverter implements Converter<String,Date> {

    private static final List<String> formarts = new ArrayList<>(4);

    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
    }
    @Override
    public Date convert(String source) {
        //SpringUtils是commons-lang3包下的工具类，针对[空null，空字符串""，仅存在空格字符串"   "]三个条件进行判断的，满足其一返回true
        if (StringUtils.isBlank(source)) {
            return null;
        }
        source = source.trim();
        try {
            if(source.matches("^\\d{4}-\\d{1,2}$")){
                return parseDate(source, formarts.get(0));
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
                return parseDate(source, formarts.get(1));
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(2));
            }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(3));
            }else {
                throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", source));
        }
    }
    /**
     * 格式化日期
     * @param dateStr String 字符型日期
     * @param format String 格式
     * @return Date 日期
     */
    public  Date parseDate(String dateStr, String format) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception ignored) {

        }
        return date;
    }
}
