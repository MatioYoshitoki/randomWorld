package com.matio.util;

import com.relops.snowflake.Snowflake;

/**
 * 雪花生成唯一Id
 * @author choleece
 */
public class SnowFlakeUtil {
    private Snowflake snowflake;

    public SnowFlakeUtil() {
        this.snowflake = new Snowflake(6);
    }

    public String getUUID() {
        return CommUtil.null2String(snowflake.next());
    }
    public String getShortUUID() {
        return CommUtil.null2String(snowflake.next()).substring(11,19);
    }

    public static void main(String[] args) {
        SnowFlakeUtil snowFlakeUtil = new SnowFlakeUtil();
        System.out.println(snowFlakeUtil.getShortUUID());
    }
}
