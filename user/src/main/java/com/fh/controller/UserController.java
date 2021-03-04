package com.fh.controller;

import com.fh.model.User;
import com.fh.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("insertUser")
    public Map insertLog(User user){
       return userService.insertUser(user);
    }

}
