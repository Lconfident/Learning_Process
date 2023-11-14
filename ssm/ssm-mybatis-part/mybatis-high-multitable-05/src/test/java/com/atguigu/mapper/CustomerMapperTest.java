package com.atguigu.mapper;

import com.atguigu.pojo.Customer;
import com.atguigu.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

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
    void queryList() {
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        System.out.println("customers: " + customers);

        for (Customer customer : customers){
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList = "+orderList);
        }
    }
}