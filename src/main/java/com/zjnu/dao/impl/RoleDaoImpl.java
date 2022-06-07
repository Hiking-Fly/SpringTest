package com.zjnu.dao.impl;

import com.zjnu.dao.RoleDao;
import com.zjnu.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Role> getRoleList() {
        String sql = "Select * from sys_role";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public int addRole(Role role) {
        String sql = "insert into sys_role values(Null,?,?)";
        int res = jdbcTemplate.update(sql,role.getRoleName(),role.getRoleDesc());
        return res;
    }

    @Override
    public List<Role> getRolesByUserId(long userId) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role sur,sys_role sr where userId=? and sur.roleid=sr.id"
                ,new BeanPropertyRowMapper<Role>(Role.class),userId);
        return roles;
    }
}
