package com.dakshay;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Utils {


    public static String getTimestampKey(Long timestamp) {
        LocalDate localDate = Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        Integer day = localDate.getDayOfMonth();
        Integer month = localDate.getDayOfMonth();
        Integer year  = localDate.getYear();

        StringBuilder timestampKey = new StringBuilder();
        timestampKey.append(day);
        timestampKey.append("-");
        timestampKey.append(month);
        timestampKey.append("-");
        timestampKey.append(year);
        return timestampKey.toString();
    }
}
