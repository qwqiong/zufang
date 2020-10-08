package com.qwqiong.zufang.service;

import com.qwqiong.zufang.entity.User;
import com.qwqiong.zufang.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 查找用户
     * @param username
     * @param password
     * @return
     */
    public User findUser(String username, String password) {
        return userRepository.findFirstByUserNameAndPassword(username,password);
    }
}
