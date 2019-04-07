package com.hsbc.kyc.rpr.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class DefaultHelloService implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void hello() {
        System.out.println("Hello From Hello Service");
        String result = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random",String.class);
        System.out.println(result);
    }
}
