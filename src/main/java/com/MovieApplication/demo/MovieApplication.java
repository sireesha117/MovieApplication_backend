package com.MovieApplication.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.MovieApplication.demo.filter.JWTFilter;

@SpringBootApplication
public class MovieApplication {
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
	 FilterRegistrationBean fb = new FilterRegistrationBean();
	 fb.setFilter(new JWTFilter());
	 fb.addUrlPatterns("/api/v1/*");
	 return fb;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MovieApplication.class, args);

	}

}
