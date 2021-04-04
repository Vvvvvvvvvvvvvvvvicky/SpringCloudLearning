package com.ibo.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("service/hello")
    public String hello(){
        //模拟超时情况，查看hystrix超时熔断场景
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello,world -02";
    }
}
