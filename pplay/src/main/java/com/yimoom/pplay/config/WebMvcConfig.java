package com.yimoom.pplay.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//为了让swagger-ui的路径和项目路径一致
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:../static/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:../static/css/");
	    registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//		registry.addResourceHandler("/webjars/**")
//		.addResourceLocations("classpath:/META-INF/resources/webjars/");
		
	}
	/**
	 * 此方法可以很方便的实现一个请求到视图的映射，而无需书写controller，例如： 
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/error").setViewName("error");

	}
	
}


