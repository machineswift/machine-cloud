package com.machine.dragon.common.tool.date;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 日期工具类
 */
public class DragonLocalDateTimeUtil {

    public static Long getSecond(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
    }

    public static Long getMillis(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }
}
