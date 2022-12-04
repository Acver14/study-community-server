package com.kbb.studycommunity.repository;

import com.kbb.studycommunity.domain.User;
import com.kbb.studycommunity.util.enumerate.LoginTypeKey;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(long id);
    Optional<User> findByLoginKey(String loginKey);
    void join(String nickname, String profileImg, String token, LoginTypeKey loginType, String loginKey, String interests);
}
