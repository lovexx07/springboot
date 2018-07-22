package net.xdclass.demo2.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/api/*", filterName = "loginfilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("dofilter loginFilter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        String username = req.getParameter("username");
        if("xdclass".equals(username)){
            chain.doFilter(request, response);
        }else {
            return;
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy loginFilter");
    }
}
