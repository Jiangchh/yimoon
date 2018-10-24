package com.yimoom.pplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring4all.swagger.EnableSwagger2Doc;

import tk.mybatis.spring.annotation.MapperScan;
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableTransactionManagement
@ServletComponentScan
@EnableSwagger2Doc
//@MapperScan("com.yimoom.pplay.*.dao")
@SpringBootApplication
@EnableCaching
public class PplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PplayApplication.class, args);
	}
}
