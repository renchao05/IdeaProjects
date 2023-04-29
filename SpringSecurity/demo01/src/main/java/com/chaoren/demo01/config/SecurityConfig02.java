package com.chaoren.demo01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig02 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //对请求进行授权
                .antMatchers("/test/success","/test-api") //使用 ANT 风格设置要授权的 URL 地 址
                .permitAll();
        http.formLogin()    //自定义自己编写的登陆页面
                .loginPage("/login.html")   //登陆页面设置
                .loginProcessingUrl("/user/login")  //登陆访问路径
                .successForwardUrl("/test/index")
                .usernameParameter("loginAcct") //表单用户名属性名
                .passwordParameter("userPwd")   //表单密码属性名
                .defaultSuccessUrl("/").permitAll() //登陆成功后跳转页面
                .and().authorizeRequests()
                .antMatchers("/","/test/hello","/test/index").permitAll() //设置不需要登陆可以直接访问的页面
                .anyRequest()
                .authenticated()
                .and().csrf().disable();    //关闭csrf防护
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
