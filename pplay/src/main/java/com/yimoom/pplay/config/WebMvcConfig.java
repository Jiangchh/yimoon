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
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	    //classpath相当于项目下面的resource文件夹，从这往下配置路径
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/lib/**").addResourceLocations("classpath:/static/lib/");
		registry.addResourceHandler("/temp/**").addResourceLocations("classpath:/static/temp/");
		registry.addResourceHandler("/oa/**").addResourceLocations("classpath:/templates/oa/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
		registry.addResourceHandler("/editor-app/**").addResourceLocations("classpath:/static/editor-app/");
	    registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
	    registry.addResourceHandler("/*.html").addResourceLocations("classpath:/templates/*.html");
//		registry.addResourceHandler("/webjars/**")
//		.addResourceLocations("classpath:/META-INF/resources/webjars/");
		
	}
	/**
	 * 此方法可以很方便的实现一个请求到视图的映射，而无需书写controller，例如： 
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/welcome*").setViewName("welcome");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/admin-member-list*").setViewName("admin-member-list");
        registry.addViewController("/member-add.*").setViewName("member-add");
        registry.addViewController("/member-show.*").setViewName("member-show");

	}
	
}


