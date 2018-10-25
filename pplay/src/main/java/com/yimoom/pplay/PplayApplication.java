package com.yimoom.pplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring4all.swagger.EnableSwagger2Doc;

import tk.mybatis.spring.annotation.MapperScan;
@EnableAutoConfiguration
@EnableTransactionManagement
@ServletComponentScan
@ComponentScan
@EnableSwagger2Doc
@MapperScan("com.yimoom.pplay.*.dao")
@SpringBootApplication
//@EnableCaching
public class PplayApplication {
	/**
	 * 这个方法只是想看一下事物管理者是谁，没什么用 	
	 * @param platformTransactionManager
	 * @return
	 */
	@Bean
	    public Object testBean(PlatformTransactionManager platformTransactionManager){
	        return new Object();
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(PplayApplication.class, args);
	}
}
