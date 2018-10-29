package com.yimoom.pplay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.dao.UserDao;
import com.yimoom.pplay.dao.UserMapper;
import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
    private UserDao userdao;
	@Autowired
	private UserMapper usermapper;

    
    public SysUser findByUsername(String username) {
    	SysUser sysuser=new SysUser();
    	sysuser.setAccount(username);
    	List<SysUser>list=usermapper.selectByCondition(sysuser);
        return list!=null&&list.size()>0?list.get(0):null;
    }


}
