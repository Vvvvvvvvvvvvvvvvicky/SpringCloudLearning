package com.ibo.springcloud.controller;

import com.ibo.springcloud.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user/simpleuser")
    public User simpleuser(){
        System.out.println("1111");
        return new User(1,"张三1","13111111111");
    }
}
