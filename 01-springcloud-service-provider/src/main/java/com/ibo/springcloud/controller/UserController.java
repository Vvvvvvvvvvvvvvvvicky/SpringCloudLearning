package com.ibo.springcloud.controller;

import com.ibo.springcloud.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping("service/user")
    public User simpleuser(){
        User user = new User();  //这里使用默认构造方法，利用get、set传参，解决REST方法无法映射对象的问题（具体细节还需要进一步解决）
        user.setId(111);
        user.setName("张三-1");
        user.setPhone("13111122222");
        return user;
    }

    @RequestMapping("service/userWithParam")
    public User userWithParam(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("phone") String phone){
        User user = new User();  //这里使用默认构造方法，利用get、set传参，解决REST方法无法映射对象的问题（具体细节还需要进一步解决）
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        return user;
    }

    @PostMapping("service/addUser")
    public User addUser(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("phone") String phone){
        User user = new User();  //这里使用默认构造方法，利用get、set传参，解决REST方法无法映射对象的问题（具体细节还需要进一步解决）
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        return user;
    }
}
