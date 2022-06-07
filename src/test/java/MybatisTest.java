import com.zjnu.dao.UserMapper;
import com.zjnu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userlist = sqlSession.selectList("userMapper.findAll");
        List<User> userlist = userMapper.findAll();
        System.out.println(userlist);
        sqlSession.close();
    }
    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("tomm");
        user.setEmail("fiuhweai@afoiej.com");
        user.setPassword("123");
        user.setPhoneNum("123213141");
        user.setBirthday(new Date());
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.save(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("userMapper.fildUserById",1);
        System.out.println(user);
        sqlSession.close();
    }
}
