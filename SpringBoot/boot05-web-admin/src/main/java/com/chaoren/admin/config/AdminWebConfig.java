package com.chaoren.admin.config;

import com.chaoren.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/",
                        "/sql",
                        "/login",
                        "/css/**",
                        "/fonts/**",
                        "/images/**",
                        "/js/**");
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new HandlerInterceptor() {
//            @Override
//            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//                if (request.getSession().getAttribute("loginUser") == null) {
//                    request.setAttribute("msg","请先登陆账户！！！");
//                    request.getRequestDispatcher("/").forward(request,response);
//                    return false;
//                }
//                return true;
//            }
//
//            @Override
//            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//                HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//            }
//
//            @Override
//            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//                HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//            }
//        }).addPathPatterns("/**").excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
//    }
}
