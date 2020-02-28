package com.springboot_web.dao;

import com.springboot_web.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper //@Mapper : 表示本类是一个 MyBatis 的 Mapper，等价于以前 Spring 整合 MyBatis 时的 Mapper 接口
@Repository
public interface DepartmentDao {

    //获取所有部门信息
    public List<Department> getDepartments();

    //通过id得到部门
    public Department getDepartmentById(@Param("id") int id);
}
