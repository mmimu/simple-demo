package com.mimu.simple.springboot;

import com.mimu.simple.springboot.conditions.config.AppConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: mimu
 * date: 2019/10/8
 */
public class SpringbootConditionTest {
    private static final Logger logger = LoggerFactory.getLogger(SpringbootConditionTest.class);

    @Test
    public void info() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //configApplicationContext.register(AppConfig.class);
        //configApplicationContext.refresh();
        for (String s : configApplicationContext.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        //configApplicationContext.getEnvironment().getSystemProperties().forEach((key, value) -> logger.info(key + "=" + value));
    }
}
