package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void test01() throws IOException {

        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 4. 调用代理类方法既可以触发对应的SQL语句
        Employee employee = employeeMapper.queryById(1);


        // 先用方法
        // Employee employee = session.selectOne("com.atguigu.mapper.EmployeeMapper.queryById",1);

        System.out.println(employee);

        // 4.关闭SqlSession
        // session.commit(); //提交事务 [DQL不需要,其他需要]
        session.close(); //关闭会话

    }

    @Test
    // ibatis 方法
    public void test02() throws IOException {

        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        // EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 内部 去查找sql语句标签
        // jdk动态代理技术生成的mapper代理对象
        // 1.拼接接口的全限定符号，方法名 整合参数 2.ibatis对应的方法传入参数
        // mybatis底层依然调用ibatis，只不过有固定模式！

        // 4. 调用代理类方法既可以触发对应的SQL语句
        // Employee employee = employeeMapper.selectEmployee(1);

        // 3. 调用代理类方法既可以触发对应的SQL语句
        // 参数1：字符串 sql标签对应的标识 id|namespace.id 参数2： Object 执行sql语句传入的参数
        Student student = session.selectOne("com.atguigu.mapper.StudentMapper.queryById",1);

        // 缺点：1.sql标签对应的标识，字符串报错； 2.参数需要进行整合，只能传入一个！ 3.返回值问题！

        System.out.println(student);

        // 4.关闭SqlSession
        // session.commit(); //提交事务 [DQL不需要,其他需要]
        session.close(); //关闭会话

    }
}
