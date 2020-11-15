package com.mimu.simple.spring.annotation.autowires;

import org.springframework.stereotype.Component;

@Component
public class DependencyA implements IDependency {
    public void info() {
        System.out.println("this is dependencyA");
    }
}
