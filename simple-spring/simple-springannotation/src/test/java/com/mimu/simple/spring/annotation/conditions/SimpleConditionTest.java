package com.mimu.simple.spring.annotation.conditions;

import com.mimu.simple.spring.annotation.conditions.config.SimpleConditionAnnotationConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * author: mimu
 * date: 2019/7/26
 */
public class SimpleConditionTest {
    private static final Logger logger = LoggerFactory.getLogger(SimpleConditionTest.class);

    @Test
    public void info() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(SimpleConditionAnnotationConfig.class);
        configApplicationContext.refresh();
        for (String s : configApplicationContext.getBeanDefinitionNames()) {
            logger.info(s);
        }
        configApplicationContext.getEnvironment().getSystemProperties().forEach((key, value) -> logger.info(key + "=" + value));
    }

    public void info1(){
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register();
    }
}
