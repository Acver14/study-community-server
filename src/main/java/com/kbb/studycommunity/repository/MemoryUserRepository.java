package com.kbb.studycommunity.repository;

import com.kbb.studycommunity.domain.User;
import com.kbb.studycommunity.util.LoginTypeKey;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserRepository implements UserRepository {

    private HashMap<Long, User> userList = new HashMap<>();
    private long sequence = 0L;

    @Override
    public Optional<User> findById(long id) {
        return Optional.ofNullable(userList.get(id));
    }

    @Override
    public Optional<User> findByLoginKey(String loginKey) {
        return userList.values().stream()
                .filter(member -> member.getLogin_key().equals(loginKey))
                .findAny();
    }

    @Override
    public void join(String nickname, String profileImg, String token, LoginTypeKey loginType, String loginKey, String interests) {
        long id = sequence++;
        String[] interestArr = interests.split("/");
        List<String> interestList = new ArrayList<>();
        for (String interest : interestArr)
            interestList.add(interest);
        userList.put(id, new User(id, nickname, profileImg, token, loginType, loginKey, interestList));
    }
}
