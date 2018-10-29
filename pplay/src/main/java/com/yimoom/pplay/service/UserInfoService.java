package com.yimoom.pplay.service;

import com.yimoom.pplay.domain.sys.SysUser;

public interface UserInfoService {
    public SysUser findByUsername(String username);

}
