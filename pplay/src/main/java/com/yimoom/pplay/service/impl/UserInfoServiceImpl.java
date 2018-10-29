package com.yimoom.pplay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.dao.UserDao;
import com.yimoom.pplay.domain.sys.UserInfo;
import com.yimoom.pplay.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
    private UserDao userdao;

    
    public UserInfo findByUsername(String username) {

        return userdao.findByUserName(username);
    }


}
