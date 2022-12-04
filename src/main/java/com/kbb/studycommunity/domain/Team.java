package com.kbb.studycommunity.domain;

import com.kbb.studycommunity.util.enumerate.TeamState;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Team {
    @Id
    @Column
    private Long team_id;
    @Column
    private Long board_id;
    @Column
    private String title;
    @Column
    private LocalDateTime closed_date;
    @Column
    @ColumnDefault("RECRUITING")
    @Enumerated(EnumType.STRING)
    private TeamState state;
}
