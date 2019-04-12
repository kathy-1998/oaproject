package cn.bdqn.oaproject.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转换日期类型
 */
public class stringToDateConverter {


    /**
     * 将字符串转换为日期类型
     * @param dateStr  日期字符串
     * @param pattern  转换格式
     * @return 日期对象
     */
    public static Date strToDate(String dateStr,String pattern)throws Exception{
        //设置日期格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        //将String类型的日期转换为java.util.Date
        return simpleDateFormat.parse(dateStr);
    }




}
