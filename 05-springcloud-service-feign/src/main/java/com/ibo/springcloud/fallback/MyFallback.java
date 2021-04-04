package com.ibo.springcloud.fallback;

import com.ibo.springcloud.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @className MyFallback
 * @desc 熔断回调方法
 * @author Vic
 * @version 1.0
 * @date 2021/4/4 3:58 下午
 **/
@Component
public class MyFallback implements HelloService {
    @Override
    public String hello() {
        return "远程服务异常";
    }
}
