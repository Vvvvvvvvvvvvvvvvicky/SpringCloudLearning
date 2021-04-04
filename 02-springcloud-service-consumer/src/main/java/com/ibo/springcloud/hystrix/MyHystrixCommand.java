package com.ibo.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @className MyHystrixCommand
 * @desc 自定义Hystrix处理
 * @author Vic
 * @version 1.0
 * @date 2021/4/3 7:28 下午
 **/
public class MyHystrixCommand extends HystrixCommand {

    private RestTemplate restTemplate;

    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected Object run() throws Exception {
        //第一种：客户端本身有异常
        int result = 10/0;

        //调用远程的服务（远程服务有异常）
        return restTemplate.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello", String.class).getBody();
    }

    /**
     * 当远程服务超时、异常、不可用等情况时，会触发该熔断方法
     */
    @Override
    public String getFallback() {
        Throwable throwable = super.getExecutionException();

        System.out.println(throwable.getMessage());
        System.out.println(throwable.getStackTrace());

        //实现服务熔断/降级逻辑
        return "error";
    }
}
