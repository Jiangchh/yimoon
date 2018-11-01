package com.yimoom.pplay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.yimoom.pplay.service.impl.SysUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private SysUserDetailsServiceImpl userDetailsService;

	// 装载BCrypt密码编码器
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		// 设置UserDetailsService
		.userDetailsService(this.userDetailsService)
		// 使用BCrypt进行密码的hash
		.passwordEncoder(passwordEncoder());
	}
	/**
	 * 替代rememberme的cookie方式，通过token记录
	 * @return
	 */
	//	@Bean
	//	public PersistentTokenRepository persistentTokenRepository(){
	//		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
	//		tokenRepository.setDataSource(dataSource);
	//		// 如果token表不存在，使用下面语句可以初始化该表；若存在，会报错。
	//	    tokenRepository.setCreateTableOnStartup(true);
	//		return tokenRepository;
	//	}

	/**
	 * 不管url输入什么信息，入口都从这里设置的首页开始
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 禁用缓存
		http.headers().cacheControl();
		//关闭跨站请求防护
		http.csrf().disable();
		http 
		//请求授权
		.authorizeRequests()
		//不需要权限认证的url
		.antMatchers("/login").permitAll()
		// 对于获取token的rest api要允许匿名访问
		.antMatchers("/auth/**").permitAll()
		// 允许对于网站静态资源的无授权访问
		.antMatchers(
				"/",
				"/css/**",
				"/js/**",
				"/*.html",
				"/static/**",
				"../static/js/",
				"../static/css/",
				"/**/favicon.ico",
				"/**/*.html",
				"/**/*.css",
				"/**/*.js"
				).permitAll()

		// 基于token，所以不需要session
		//   .sessionManagement().
		//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		//        .and()
		//任何请求
				.anyRequest()
				//需要身份认证
				.authenticated()		
				.and()
		//设置登录页面
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/index")
		.permitAll()
		.and()
		.logout()
		.permitAll()
		// 自动登录
		.and()
		//		.rememberMe()
		//		.tokenRepository(persistentTokenRepository())
		// 有效时间：单位s
		//		.tokenValiditySeconds(Constants.TOKENVALIDITYSECONDS)
		.userDetailsService(userDetailsService);

		//以下这句就可以控制单个用户只能创建一个session，也就只能在服务器登录一次        
		http.sessionManagement().maximumSessions(1)
		//.sessionRegistry(getSessionRegistry())
		.expiredUrl("/login");
	}
	/**
	 * 3. 使session失效
	此时已经完成了一大半了。 
	只用在修改用户的方法里判断有没有修改用户的权限，如果有修改用户的权限就使session失效。 
	session失效代码如下：
	 */
	//	private void invalidateSession(User user){
	//		List<Object> o= sessionRegistry.getAllPrincipals();
	//		for (Object principal : o) {
	//			if (principal instanceof User) {
	//				final User loggedUser = (User) principal;
	//				if (user.getUsername().equals(loggedUser.getUsername())) {
	//					List<SessionInformation> sessionsInfo = sessionRegistry.getAllSessions(principal, false);
	//					if (null != sessionsInfo && sessionsInfo.size() > 0) {
	//						for (SessionInformation sessionInformation : sessionsInfo) {
	//							sessionInformation.expireNow();
	//						}
	//					}
	//				}
	//			}
	//		}
	//	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		// 设置拦截忽略文件夹，可以对静态资源放行
		web.ignoring().antMatchers("/assets/**");
		web.ignoring().antMatchers("/components/**");
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/images/**");
		web.ignoring().antMatchers("/js/**");
		web.ignoring().antMatchers("/mustache/**");
		web.ignoring().antMatchers("/favicon.ico");
	}
	/**
	 * session监听，防止重复登录
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletListenerRegistrationBean httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
	}


}