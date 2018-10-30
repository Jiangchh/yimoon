package com.yimoom.pplay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.yimoom.pplay.dao.UserDao;
import com.yimoom.pplay.domain.sys.SysRole;
import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.service.UserRoleService;
import com.yimoom.pplay.service.UserService;
@Service
public class SysUserServiceImpl implements UserService{
	@Autowired
	UserDao userdao;
	@Autowired
	UserRoleService userRoleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser condition=new SysUser();
		condition.setAccount(username);
		//从数据库中取出用户信息
		SysUser sysuser=userdao.selectOne(condition);

		if (sysuser==null) {
			throw new UsernameNotFoundException("用户名存在！");
		}
//		//用户已经登录则此次登录失败
//		List<Object> o = sessionRegistry.getAllPrincipals();
//		for ( Object principal : o) {
//			if (principal instanceof SysUser && (sysuser.getUsername().equals(((SysUser) principal).getUsername()))) {
//				throw new SessionAuthenticationException("当前用户已经在线，登录失败！！！");
//			}
//		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		// 添加权限
		List<SysRole> userRoles =userRoleService.listByUserId(sysuser.getUid());
		for (SysRole userRole : userRoles) {


			authorities.add(new SimpleGrantedAuthority(userRole.getRole_Name()));
		}
		sysuser.setAuthorities(authorities);
		// 返回UserDetails实现类
		return sysuser;


	}
	@Override
	public void updateUserOnlineStatus(long id, int status, Object obj) {
		SysUser user=new SysUser();
		user.setUid(id);
		user.setStatus(status);
		userdao.updateByPrimaryKeySelective(user);

	}

}
