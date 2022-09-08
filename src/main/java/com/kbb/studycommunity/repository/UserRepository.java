package com.kbb.studycommunity.repository;

import com.kbb.studycommunity.domain.User;
import com.kbb.studycommunity.util.LoginTypeKey;

import java.util.Optional;

public interface UserRepository {
    public Optional<User> findById(long id);
    public Optional<User> findByLoginKey(String loginKey);
    public void join(String nickname, String profileImg, String token, LoginTypeKey loginType, String loginKey, String interests);
}
