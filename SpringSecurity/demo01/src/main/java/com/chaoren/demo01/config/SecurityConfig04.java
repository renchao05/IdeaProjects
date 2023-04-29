package com.chaoren.demo01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

//@Configuration
public class SecurityConfig04 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.rememberMeParameter()

        http.rememberMe()
//                .tokenValiditySeconds(20)   //单位是秒
                .tokenRepository(persistentTokenRepository())
                .userDetailsService(userDetailsService);
        http.logout()
                .logoutUrl("/logout")   //退出链接
                .logoutSuccessUrl("/index") //退出后跳转的地址
                .permitAll();

        http.formLogin()    //自定义自己编写的登陆页面
                .loginPage("/login")   //登陆页面设置
                .loginProcessingUrl("/user/login")  //登陆访问路径
//                .successForwardUrl("/success.html")   //登陆成功后跳转页面，或.defaultSuccessUrl("/success",true)
                .failureForwardUrl("/test/fail") //登陆失败后跳转的页面
                .permitAll();   //需要permitAll()结束，不然登陆页面也没法访问

        http.authorizeRequests()
                .antMatchers("/test/01").hasRole("管理员") //管理员才能访问
                .antMatchers("/test/02").hasAnyAuthority("menu:system") //有menu:system权限才能访问
                .anyRequest()   //其他请求
                .authenticated();   //需要认证

//        http.csrf()
//                .disable();    //关闭csrf防护

        http.exceptionHandling().accessDeniedPage("/unauthorized.html");
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        // 赋值数据源
        jdbcTokenRepository.setDataSource(dataSource);
        // 自动创建表,第一次执行会创建，以后要执行就要删除掉！
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
