package com.demo.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.manage.dto.UserDto;
import com.demo.manage.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    

    @PostMapping("/addUserInMQ")
    public void addUser(UserDto userDto){
        userService.sendUserDetailsViaMQ(userDto);
    }
    
    
}
