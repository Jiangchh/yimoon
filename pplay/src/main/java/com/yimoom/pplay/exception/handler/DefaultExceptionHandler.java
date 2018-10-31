package com.yimoom.pplay.exception.handler;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yimoom.pplay.annotation.Log;
import com.yimoom.pplay.common.base.entity.Result;
@RestControllerAdvice
public class DefaultExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	/**
	 * 自定义异常
	 */
	@Log("异常，自定义")
	@ExceptionHandler(Exception.class)
	public Result handleBDException(Exception e) {
		logger.error(e.getMessage(), e);
		Result r=new Result(false, null, e.getMessage());
		return r;
	}


}
