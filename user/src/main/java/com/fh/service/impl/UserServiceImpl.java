package com.fh.service.impl;

import com.alibaba.fastjson.JSON;
import com.fh.model.User;
import com.fh.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Map insertUser(User user) {
        Map map = new HashMap();
        String name = user.getName();
        Query query2=new Query(Criteria.where("name").is(name));
        User one = mongoTemplate.findOne(query2, User.class);
        if(one!=null){
            map.put("code",400);
            map.put("message","账号已存在");
            return map;
        }else {
            user.setCreateDate(new Date());
            mongoTemplate.save(user);
            map.put("code",200);
            map.put("message","成功");
            return map;
        }
    }

    @Override
    public Map login(User user) {
        Map map = new HashMap();
        //构建查询条件
        String name = user.getName();
        Query query2=new Query(Criteria.where("name").is(name));
        User one = mongoTemplate.findOne(query2, User.class);
        if (one!=null){
            if (one.getPassword().equals(user.getPassword())){
                map.put("code",200);
                map.put("message","登录成功");
                return map;
            }else {
                //密码错误
                map.put("code",400);
                map.put("message","密码错误");
                return map;
            }
        }else {
            //用户名不存在
            map.put("code",300);
            map.put("message","用户名不存在");
            return map;
        }

    }

    @Override
    public Map queryUser() {
        Query query = new Query();
        Map map = new HashMap();
        List<User> users = mongoTemplate.find(query, User.class);
        map.put("code",200);
        map.put("message","查询成功");
        map.put("data",users);
        return map;
    }

    @Override
    public Map deleteUser(String name) {
        Map map = new HashMap();
        Query query = Query.query(Criteria.where("name").is(name));
        mongoTemplate.remove(query,User.class);
        map.put("code",200);
        map.put("message","删除成功");
        return map;
    }
}
