package com.zjnu.dao;

import com.zjnu.domain.Role;
import com.zjnu.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    long saveUser(User user);

    void saveUserRoleRe(long userId, Long[] roleIds);

    void deleteUserRole(Long userId);

    void deleteUser(Long userId);

    User login(String username, String password);
}
