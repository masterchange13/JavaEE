/**
 * @author: mao
 * @description
 * @date: 2024/3/28 16:19
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspectProxy {

    @Before(value = "execution(* com.mao.mapper.Impl.TestMapperImpl.*(..))")
    public void before(){
        System.out.println("注解化的前置增强");
    }


//    @After()


    @Around(value = "execution(* *.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");
    }


}
