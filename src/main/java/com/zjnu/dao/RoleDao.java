package com.zjnu.dao;

import com.zjnu.domain.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> getRoleList();

    int addRole(Role role);

    List<Role> getRolesByUserId(long userId);
}
