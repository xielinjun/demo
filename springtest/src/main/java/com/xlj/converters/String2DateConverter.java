package com.xlj.converters;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {

        try {

            return DateUtil.instatnce.parseDate(source);
        } catch (ParseException e) {
            return null;
        }
    }

    static class DateUtil
    {
         static final DateUtil instatnce = new DateUtil();

         SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

         Date parseDate(String date) throws ParseException {
             return this.simpleDateFormat.parse(date);
         }
    }
}
