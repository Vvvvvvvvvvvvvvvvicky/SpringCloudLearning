package com.ibo.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello() {
        //手动指定（需要配置ip、端口）
//        return restTemplate.getForObject("http://localhost:8081/service/hello", String.class);

        //Eureka
        return restTemplate.getForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class);
    }
}
