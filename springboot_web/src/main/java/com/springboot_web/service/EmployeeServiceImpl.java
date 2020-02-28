package com.springboot_web.service;

import com.springboot_web.dao.EmployeeDao;
import com.springboot_web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;  //业务层调持久层

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }
}
