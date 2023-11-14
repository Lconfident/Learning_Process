package com.atguigu.mapper;


import com.atguigu.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

class TeacherMapperTest {

    @Test
    void insertTeacher() {
        // 1.读取外部文件
        InputStream reader = null;
        try {
            reader = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 2.创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 3.sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 4.获取代理mapper对象
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = new Teacher();
        teacher.settName("hhh");

        // // 自己维护逐主键
        // String id = UUID.randomUUID().toString().replaceAll("-", "");
        // teacher.settId(id);

        int i = mapper.insertTeacher(teacher);

        System.out.println(teacher.gettId());
        System.out.println("i = " + i);

        // 5.关闭资源 and 提交事务
        sqlSession.close();
    }

    @Test
    void queryById() throws IOException {
        // 1.读取外部文件
        InputStream reader = null;
        reader = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 3.sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.获取代理mapper对象
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.queryById("xxxasd");
        System.out.println(teacher);

        sqlSession.close();
    }
}