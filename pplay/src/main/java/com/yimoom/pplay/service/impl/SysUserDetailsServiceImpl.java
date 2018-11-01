package com.yimoom.pplay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.common.base.dao.GenericDao;
import com.yimoom.pplay.common.base.service.GenericService;
import com.yimoom.pplay.constants.StatusConstants;
import com.yimoom.pplay.dao.SysUserMapper;
import com.yimoom.pplay.domain.sys.SysRole;
import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.domain.sys.query.QuerySysUser;
import com.yimoom.pplay.service.SysUserRoleService;
@Service
public class SysUserDetailsServiceImpl extends GenericService<SysUser, QuerySysUser> implements UserDetailsService{
	
	@Autowired
	SysUserRoleService userRoleService;
	
	@Autowired
	SysUserMapper sysUserMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//从数据库中取出用户信息
		SysUser sysuser=sysUserMapper.findByUserName(username);

		if (sysuser==null) {
			throw new UsernameNotFoundException("用户名不存在！");
		}
		if(sysuser.getStatus()!=StatusConstants.UserStatus.LOCKED){
			throw new LockedException("用户账号被冻结，无法登陆请联系管理员！");
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


			authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		}
		sysuser.setAuthorities(authorities);
		// 返回UserDetails实现类
		return sysuser;


	}
	
	
	@Override
	protected GenericDao<SysUser, QuerySysUser> getDao() {
		return null;
	}

}
