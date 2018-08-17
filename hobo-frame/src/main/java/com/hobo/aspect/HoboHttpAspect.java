package com.hobo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lixianfeng on 2018/8/16.
 */
@Aspect
@Component
public class HoboHttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HoboHttpAspect.class);

    @Pointcut("execution(public * com.hobo.controller.*.*(..))")
    public void aspect(){

    }

    @Before("aspect()")
    public void beforeAspect(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class.method={}",joinPoint.getSignature().getDeclaringTypeName().concat(".").concat(joinPoint.getSignature().getName()));
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("aspect()")
    public void afterAspect(){

    }

    @AfterReturning(returning = "object",pointcut = "aspect()")
    public void afterReturning(Object object){

    }
}
