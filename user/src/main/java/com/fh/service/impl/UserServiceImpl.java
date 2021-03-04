package com.fh.service.impl;

import com.fh.model.User;
import com.fh.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Map insertUser(User user) {
        Map map = new HashMap();
        user.setCreateDate(new Date());
        mongoTemplate.save(user);
        map.put("code",200);
        map.put("message","成功");
        return map;
    }
}
