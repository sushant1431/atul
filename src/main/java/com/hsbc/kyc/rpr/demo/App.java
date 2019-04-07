package com.hsbc.kyc.rpr.demo;

import com.hsbc.kyc.rpr.demo.service.DefaultHelloService;
import com.hsbc.kyc.rpr.demo.service.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public HelloService getHelloService(){
        return  new DefaultHelloService();
    }

    @Override
    public void run(String... args) throws Exception {
        getHelloService().hello();
    }



    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }
}
