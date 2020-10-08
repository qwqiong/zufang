package com.qwqiong.zufang.repository;

import com.qwqiong.zufang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    User findFirstByUserNameAndPassword(String username, String password);
}
