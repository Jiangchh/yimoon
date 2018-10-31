package com.yimoom.pplay.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.yimoom.pplay.common.base.entity.Result;
@RestControllerAdvice
public class WebExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public Result handleBDException(NoHandlerFoundException e) {
		logger.error(e.getMessage(), e);
		Result r=new Result(false, "kale", e.getMessage());
		return r;
	}
}
