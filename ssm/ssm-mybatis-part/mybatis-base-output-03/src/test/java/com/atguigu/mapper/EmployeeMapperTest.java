package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    @Test
    void insertEmp() {
        //1.读取外部文件
        InputStream reader = null;
        try {
            reader = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //2.创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //3.sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //4.获取代理mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpName("Tom2");
        employee.setEmpSalary(8888.0);
        int rows = mapper.insertEmp(employee);
        System.out.println("--------");
        System.out.println("start: " + employee.getEmpId());
        System.out.println("rows = " + rows);
        System.out.println("end: " + employee.getEmpId());
        //5.关闭资源 and 提交事务
        sqlSession.close();
    }
}