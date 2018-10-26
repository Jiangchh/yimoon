package com.yimoom.pplay.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yimoom.pplay.system.shiro.MyShiroRealm;  

/** 
 * Shiro 配置 
 * 
Apache Shiro 核心通过 Filter 来实现，就好像SpringMvc 通过DispachServlet 来主控制一样。 
既然是使用 Filter 一般也就能猜到，是通过URL规则来进行过滤和权限校验，所以我们需要定义一系列关于URL的规则和访问权限。 
 * 
 * @author Angel(QQ:412887952) 
 * @version v.0.1 
 */  
@Configuration  
public class ShiroConfiguration {  

	private Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);
	@Value("${server.session-timeout}")
    private int tomcatTimeout;
 
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


	/** 
	 * ShiroFilterFactoryBean 处理拦截资源文件问题。 
	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在 
	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager 
	 * 
        Filter Chain定义说明 
       1、一个URL可以配置多个Filter，使用逗号分隔 
       2、当设置多个过滤器时，全部验证通过，才视为通过 
       3、部分过滤器可指定参数，如perms，roles 
	 * 
	 */  
	@Bean
	public SecurityManager securityManager(EhCacheManager ehCacheManager){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		//设置realm.
		securityManager.setRealm(myShiroRealm());
		// 自定义缓存实现 使用redis
		securityManager.setCacheManager(ehCacheManager);
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}
	@Bean
	public EhCacheManager ehCacheManager(net.sf.ehcache.CacheManager cacheManager) {
		EhCacheManager em = new EhCacheManager();
		//将ehcacheManager转换成shiro包装后的ehcacheManager对象
		em.setCacheManager(cacheManager);
		//em.setCacheManagerConfigFile("classpath:ehcache.xml");
		return em;
	}
	/**
	 * shiro session的管理
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setGlobalSessionTimeout(tomcatTimeout*1000);
		//设置sessionDao对session查询，在查询在线用户service中用到了
		sessionManager.setSessionDAO(sessionDAO());
//		//配置session的监听
//		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
//		sessionManager.setSessionListeners(listeners);
		//设置在cookie中的sessionId名称
		sessionManager.setSessionIdCookie(simpleCookie());
		return sessionManager;
	}

	@Bean
	public SessionDAO sessionDAO(){
		return new MemorySessionDAO();
	}

	@Bean
	public SimpleCookie simpleCookie(){

		SimpleCookie simpleCookie = new SimpleCookie();
		simpleCookie.setName("jeesite.session.id");

		return simpleCookie;
	}


	@Bean
	MyShiroRealm myShiroRealm() {
		return new MyShiroRealm();
	}
	@Bean  
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
		logger.info("init shiro");
		ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();  
		// 必须设置 SecurityManager   
		shiroFilterFactoryBean.setSecurityManager(securityManager);  
		// 如果不设置默认会自动寻找Web工程根目录下的"/login"页面  
		shiroFilterFactoryBean.setLoginUrl("/login");  
		// 登录成功后要跳转的链接  
		shiroFilterFactoryBean.setSuccessUrl("/home");  
		//未授权界面;  
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");  
		//拦截器.  
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();  
		//配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了  
		filterChainDefinitionMap.put("/login","anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/fonts/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/docs/**", "anon");
		filterChainDefinitionMap.put("/druid/**", "anon");
		filterChainDefinitionMap.put("/upload/**", "anon");
		filterChainDefinitionMap.put("/files/**", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/favicon.ico", "anon");
		//<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;  
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->  
		filterChainDefinitionMap.put("/**", "authc");  
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);  
		return shiroFilterFactoryBean;  
	}  

	//因为我们的密码是加过密的，所以，如果要Shiro验证用户身份的话，需要告诉它我们用的是md5加密的，并且是加密了两次。同时我们在自己的Realm中也通过SimpleAuthenticationInfo返回了加密时使用的盐。这样Shiro就能顺利的解密密码并验证用户名和密码是否正确了。
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}




}  
