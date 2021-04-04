package com.ibo.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class BeanConfig {

    @LoadBalanced  //Ribbon实现负载均衡
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*
     * description  指定负载均衡策略（此处是重试策略，默认是轮询）——测试：关闭其中一个服务，由轮询改为发单个服务
     * date         2021/3/30 8:46 下午
     * @author      vic
     * @param
     * @return      com.netflix.loadbalancer.IRule
     */
    @Bean
    public IRule iRule(){
        //重试策略
//        return new RetryRule();

        //采用默认轮询策略，查看熔断现象
        return new RoundRobinRule();
    }
}
