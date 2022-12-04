package com.kbb.studycommunity.domain.dto;

import java.util.List;

public class UserDTO {
    private long id;
    private String nickname;
    private String profile_pic;
    private List<String> interests;

    public UserDTO(long id, String nickname, String profile_pic, List<String> interests) {
        this.id = id;
        this.nickname = nickname;
        this.profile_pic = profile_pic;
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

    public List<String> getInterests() {
        return interests;
    }
}
