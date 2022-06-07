package com.zjnu.dao.impl;

import com.zjnu.dao.UserMapper;
import com.zjnu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperImpl implements UserMapper {
    @Override
    public List<User> findAll() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userlist = sqlSession.selectList("userMapper.findAll");
        System.out.println(userlist);
        sqlSession.close();
        return userlist;
    }

    @Override
    public void save(User user) {

    }
}
