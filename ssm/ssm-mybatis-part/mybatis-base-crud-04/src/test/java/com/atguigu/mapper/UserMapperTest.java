package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


class UserMapperTest {

    private SqlSession sqlSession;
    // 每次走测试方法之前调用
    @BeforeEach
    public void before() throws IOException{
        // 读取数据流
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        sqlSession = sqlSessionFactory.openSession(true);//开启自动提交
    }
    // 每次走测试方法之后调用
    @AfterEach
    public void close(){
        sqlSession.close();
    }

    @Test
    void insert() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setPassword("123456");
        user.setUsername("root");

        int insert = mapper.insert(user);
        System.out.println("insert = "+ insert);
    }

    @Test
    void update() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setPassword("123456");
        user.setUsername("root");

        int update = mapper.update(user);
        System.out.println("update" + update);
    }

    @Test
    void delete() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete(1);
        System.out.println("delete = " + delete);

    }

    @Test
    void selectById() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void selectAll() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
    }
}