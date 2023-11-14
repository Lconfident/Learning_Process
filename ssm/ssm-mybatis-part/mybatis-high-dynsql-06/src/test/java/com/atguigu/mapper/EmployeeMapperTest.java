package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    private SqlSession sqlSession = null;

    @BeforeEach
    public void before() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader("mybatis-config.xml"))
                .openSession();

    }


    @Test
    void query() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.query(null,101.0);
        System.out.println("list = " + list);
    }


    @AfterEach
    public void after(){
        sqlSession.close();
    }

}