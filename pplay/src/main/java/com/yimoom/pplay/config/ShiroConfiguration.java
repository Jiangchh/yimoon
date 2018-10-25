package com.yimoom.pplay.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;  

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
	public SecurityManager securityManager(){  
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager(); 
		 //设置realm.
	    securityManager.setRealm(myShiroRealm());
	    //注入缓存管理器;
	    securityManager.setCacheManager(ehCacheManager());//这个如果执行多次，也是同样的一个对象;
		return securityManager;  
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
		filterChainDefinitionMap.put("/logout", "logout");  
		filterChainDefinitionMap.put("/login","anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/fonts/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/docs/**", "anon");
		filterChainDefinitionMap.put("/druid/**", "anon");
		filterChainDefinitionMap.put("/upload/**", "anon");
		filterChainDefinitionMap.put("/files/**", "anon");
		filterChainDefinitionMap.put("/", "anon");
		//<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;  
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->  
		filterChainDefinitionMap.put("/**", "authc");  
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);  
		return shiroFilterFactoryBean;  
	}  
	/**
	 * shiro缓存管理器;
	  * 需要注入对应的其它的实体类中：
	 * 1、安全管理器：securityManager
	  * 可见securityManager是整个shiro的核心；
	 * @return
	 */
	@Bean
	public EhCacheManager ehCacheManager(){
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:config/ehcache.xml");
		return cacheManager;
	}
}  
