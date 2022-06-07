package com.zjnu.dao;

import com.zjnu.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    public void save(User user);
}
