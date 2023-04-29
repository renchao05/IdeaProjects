package com.renchao.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //对请求进行授权
                .antMatchers("/layui/**", "/index.jsp") //使用 ANT 风格设置要授权的 URL 地 址
                .permitAll() //允许上面使用 ANT 风格设置的全部请求
                .anyRequest() //其他未设置的全部请求
                .authenticated() //需要认证
                .and()
                .formLogin()    //自定义自己编写的登陆页面
                .loginPage("/index.jsp")   //登陆页面设置
                .loginProcessingUrl("/user/login")  //登陆访问路径
                .defaultSuccessUrl("/main.html") //设置登录成功后默认前往的 URL 地址
                .permitAll()
                .usernameParameter("loginAcct") // 定制登录账号的请求参数名
                .passwordParameter("userPswd") // 定制登录密码的请求参数名
                .and()
                .logout()
                .logoutUrl("/logout")   //退出链接
                .logoutSuccessUrl("/") //退出后跳转的地址
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler((request,response,accessDeniedException) -> {
                    request.setAttribute("message", accessDeniedException.getMessage());
                    request.getRequestDispatcher("/WEB-INF/views/no_auth.jsp").forward(request, response);
                })
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("chao")
                .password(bCryptPasswordEncoder().encode("123"))
                .roles("ADMIN")
                .and()
                .withUser("yue")
                .password(bCryptPasswordEncoder().encode("321"))
                .roles("ask,admins");
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
