package com.kbb.studycommunity.controller;

import com.kbb.studycommunity.config.auth.OAuthAtrributes;
import com.kbb.studycommunity.service.UserService;
import com.kbb.studycommunity.util.LoginTypeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
public class signUpController {

    private final UserService userService;

    @Autowired
    public signUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signUp")
    public String signUpPage(Model model, @AuthenticationPrincipal OAuth2User oAuth2User) {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client, @AuthenticationPrincipal OAuth2User oAuth2User, @RequestParam String nickname) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        OAuthAtrributes oAuthAtrributes = new OAuthAtrributes(attributes);
        userService.join(nickname, oAuthAtrributes.getProfileImg(), client.getAccessToken().getTokenValue(),
                LoginTypeKey.valueOf(client.getClientRegistration().getRegistrationId().toUpperCase(Locale.ROOT)), oAuthAtrributes.getLoginKey());
        return "redirect:/";
    }
}
