package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    // 根据id查询员工对象
    Employee queryById(Integer id);

    // 根据id删除员工信息
    int deleteById(Integer id);

    // 根据工资删除员工信息
    List<Employee> queryBySalary(Double salary);

    // 插入员工信息
    int insertEmp (Employee employee);

    // 根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(@Param("name") String name, @Param("salary") Double salary);

    // map接口中不允许重载
    // 插入员工数据，传入map（name=员工名字，salary=薪水）
    int insertEmpMap(Map data);


}
