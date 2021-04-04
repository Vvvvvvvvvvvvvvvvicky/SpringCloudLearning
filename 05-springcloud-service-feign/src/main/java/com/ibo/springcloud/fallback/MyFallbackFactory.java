package com.ibo.springcloud.fallback;

import com.ibo.springcloud.service.HelloService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @className MyFallbackFactory
 * @desc 熔断回调方法
 * @author Vic
 * @version 1.0
 * @date 2021/4/5 3:58 下午
 **/
@Component
public class MyFallbackFactory implements FallbackFactory<HelloService> {

    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hello() {
                return throwable.getMessage();
            }
        };
    }
}
