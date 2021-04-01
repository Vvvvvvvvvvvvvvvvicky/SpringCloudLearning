package com.ibo.springcloud.controller;

import com.ibo.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        //REST的get方法（不带参数，返回是字符串）
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


    //GET
    @RequestMapping("/web/user")
    public User getSimpleUser() {
        //REST的get方法（不带参数，返回是对象）
        ResponseEntity<User> entity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user", User.class);

        HttpStatus statusCode = entity.getStatusCode();
        int statusCodeValue = entity.getStatusCodeValue();
        HttpHeaders headers = entity.getHeaders();
        User body = entity.getBody();

        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        System.out.println(body);

        //Eureka
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user", User.class).getBody();
    }

    //GET
    @RequestMapping("/web/userWithParam")
    public User userWithParam() {
        //1.REST的get方法(带参数，数组形式)
//        Object[] array = {123,"李四","12121212"};
//        ResponseEntity<User> entity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/userWithParam?id={0}&name={1}&phone={2}", User.class,array);

        //2.REST的get方法(带参数，map形式)
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("id", 222);
        paramMap.put("name", "王五");
        paramMap.put("phone", "131313131");
        ResponseEntity<User> entity = restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/userWithParam?id={id}&name={name}&phone={phone}", User.class,paramMap);


        HttpStatus statusCode = entity.getStatusCode();
        int statusCodeValue = entity.getStatusCodeValue();
        HttpHeaders headers = entity.getHeaders();
        User body = entity.getBody();

        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        System.out.println(body);

        //Eureka
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/userWithParam?id={id}&name={name}&phone={phone}", User.class,paramMap).getBody();
    }


    //POST
    @RequestMapping("/web/addUser")
    public User addUser() {
        //要传的表单信息，参数数据（很坑人的）
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<String, Object>();
        dataMap.add("id", 1414);
        dataMap.add("name", "赵六");
        dataMap.add("phone", "13700000000");

        //调用SpringCloud服务提供者提供的服务
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/addUser", dataMap, User.class);

        User body1 = restTemplate.postForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/addUser", dataMap, User.class);

        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        User body2 = responseEntity.getBody();
        System.out.println(body2.getId() + "--" + body2.getName() + "--" + body2.getPhone());

        System.out.println(statusCodeValue);
        System.out.println(httpStatus);
        System.out.println(httpHeaders);

        System.out.println(body1.getId() + "--" + body1.getName() + "--" + body1.getPhone());

        return restTemplate.postForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/addUser", dataMap, User.class).getBody();

    }

    //POST/DELETE
}
