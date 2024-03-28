/**
 * @author: mao
 * @description
 * @date: 2024/3/28 14:31
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class UserBeforeAdvice implements MethodBeforeAdvice {


    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置增强");
    }
}
