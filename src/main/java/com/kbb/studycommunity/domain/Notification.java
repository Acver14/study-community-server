package com.kbb.studycommunity.domain;

import com.kbb.studycommunity.util.enumerate.NotificationType;

import javax.persistence.*;

@Entity
public class Notification {
    @Id
    @Column
    private Long notification_id;
    @Column
    private Long board_id;
    @Column
    private Long user_id;
    @Column
    private String content;
    @Column
    private Boolean read_check;
    @Column
    @Enumerated(EnumType.STRING)
    private NotificationType notification_type;
}
