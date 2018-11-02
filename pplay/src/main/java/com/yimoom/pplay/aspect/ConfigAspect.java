package com.yimoom.pplay.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class ConfigAspect {
    private static final Logger logger = LoggerFactory.getLogger(ConfigAspect.class);
    /**
           * 以自定义注解为切点
           * //两个..代表所有子目录，最后括号里的两个..代表所有参数
     */
    @Pointcut("execution( * com.yimoom.pplay.config..*.*(..))")
    public void logPointCut() {
    }


    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    	
    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        logger.debug("返回值 : " + ret);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("参数是:{}",pjp.getArgs());
        Object ob = pjp.proceed();// ob 为方法的返回值
        logger.info("耗时 : {}",  (System.currentTimeMillis() - startTime));
        return ob;
    }
}
