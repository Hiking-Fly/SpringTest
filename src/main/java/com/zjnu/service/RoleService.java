package com.zjnu.service;

import com.zjnu.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList();
    boolean saveRole(Role role);
}
