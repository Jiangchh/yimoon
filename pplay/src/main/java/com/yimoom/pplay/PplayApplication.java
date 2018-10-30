package com.yimoom.pplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import tk.mybatis.spring.annotation.MapperScan;
@EnableAutoConfiguration
@MapperScan("com.yimoom.pplay.dao")
@SpringBootApplication
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
