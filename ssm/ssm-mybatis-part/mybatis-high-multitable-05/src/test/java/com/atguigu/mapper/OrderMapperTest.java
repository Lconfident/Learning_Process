package com.atguigu.mapper;

import com.atguigu.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    private SqlSession sqlSession;

    @BeforeEach
    public void before() throws IOException {
        // Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        // SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // sqlSession = sqlSessionFactory.openSession();
        sqlSession = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader("mybatis-config.xml"))
                .openSession();
    }

    @AfterEach
    public void afeter(){
        sqlSession.close();
    }


    @Test
    void queryOrderById() {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.queryOrderById(1);
        System.out.println(order);
        System.out.println(order.getCustomer());
    }
}