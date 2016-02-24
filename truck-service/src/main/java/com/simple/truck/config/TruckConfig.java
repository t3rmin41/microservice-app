package com.simple.truck.config;

import javax.servlet.Servlet;

import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.access.tomcat.LogbackValve;

@Configuration
@ComponentScan(basePackages = {"com.simple.truck.controller", "com.simple.truck.service", "com.simple.truck.repository"})
public class TruckConfig {
    
    @Bean
    @ConditionalOnClass({ Servlet.class, Tomcat.class })
    public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory(@Value("${embedded.tomcat.logback.access.config.path:}") String logbackAccessPath) {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.addContextValves(getLogbackValve());
        return factory;
    }
    
    private LogbackValve getLogbackValve() {
        LogbackValve logbackValve = new LogbackValve();
        logbackValve.setFilename("src/main/resources/logback-access.xml");
        return logbackValve;
    }
}
