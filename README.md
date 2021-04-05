01-springcloud-service-provider
服务提供者

01-springcloud-service-provider-02
服务提供者02

模拟多个服务，观察consumer中Ribbon的负载均衡
注意：如果使用了Rest方法获取对象，不能通过构造方法创建（要通过默认构造方法，利用get、set传参），否则会报406错误

02-springcloud-service-consumer
服务消费者
（调整了Ribbon的默认负载均衡策略，进行观察）

03-springcloud-eureka-server
服务注册中心(Ribbon)
有两个实例（通过启动指定不同的配置文件实现两个注册服务，实现注册中心的高可用）

04-springcloud-hystrix-dashboard
hystrix的dashboard，配置成单独的一个服务，用来监控查看服务状态

05-springcloud-service-feign
feign的使用（注意与Ribbon的使用区别）

06-springcloud-api-gateway
网关

分布式配置中心也可以测试一下，具体方式见笔记