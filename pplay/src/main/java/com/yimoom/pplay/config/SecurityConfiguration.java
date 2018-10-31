package com.yimoom.pplay.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;


import com.yimoom.pplay.constants.Constants;
import com.yimoom.pplay.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserService userDetailsService;
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				//查看源码已经加盐，所以没有了网上的MD5encoder
				BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder() ;
				
		        return encoder.encode(charSequence);
			}

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder ();
			        return encoder.matches(charSequence, s);
			
			}
		});
	}
	/**
	 * 替代rememberme的cookie方式，通过token记录
	 * @return
	 */
	@Bean
	public PersistentTokenRepository persistentTokenRepository(){
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		// 如果token表不存在，使用下面语句可以初始化该表；若存在，会报错。
		//	        tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// 如果有允许匿名的url，填在下面
		//             .antMatchers().permitAll()
		.anyRequest().authenticated()
		.and()
		
		// 设置登陆页
		.formLogin().loginPage("/templates/login")
		// 设置登陆成功页
		.defaultSuccessUrl("/").permitAll()
		// 自定义登陆用户名和密码参数，默认为username和password
		//             .usernameParameter("username")
		//             .passwordParameter("password")
		.and()
		.logout()
		.permitAll()
		// 自动登录
		.and()
		.rememberMe()
		.tokenRepository(persistentTokenRepository())
		// 有效时间：单位s
		.tokenValiditySeconds(Constants.TOKENVALIDITYSECONDS)
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