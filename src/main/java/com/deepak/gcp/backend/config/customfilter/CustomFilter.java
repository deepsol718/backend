package com.deepak.gcp.backend.config.customfilter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

public class CustomFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("************************************** inside customFilter init() method");
    }

//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("************************************** inside customFilter doFilter() method");
//        filterChain.doFilter(servletRequest,servletResponse);
//
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("************************************** inside customFilter doFilter() method");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // Print request method and URL
        System.out.println(request.getMethod() + " " + request.getRequestURI());

        // Print query parameters
        request.getParameterMap().forEach((key, values) -> {
            System.out.println("Parameter: " + key + " = " + Arrays.toString(values));
        });

        // Print headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println("Header: " + headerName + " = " + headerValue);
        }

        // Print attributes (if any are set)
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = request.getAttribute(attributeName);
            System.out.println("Attribute: " + attributeName + " = " + attributeValue);
        }

        System.out.println("**************************************");

        // Continue with filter chain
        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void destroy() {
        System.out.println("************************************** inside customFilter destroy() method");
    }
}
