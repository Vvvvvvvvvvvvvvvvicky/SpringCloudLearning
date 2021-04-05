package com.ibo.springcloud.service;

import com.ibo.springcloud.fallback.MyFallback;
import com.ibo.springcloud.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="01-SPRINGCLOUD-SERVICE-PROVIDER" ,fallback = MyFallback.class/*,fallbackFactory = MyFallbackFactory.class*/)
public interface HelloService{
    //声明一个服务，即远程调用的方法
    @RequestMapping("service/hello")
    public String hello();
}
