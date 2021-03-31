package com.ibo.springcloud.controller;

import com.ibo.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();
    }

    @RequestMapping("/web/getHello")
    public String getHello() {
        //手动指定（需要配置ip、端口）
//        return restTemplate.getForObject("http://localhost:8081/service/hello", String.class);

        //REST的get方法
        ResponseEntity<String> entity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class);

        HttpStatus statusCode = entity.getStatusCode();
        int statusCodeValue = entity.getStatusCodeValue();
        HttpHeaders headers = entity.getHeaders();
        String body = entity.getBody();

        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        System.out.println(body);


        //Eureka
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();
    }



    @RequestMapping("/web/simple-user")
    public User getSimpleUser() {
        //手动指定（需要配置ip、端口）
//        return restTemplate.getForObject("http://localhost:8081/service/hello", String.class);

        //REST的get方法
        ResponseEntity<User> entity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/user/simpleuser", User.class);

        HttpStatus statusCode = entity.getStatusCode();
        int statusCodeValue = entity.getStatusCodeValue();
        HttpHeaders headers = entity.getHeaders();
        User body = entity.getBody();

        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        System.out.println(body);

        //Eureka
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/user/simpleuser", User.class).getBody();
    }



}
