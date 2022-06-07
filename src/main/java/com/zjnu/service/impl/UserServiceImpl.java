package com.zjnu.service.impl;

import com.zjnu.dao.RoleDao;
import com.zjnu.dao.UserDao;
import com.zjnu.dao.UserMapper;
import com.zjnu.dao.impl.UserDaoImpl;
import com.zjnu.dao.impl.UserMapperImpl;
import com.zjnu.domain.Role;
import com.zjnu.domain.User;
import com.zjnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private UserMapper userMapper = new UserMapperImpl();
    @Autowired
    private RoleDao roleDao;
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = userMapper.findAll();
        for(User user:userList){
           long userId = user.getId();
           List<Role> roles = roleDao.getRolesByUserId(userId);
           user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public boolean saveUser(User user,Long[] roleIds) {
        long userId = userDao.saveUser(user);
        userDao.saveUserRoleRe(userId,roleIds);
        if(userId>0)return true;
        else return false;
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUserRole(userId);
        userDao.deleteUser(userId);
    }

    @Override
    public User login(String username, String password) {
        User user;
        try{
            user = userDao.login(username,password);
        }catch (EmptyResultDataAccessException e){
            user = null;
        }
        return user;
    }


}
