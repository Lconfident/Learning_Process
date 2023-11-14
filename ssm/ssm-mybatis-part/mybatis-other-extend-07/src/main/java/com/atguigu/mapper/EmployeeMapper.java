package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    // 根据员工的姓名和工资查询员工的信息
    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    List<Employee> queryTrim(@Param("name") String name, @Param("salary") Double salary);

    // 根据员工的id更新员工数据 要求传入的name和salary不为空
    int update(Employee employee);

    // 根据两个条件查询，如果姓名不为空就用姓名，如果姓名为空，薪水不为空就是用薪水查询！都为null查询全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    // 根据id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

    // 根据id批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);

    // 批量添加
    int insertBatch(@Param("list") List<Employee> employeeList);

    // 批量修改
    int updateBatch(@Param("list") List<Employee> employeeList);

    List<Employee> queryList();
}
