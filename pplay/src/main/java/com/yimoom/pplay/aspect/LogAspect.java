package com.yimoom.pplay.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LogAspect {
	  private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	    /**
	           * 以自定义注解为切点
	     */
	    @Pointcut("@annotation(com.yimoom.pplay.log.Log)")
	    public void logPointCut() {
	    }
	    @Before("logPointCut()")
	    public void doBefore(JoinPoint pjp) throws Throwable {
			logger.info("当前执行的类是{0},方法是{1},参数是{2}",pjp.getClass(),pjp.getTarget(),pjp.getArgs());
	       
	    }
}
