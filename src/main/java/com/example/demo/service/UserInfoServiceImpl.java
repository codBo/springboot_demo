package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService{  
     
    @Resource
    private UserInfoRepository userInfoRepository;
     
    @Override  
    public UserInfo findByUsername(String username) {
       System.out.println("UserInfoServiceImpl.findByUsername()");  
       return userInfoRepository.findByUsername(username);  
    }  
     
}  