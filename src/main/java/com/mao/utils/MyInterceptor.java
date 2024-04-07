/**
 * @author: mao
 * @description
 * @date: 2024/4/7 10:17
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle进行拦截......");
        Object loginUser = request.getSession().getAttribute("username");
        if (loginUser == null || !loginUser.equals("admin")){
            request.setAttribute("msg", "当前角色不具备操作权限，请重新登录");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }else {
            return false;
        }
        // true 代表放行请求地址，false代表中断请求地址
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle......");
        return ;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion......");
        return ;
    }
}
