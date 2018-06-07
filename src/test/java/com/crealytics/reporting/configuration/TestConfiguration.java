package com.crealytics.reporting.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages={"com.crealytics.reporting.service","com.crealytics.reporting.repositories"})
public class TestConfiguration{ }
