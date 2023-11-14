package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    // 使用插件
    @Test
    void query() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 调用之前，设置分页数据（当前是第几页，每页多少容量）

        PageHelper.startPage(1,2);
        List<Employee> list = mapper.queryList();

        // 将查询数据封装到一个PageInfo的分页实体类中（一共有多少页，一共有多少条）

        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        // pageInfo获取分页数据
        // 当前页的数据
        List<Employee> list1 = pageInfo.getList();
        // 总页数
        int pages = pageInfo.getPages();
        // 获取总条数
        long total = pageInfo.getTotal();


    }


    @AfterEach
    public void after(){
        sqlSession.close();
    }

}