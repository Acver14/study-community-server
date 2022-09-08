package com.kbb.studycommunity.domain;

import com.kbb.studycommunity.util.LoginTypeKey;

import java.util.List;

public class User {
    private long id;
    private String nickname;
    private String profile_pic;
    private String token;
    private LoginTypeKey login_type;
    private String login_key;
    private List<String> interests;

    public User(long id, String nickname, String profile_pic, String token, LoginTypeKey login_type, String login_key,
                List<String> interests) {
        this.id = id;
        this.nickname = nickname;
        this.profile_pic = profile_pic;
        this.token = token;
        this.login_type = login_type;
        this.login_key = login_key;
        this.interests = interests;
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public String getToken() {
        return token;
    }

    public LoginTypeKey getLogin_type() {
        return login_type;
    }

    public String getLogin_key() {
        return login_key;
    }

    public List<String> getInterests() {
        return interests;
    }
}
