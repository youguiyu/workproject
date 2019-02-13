package com.ygy.syh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
@MapperScan(value = "com.ygy.syh.dao")
@Configuration
@SpringBootApplication
public class SyhApplication extends SpringBootServletInitializer implements WebApplicationInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SyhApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SyhApplication.class, args);
	}
}
