package com.mimu.simple.spring.annotation.demo.core;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author: mimu
 * date: 2019/1/25
 */
@Aspect
public class SimpleLoggerAspectBean {
    private static final Logger logger = LoggerFactory.getLogger(SimpleLoggerAspectBean.class);

    @Pointcut(value = "@annotation(SimpleLogger)")
    public void executeInfo() {
    }

    @After(value = "executeInfo()")
    public void execute() throws Throwable {
        logger.info(" advise info");
    }
}
