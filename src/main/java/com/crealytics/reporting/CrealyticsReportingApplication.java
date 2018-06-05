package com.crealytics.reporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class CrealyticsReportingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrealyticsReportingApplication.class, args);
	}
}
