package com.kbb.studycommunity.config.auth;

import java.util.Map;

public class OAuthAtrributes {
    private String loginKey;
    private String profileImg;

    public OAuthAtrributes(Map<String, Object> attributes) {
        if (attributes.get("response") != null) {
            Map<String, Object> resp = (Map<String, Object>) attributes.get("response");
            this.loginKey = (String) resp.get("id");
            this.profileImg = (String) resp.get("profile_image");
        } else if (attributes.get("sub") != null) {
            this.loginKey = (String) attributes.get("sub");
            this.profileImg = (String) attributes.get("picture");
        } else if (attributes.get("kakao_account") != null) {
            System.out.println("attributes.get(\"id\") = " + attributes.get("id"));
            this.loginKey = Long.toString((Long) attributes.get("id"));
            Map<String, Object> resp = (Map<String, Object>) attributes.get("kakao_account");
            Map<String, Object> profile = (Map<String, Object>) resp.get("profile");
        }
    }

    public String getLoginKey() {
        return loginKey;
    }

    public String getProfileImg() {
        return profileImg;
    }
}
