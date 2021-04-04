package com.ibo.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("service/hello")
    public String hello(){
        //模拟异常返回，激活熔断
        int result=10/0;

        return "Hello,world -01";
    }
}
