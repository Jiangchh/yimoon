package com.yimoom.pplay.service;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	
	public void updateUserOnlineStatus(long id,int status,Object obj);
}
