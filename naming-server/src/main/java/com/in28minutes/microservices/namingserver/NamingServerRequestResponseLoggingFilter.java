package com.in28minutes.microservices.namingserver;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NamingServerRequestResponseLoggingFilter extends OncePerRequestFilter {
	private Logger logger = LoggerFactory.getLogger(NamingServerRequestResponseLoggingFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Log the request information
        logger.info("Received naming server request: {}", request.getRequestURI());

        // Call the next filter in the chain
        filterChain.doFilter(request, response);

        // Log the response information
        logger.info("Received naming server response: {}", response.getStatus());
    }
}
