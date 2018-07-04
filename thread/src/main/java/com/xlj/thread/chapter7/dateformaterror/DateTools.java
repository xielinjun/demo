package com.xlj.thread.chapter7.dateformaterror;

import java.text.SimpleDateFormat;

public class DateTools {

    static ThreadLocal<SimpleDateFormat> tlSimpleDateFormat = new ThreadLocal<>();

    public static SimpleDateFormat getSimpleDateFormat()
    {
        SimpleDateFormat result = DateTools.tlSimpleDateFormat.get();
        if(result == null)
        {
            result = new SimpleDateFormat("yyyy-MM-dd");
            DateTools.tlSimpleDateFormat.set(result);
        }

        return result;
    }

}
