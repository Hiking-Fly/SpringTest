package com.zjnu.dao.impl;

import com.zjnu.dao.UserDao;
import com.zjnu.domain.Role;
import com.zjnu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<User> getUserList() {
        String sql = "select * from sys_user";
        List<User> userList  = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public long saveUser(User user) {
        PreparedStatementCreator psCreater = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psCreater,keyHolder);
        long key = keyHolder.getKey().longValue();
        return key;
    }

    @Override
    public void saveUserRoleRe(long userId, Long[] roleIds) {
        for(Long roleId:roleIds){
            jdbcTemplate.update("insert into sys_user_role values(?,?)",userId,roleId);
        }
    }

    @Override
    public void deleteUserRole(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
    }

    @Override
    public void deleteUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }

    @Override
    public User login(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password = ?",new BeanPropertyRowMapper<User>(User.class),username,password);
        return user;
    }


}
