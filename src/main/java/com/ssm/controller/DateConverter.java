package com.ssm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-20 11:23
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        try {
            if(null != source){//2016-11-05 11_43-50
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                return df.parse(source);
            }
        } catch (Exception e) {

        }
        return null;
    }
}
