package com.kbb.studycommunity.controller;

import com.kbb.studycommunity.config.auth.OAuthAtrributes;
import com.kbb.studycommunity.domain.dto.UserDTO;
import com.kbb.studycommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Configuration
@EnableWebSecurity
@RestController
public class UserController extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        OAuthAtrributes oAuthAtrributes = new OAuthAtrributes(attributes);
        Optional<UserDTO> userDTO = userService.findByLoginKey(oAuthAtrributes.getLoginKey());
        if (userDTO.isEmpty()) {
//            throw new OAuth2AuthorizationException(new OAuth2Error(OAuth2ErrorCodes.UNAUTHORIZED_CLIENT));
            return null;
        }
        return Collections.singletonMap("name", userDTO.map(user-> user.getNickname()));
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a.antMatchers("/", "/error", "/webjars/**").permitAll().anyRequest().authenticated())
                .csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .csrf().disable();
        http.logout(l -> l.logoutSuccessUrl("/").permitAll())
                .exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .oauth2Login()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
                        Map<String, Object> attributes = oAuth2User.getAttributes();
                        OAuthAtrributes oAuthAtrributes = new OAuthAtrributes(attributes);
                        Optional<UserDTO> userDTO = userService.findByLoginKey(oAuthAtrributes.getLoginKey());
                        if (userDTO.isPresent()) {
                            response.sendRedirect("/");
                        } else {
                            response.sendRedirect("/signUp");
                        }
                    }

                });
    }

}
