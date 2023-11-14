package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    // dml语句（插入 修改 删除）
    int deleteById(Integer id);

    // 指定输出类型 查询语句
    // 根据员工id查询员工姓名
    String queryNameById(Integer id);

    // 根据员工id查询员工工资
    Double querySalaryById(Integer id);

    // 返回单个实体类型
    Employee queryById(Integer id);

    // 返回Map类型
    // 查询部门的最高工资和平均工资
    Map<String,Object> selectEmpNameAndMaxSalary();

    // 查询工资高于传入员工姓名
    List<String> queryNamesBySalary(Double salary);

    // 查询全部员工信息
    List<Employee> queryAll();

    // 员工插入
    int insertEmp(Employee employee);
}