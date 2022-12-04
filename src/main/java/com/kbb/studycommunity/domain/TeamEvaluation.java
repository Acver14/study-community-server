package com.kbb.studycommunity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamEvaluation {
    @Id
    @Column
    private Long team_evaluation_id;
    @Column
    private Long team_id;
    @Column
    private Long from_user_id;
    @Column
    private Long to_user_id;
    @Column
    private Long evaluation;
}
