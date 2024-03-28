/**
 * @author: mao
 * @description
 * @date: 2024/3/28 14:33
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.LinkedMultiValueMap;

public class UserAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕增强之前...");
        Object proceed = invocation.proceed();
        System.out.println("环绕增强之后...");

        return proceed;
    }
}
