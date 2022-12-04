package com.kbb.studycommunity.util.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JoHaDateTime {
    static final ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    static public LocalDateTime getDateTime(){
        return zdt.toLocalDateTime();
    }
}
