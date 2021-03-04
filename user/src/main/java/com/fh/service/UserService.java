package com.fh.service;

import com.fh.model.User;

import java.util.Map;

public interface UserService {
    Map insertUser(User user);

    Map login(User user);

    Map queryUser();

    Map deleteUser(String name);
}
