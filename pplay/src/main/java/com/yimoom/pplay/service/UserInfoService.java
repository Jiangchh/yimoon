package com.yimoom.pplay.service;

import com.yimoom.pplay.domain.sys.UserInfo;

public interface UserInfoService {
    public UserInfo findByUsername(String username);

}
