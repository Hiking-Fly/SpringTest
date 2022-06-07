package com.zjnu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre..");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after....");
    }
//    pre..
//    pre222...
//    post2222....
//    post...
//    after222....
//    after....

//     <!--<mvc:interceptor>
//            <mvc:mapping path="/**"/>
//            <bean class="com.zjnu.interceptor.EncodingInterceptor"></bean>
//        </mvc:interceptor>
//        <mvc:interceptor>
//            <mvc:mapping path="/**"/>
//            <bean class="com.zjnu.interceptor.MyHandler"></bean>
//        </mvc:interceptor>-->
}
