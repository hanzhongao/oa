package com.hza.global;

import com.hza.entity.Employee;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by hza
 * 2019-11-05 10:48
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取 session 中用户信息
        Employee employee = (Employee) request.getSession().getAttribute("employee");

        // 如果 session 中有用户信息，说明已登录过，放行
        if (employee != null) {
            return true ;
        } else { // 如果未登录
            String uri = request.getRequestURI() ; // 获取访问路径
            // 如果访问路径是登录相关功能，直接放行
            if (uri.toLowerCase().contains("login")) {
                return true ;
            } else {
                // 访问路径不是登录，而且session中没有用户信息，拦截
                response.sendRedirect("/to_login"); // 跳转到登录页面

                return false;
            }

        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
