package com.springboot_web.service;

import com.springboot_web.pojo.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {

    //获取所有部门信息
    public List<Department> getDepartments();

    //通过id得到部门
    public Department getDepartmentById(@Param("id") int id);
}
