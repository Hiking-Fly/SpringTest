package com.zjnu.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("execution(public void com.zjnu.aop.Target.save())")
    public void before(){
        System.out.println("前置增强。。。。");
    }
}
