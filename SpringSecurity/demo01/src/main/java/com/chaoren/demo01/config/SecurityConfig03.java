package com.chaoren.demo01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
public class SecurityConfig03 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()    //自定义自己编写的登陆页面
                .loginPage("/login.html")   //登陆页面设置
                .loginProcessingUrl("/user/login")  //登陆访问路径
                .successForwardUrl("/test/success")   //登陆成功后跳转页面，或.defaultSuccessUrl("/success",true)
                .failureForwardUrl("/test/fail") //登陆失败后跳转的页面
                .permitAll();   //需要permitAll()结束，不然登陆页面也没法访问

        http.authorizeRequests()
//                .antMatchers("/test/01").hasAuthority("admins") //设置有admins权限的可以访问
//                .antMatchers("/test/01").hasAnyAuthority("admins,user") //用户只要有admins,user其中一个都可以访问
                .antMatchers("/test/01").hasRole("admin") //
                .antMatchers("/", "/test/hello", "/test/index").permitAll() //设置不需要登陆可以直接访问的页面
                .anyRequest()   //其他请求
                .authenticated();   //需要认证

        http.csrf()
                .disable();    //关闭csrf防护
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
