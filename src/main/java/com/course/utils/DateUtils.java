package com.course.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static java.util.Date format(Date data){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String str = sdf.format(new java.util.Date());
        Date date = null;
        try {

            java.util.Date udate = sdf.parse(String.valueOf(data));
            date = new Date(udate.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date format(java.util.Date date){
        Date time = new java.sql.Date(date.getTime());
        return time;
    }
}
