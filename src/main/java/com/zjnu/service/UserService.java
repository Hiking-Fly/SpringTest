package com.zjnu.service;

import com.zjnu.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    boolean saveUser(User user,Long[] roleIds);

    void deleteUser(Long userId);

    User login(String username, String password);
}
