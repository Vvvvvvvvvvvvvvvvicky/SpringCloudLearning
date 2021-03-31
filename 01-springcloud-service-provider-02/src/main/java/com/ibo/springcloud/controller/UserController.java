package com.ibo.springcloud.controller;

import com.ibo.springcloud.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("service/user")
    public User simpleuser(){
        User user = new User();
        user.setId(111);
        user.setName("张三-2");
        user.setPhone("13111122222");
        return user;
    }
}
