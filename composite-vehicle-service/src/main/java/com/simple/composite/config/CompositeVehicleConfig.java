package com.simple.composite.config;

import java.util.LinkedHashMap;

import org.springframework.boot.actuate.endpoint.InfoEndpoint;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.simple.entity.app.SingletonUUID;

@Configuration
@EnableFeignClients(basePackages = {"com.simple.composite.client"})
@ComponentScan(basePackages = {"com.simple.composite.controller", "com.simple.composite.service"})
public class CompositeVehicleConfig {

    private static SingletonUUID singletonUUID = SingletonUUID.INSTANCE;
    
    @Bean
    public InfoEndpoint infoEndpoint() {
         final LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
         map.put("InstanceID",  singletonUUID.getId());
         return new InfoEndpoint(map);
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public ServletRegistrationBean hystrixStreamServlet(){
        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
    }
}
