package com.fh.controller;

import com.fh.model.User;
import com.fh.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;
    /*
    *   注册用户
    * */
    @RequestMapping("insertUser")
    public Map insertLog(User user){
       return userService.insertUser(user);
    }

    /*
    *   登录
    * */
    @RequestMapping("login")
    public Map login (User user){
        return userService.login(user);
    }


    /*
    *   查询用户
    * */
    @RequestMapping("queryUser")
    public Map queryUser(){
        return userService.queryUser();
    }


    /*
    *   删除用户
    *
    * */
    @RequestMapping("deleteUser")
    public Map deleteUser(String name){
        return userService.deleteUser(name);
    }

}
