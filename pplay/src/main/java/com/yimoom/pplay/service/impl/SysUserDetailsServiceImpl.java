package com.yimoom.pplay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.cache.UserDaoByRedis;
import com.yimoom.pplay.common.base.dao.GenericDao;
import com.yimoom.pplay.common.base.service.GenericService;
import com.yimoom.pplay.constants.RedisKeyPrefix;
import com.yimoom.pplay.constants.StatusConstants;
import com.yimoom.pplay.dao.SysUserMapper;
import com.yimoom.pplay.domain.sys.SysRole;
import com.yimoom.pplay.domain.sys.SysUser;
import com.yimoom.pplay.domain.sys.query.QuerySysUser;
import com.yimoom.pplay.security.MyGrantedAuthority;
import com.yimoom.pplay.service.SysUserRoleService;
@Service
public class SysUserDetailsServiceImpl extends GenericService<SysUser, QuerySysUser> implements UserDetailsService{
	private static final Logger logger=LoggerFactory.getLogger(SysUserDetailsServiceImpl.class);
	@Autowired
	SysUserRoleService userRoleService;
	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	UserDaoByRedis UserDaoByRedis;
	public SysUser findById(long id) {
		// 从缓存中获取信息
		String key = RedisKeyPrefix.USERPREFIX + id;
		//先判断缓存中是否有数据
		SysUser sysuser=UserDaoByRedis.getUser(key);
		if(sysuser==null) {
			//不存在, 从 DB 中获取用户信息
			sysuser = sysUserMapper.getUserById(id);
			UserDaoByRedis.saveUser(sysuser, key);
		}
		return sysuser;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 从缓存中获取信息
		String key = RedisKeyPrefix.USERPREFIX + username;
		//先判断缓存中是否有数据
		SysUser sysuser=UserDaoByRedis.getUser(key);
		if(sysuser==null) {
			//不存在, 从 DB 中获取用户信息
			sysuser = sysUserMapper.findByUserName(username);
		}
		//AuthenticationServiceException这个异常可以方便我们把他抛出去
		if (sysuser==null) {
			throw new  AuthenticationServiceException("用户名不存在！");
		}
		if(sysuser.getStatus()==StatusConstants.UserStatus.LOCKED){
			throw new AuthenticationServiceException("用户账号被冻结，无法登陆请联系管理员！");
		}
		//		//用户已经登录则此次登录失败
		//		List<Object> o = sessionRegistry.getAllPrincipals();
		//		for ( Object principal : o) {
		//			if (principal instanceof SysUser && (sysuser.getUsername().equals(((SysUser) principal).getUsername()))) {
		//				throw new SessionAuthenticationException("当前用户已经在线，登录失败！！！");
		//			}
		//		}
		List<MyGrantedAuthority> authorities = new ArrayList<>();
		// 添加权限
		List<SysRole> userRoles =userRoleService.listByUserId(sysuser.getUid());
		for (SysRole userRole : userRoles) {
			authorities.add(new MyGrantedAuthority(userRole.getRoleName()));
		}
		sysuser.setAuthorities(authorities);
		UserDaoByRedis.saveUser(sysuser, key);
		// 返回UserDetails实现类
		return sysuser;
	}
	@Override
	protected GenericDao<SysUser, QuerySysUser> getDao() {
		// TODO Auto-generated method stub
		return null;
	}
}
