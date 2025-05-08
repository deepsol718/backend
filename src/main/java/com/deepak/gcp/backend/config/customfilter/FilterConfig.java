package com.deepak.gcp.backend.config.customfilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomFilter> loggingFilter() {
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomFilter()); // Register your custom filter
        registrationBean.addUrlPatterns("/customfilter/*"); // Apply filter to URLs starting with /api/*
        registrationBean.setOrder(1); // Optionally set order of execution
        return registrationBean;
    }
}
