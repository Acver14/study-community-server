package com.kbb.studycommunity.domain;

import com.kbb.studycommunity.util.datetime.JoHaDateTime;
import com.kbb.studycommunity.util.enumerate.LoginTypeKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Column
    @Id
    private Long id;
    @Column
    private String nickname;
    @Column
    private String profile_pic;
    @Column
    private String read_me;
    @Column
    private Double temper;
    @Column
    private String access_token;
    @Column
    private String refresh_token;
    @Column
    private LoginTypeKey login_type;
    @Column
    private String login_key;
    @Column
    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<String> interests = new ArrayList<>();
    @Column
    @CreatedDate
    LocalDateTime created_at;

    public User(long id, String nickname, String profileImg, String s, double v, String token, String s1, LoginTypeKey loginType, String loginKey, List<String> interestList) {
    }
}
