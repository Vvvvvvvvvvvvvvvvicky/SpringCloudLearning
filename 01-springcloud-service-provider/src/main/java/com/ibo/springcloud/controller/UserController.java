package com.ibo.springcloud.controller;

import com.ibo.springcloud.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("service/user")
    public User simpleuser(){
        System.out.println("1111");
        User user = new User();  //这里使用默认构造方法，利用get、set传参，解决REST方法无法映射对象的问题（具体细节还需要进一步解决）
        user.setId(111);
        user.setName("张三-1");
        user.setPhone("13111122222");
        return user;
    }
}
