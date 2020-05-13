package com.mimu.simple.spring.szc.inject.test.ann.app;


import com.mimu.simple.spring.szc.inject.ann.app.ApplicationConfig;
import com.mimu.simple.spring.szc.inject.ann.app.ZKPropertyModel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 author: mimu
 date: 2020/4/25
 */
public class ZKCenterInjectTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.refresh();
        ZKPropertyModel bean = context.getBean(ZKPropertyModel.class);
        while (true){
            System.out.println(bean.getAge());
            System.out.println(bean.getName());
            System.out.println(bean.isaBoolean());
            System.out.println(bean.getaBBoolean());
            System.out.println(bean.getTmp());
            System.out.println(bean.getInner());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}