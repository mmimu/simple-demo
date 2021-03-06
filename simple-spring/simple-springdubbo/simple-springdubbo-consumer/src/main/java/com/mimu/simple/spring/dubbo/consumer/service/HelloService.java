package com.mimu.simple.spring.dubbo.consumer.service;

import com.mimu.simple.spring.dubbo.api.HelloStringApi;
import com.mimu.simple.spring.dubbo.exceptions.CustomException;
import com.mimu.simple.spring.dubbo.model.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * author: mimu
 * date: 2019/9/18
 */

/**
 * 使用 dubbo-consumer.xml 文件则需要 注释掉 ServiceConsumerConfig 类， 在该类上添加 dubbo @Service 注解 并注释掉 @Reference 注解
 * 同时 在 属性上 添加 @Autowire 注解
 */
@Slf4j
@Component
@Service
public class HelloService {

    @Autowired
    private HelloStringApi helloStringApi;

    public HelloData getHello(String name) {
        try {
            return helloStringApi.hello(name);
        } catch (CustomException e) {
            log.error("getHello1 error", e);
            return null;
        } catch (Exception e) {
            log.error("getHello2 error", e);
            return null;
        }
    }

    public String getHello2(String name) {
        return helloStringApi.hello2(name);
    }

    public HelloData getHello3(String name) {
        HelloData helloData = helloStringApi.hello3(name);
        log.info("getHello3 result={}", helloData);
        return helloData;
    }
}
