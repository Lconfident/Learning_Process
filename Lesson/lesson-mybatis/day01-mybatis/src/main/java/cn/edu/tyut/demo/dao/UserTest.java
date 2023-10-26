package cn.edu.tyut.demo.dao;

import cn.edu.tyut.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserTest {
    @Test
    public void userFindByIdTest(){
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        //读取文件内容到reader对象中
        try {
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //初始化Mybatis数据库，创建SqlSessionFactory类的实例
        SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(reader);
        //创建Session实例
        SqlSession session = factory.openSession();

        //进行操作
        // 查询
        User user = session.selectOne("cn.edu.tyut.demo.dao.UserMapper.findById",1);

        // 插入
        // User user1 = new User();
        // user1.setId(4);
        // user1.setName("小龙");
        // user1.setSex("男");
        // user1.setAge(500);
        // session.insert("cn.edu.tyut.demo.dao.UserMapper.addUser",user1);

        //删除
        // session.delete("cn.edu.tyut.demo.dao.UserMapper.deleteUser",4);

        // 修改
        User user2 = new User();
        user2.setId(2);
        user2.setName("小明");
        user2.setSex("male");
        user2.setAge(19);
        session.update("cn.edu.tyut.demo.dao.UserMapper.updateUser",user2);

        List<User> users = session.selectList("cn.edu.tyut.demo.dao.UserMapper.findAllUsers");
        session.commit();


        //显示结果
        System.out.println(user);
        System.out.println("=========================");
        System.out.println(users);
        System.out.println("=========================");

        session.close();
    }
}
