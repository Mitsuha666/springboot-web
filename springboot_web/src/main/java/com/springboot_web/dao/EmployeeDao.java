package com.springboot_web.dao;

import com.springboot_web.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper //@Mapper : 表示本类是一个 MyBatis 的 Mapper，等价于以前 Spring 整合 MyBatis 时的 Mapper 接口
@Repository
public interface EmployeeDao {

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
