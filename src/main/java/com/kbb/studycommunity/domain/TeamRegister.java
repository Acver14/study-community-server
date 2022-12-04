package com.kbb.studycommunity.domain;

import com.kbb.studycommunity.util.enumerate.RegisterState;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class TeamRegister {
    @Id
    @Column
    private Long team_register_id;
    @Column
    private String content;
    @Column
    private Long user_id;
    @Column
    private Long team_id;
    @Column
    @Enumerated(EnumType.STRING)
    @ColumnDefault("WAIT")
    private RegisterState state;
}
