package com.yimoom.pplay;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.yimoom.pplay.log.Log;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	@Log("参数初始化")
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PplayApplication.class);
	}

}
