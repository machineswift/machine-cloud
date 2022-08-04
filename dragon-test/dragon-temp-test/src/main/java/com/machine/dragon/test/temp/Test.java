package com.machine.dragon.test.temp;

import cn.hutool.json.JSON;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
     //   String s = threadLocalDateFormat.get().format(new Date());
     //   System.out.println(s);
//
//
//        System.out.println(new Date(1657209599999L));
//        System.out.println(new Date(1657209600000L));
//
//        String ss = "999=00";
//        System.out.println(ss.substring(ss.indexOf('=') + 1));


        List<String> aa = new ArrayList<>();
        aa.add("1");
        aa.add("2");
        aa.add("3");
        aa.remove(aa.size()-1);
        aa.add("4");
        System.out.println(DragonJsonUtil.toJson(aa));
    }

    private static ThreadLocal<DateFormat> threadLocalDateFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        }
    };
}
