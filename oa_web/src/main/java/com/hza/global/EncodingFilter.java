package com.hza.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create by hza
 * 2019-11-04 14:09
 */
public class EncodingFilter implements Filter {

    private String encoding = "utf-8" ;  // 设置默认字符集

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // 从 web.xml读取参数 encoding 的字符集，如果不为空则使用 配置文件中的字符集，否则使用默认 UTF-8
        if (filterConfig.getInitParameter("encoding") != null) {
            encoding = filterConfig.getInitParameter("encoding") ;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest ;
        HttpServletResponse response = (HttpServletResponse) servletResponse ;
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
