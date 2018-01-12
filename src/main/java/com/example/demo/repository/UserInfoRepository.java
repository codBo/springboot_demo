package com.example.demo.repository;

import com.example.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
     
    /**通过username查找用户信息;*/  
    UserInfo findByUsername(String username);
     
}  