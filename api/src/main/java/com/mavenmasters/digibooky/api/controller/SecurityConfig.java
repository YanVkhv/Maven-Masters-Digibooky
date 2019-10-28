//package com.mavenmasters.digibooky.api.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers(
//                "/v2/api-docs",
//                "/configuration/ui",
//                "/swagger-resources",
//                "/configuration/security",
//                "/swagger-ui.html",
//                "/webjars/**",
//                "/swagger-resources/configuration/ui", "/swagger-ui.html");
//    }
//}
