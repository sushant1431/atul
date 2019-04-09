package com.hsbc.kyc.rpr.demo;

import com.hsbc.kyc.rpr.demo.service.RprThreadPool;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RprConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RprConsoleApplication.class, args);
    }

    @Bean
    public RprThreadPool getRprThreadPool() {
        return new RprThreadPool();
    }

    @Override
    public void run(String... args) throws Exception {
        getRprThreadPool().start();
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }
}
