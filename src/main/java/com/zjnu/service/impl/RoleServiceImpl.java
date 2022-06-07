package com.zjnu.service.impl;

import com.zjnu.dao.RoleDao;
import com.zjnu.domain.Role;
import com.zjnu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = roleDao.getRoleList();
        return roleList;
    }

    @Override
    public boolean saveRole(Role role) {
        int res = roleDao.addRole(role);
        if(res>=0) return true;
        else return false;
    }

}
