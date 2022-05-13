package com.demo.manage.controller;

import com.demo.manage.model.UserModel;
import com.demo.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    

    @PostMapping("/addUserInMQ")
    public void addUser(UserModel userModel){
        userService.sendUserDetailsViaMQ(userModel);
    }
    
    
}
