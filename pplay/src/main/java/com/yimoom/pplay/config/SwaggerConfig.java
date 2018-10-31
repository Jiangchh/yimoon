package com.yimoom.pplay.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {  
    private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);

	@Autowired
	private Environment env;
	
	@Bean
	public Docket api() { 
		Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				// 除非是在开发环境中否则不开启swagger2
				String active = env.getProperty("spring.profiles.active");
				logger.info("HI,developer,目前的开发环境是{}!",active);
				if(!active.equalsIgnoreCase("dev")){//判断配置文件是否是dev
					
					return false;
				}
				Class<?> declaringClass = input.declaringClass();
				if (declaringClass == BasicErrorController.class)// 排除
					return false;
				if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
					return true;
				if(input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
					return true;
				return false;
			}
		};

		return new Docket(DocumentationType.SWAGGER_2)  
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.select()                                  
				.apis(predicate)              
				//.paths(PathSelectors.any())                          
				.build();                                           
	}
	private ApiInfo apiInfo() {
		Contact contact=new Contact("jangchenghua", null, "1395067756@qq.com");

		return new ApiInfoBuilder()
				.title("游戏后台RESTful APIs")
				.description("rest的url调用")
				.contact(contact)
				.version("1.0")
				.build();
	}
}

