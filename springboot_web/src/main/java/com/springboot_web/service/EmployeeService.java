package com.springboot_web.service;

import com.springboot_web.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    //更新一名员工
    public void update(Employee employee);

    //增加员工
    public void add(Employee employee);

    //获取所有员工信息
    public List<Employee> getAll();

    //通过id得到员工
    public Employee getEmployeeById(@Param("id") int id);

    //删除员工
    public void delete(int id);
}
