package com.kbb.studycommunity.service;

import com.kbb.studycommunity.domain.User;
import com.kbb.studycommunity.domain.UserDTO;
import com.kbb.studycommunity.repository.UserRepository;
import com.kbb.studycommunity.util.LoginTypeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> findByLoginKey(String loginKey) {
        Optional<User> user = userRepository.findByLoginKey(loginKey);
        if (user.isPresent()) {
            return Optional.of(new UserDTO(user.get().getId(), user.get().getNickname(), user.get().getProfile_pic(), user.get().getInterests()));
        }
        else return Optional.empty();
    }

    public void join(String nickname, String profileImg, String token, LoginTypeKey login_type, String login_key) {
        userRepository.join(nickname, profileImg, token, login_type, login_key, "");
    }
}
