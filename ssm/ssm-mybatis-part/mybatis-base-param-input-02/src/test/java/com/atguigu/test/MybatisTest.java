package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void test_01() throws IOException {
        //1.读取外部文件
        InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //3.sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.获取代理mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.queryById(1);
        System.out.println(employee);
        //5.关闭资源|提交事务
        sqlSession.close();
    }
}
