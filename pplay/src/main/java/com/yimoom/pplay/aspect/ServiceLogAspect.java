package com.yimoom.pplay.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ServiceLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);



    @Pointcut("@annotation(com.yimoom.pplay.annotation.ServiceLog)")
    public void logPointCut() {
    }
    /**
     * around注解的区别在于它是带节点参数的可以控制节点执行
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
    	  long startTime = System.currentTimeMillis();
          Object ob = point.proceed();// ob 为方法的返回值
          logger.info("耗时 : " + (System.currentTimeMillis() - startTime));
          return ob;
    }


}
