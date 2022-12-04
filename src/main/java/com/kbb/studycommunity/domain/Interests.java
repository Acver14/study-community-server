package com.kbb.studycommunity.domain;

import com.kbb.studycommunity.util.enumerate.Interest;

import javax.persistence.*;

@Entity
public class Interests {
    @Id
    @Column
    private Long interests_id;
    @Column
    @Enumerated(EnumType.STRING)
    private Interest interest;
    @Column
    private Long user_id;
}
