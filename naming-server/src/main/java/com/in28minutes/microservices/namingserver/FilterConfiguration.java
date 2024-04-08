package com.in28minutes.microservices.namingserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

	@Autowired
	private RequestResponseLoggingFilter requestResponseLoggingFilter;

	@Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(requestResponseLoggingFilter);
		registrationBean.addUrlPatterns("/*");

		return registrationBean;
	}
}
