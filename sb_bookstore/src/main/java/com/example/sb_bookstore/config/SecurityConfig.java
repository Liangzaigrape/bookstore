package com.example.sb_bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                //关闭spring security的csrf功能
                .authorizeHttpRequests(authorize -> authorize
                        //放行/test的访问，不用验证
                        .requestMatchers("/test").permitAll()
                        .requestMatchers("/register").permitAll()
                        // “/**”放行/ 根路径以及其子路径，相当于整个系统不用验证了
                        //可以使用“/*” 表示只放行根目录下页面和请求
                        .requestMatchers("/**").permitAll()
                        //除了以上规则，默认拦截所有URL请求，要求认证后才能访问（该语句必须要放在末尾）
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        /// 定义登陆页面，不用验证
                        .loginPage("/login")
                        .permitAll()
                )
                //开始记住我,保持登录状态
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }
}