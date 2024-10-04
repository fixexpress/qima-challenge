package com.qima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll() 
                .requestMatchers("/css/**", "/js/**").permitAll()
                
                .requestMatchers("/products").permitAll()
                .requestMatchers("/qima-challenge/products").permitAll()
                
                
                //.requestMatchers("/products").authenticated()
                //.requestMatchers("/qima-challenge/products").authenticated() 
                .anyRequest().authenticated() 
            )
            .formLogin()
                .loginPage("/login") 
                .permitAll(); 

        return http.build();
    }
}
