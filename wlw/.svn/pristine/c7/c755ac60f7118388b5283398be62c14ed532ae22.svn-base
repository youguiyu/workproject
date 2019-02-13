package com.ygy.lteproj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication

@MapperScan(value = "com.ygy.lteproj.mapper")
public class LteprojApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
   	return application.sources(LteprojApplication.class);
   }
	public static void main(String[] args) {
		SpringApplication.run(LteprojApplication.class, args);
	}
}
