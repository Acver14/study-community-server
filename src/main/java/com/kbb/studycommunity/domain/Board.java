package com.kbb.studycommunity.domain;

import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Board {
    @Id
    @Column
    private Long board_id;
    @Column
    private Long user_id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String Location;
    @Column
    @CreatedDate
    private LocalDateTime created_at;
    @Column
    @UpdateTimestamp
    private LocalDateTime update_at;
    @Column
    private LocalDateTime closed_Date;
}
