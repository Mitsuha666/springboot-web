package com.springboot_web.controller;

import com.springboot_web.dao.DepartmentDao;
import com.springboot_web.dao.EmployeeDao;
import com.springboot_web.pojo.Department;
import com.springboot_web.pojo.Employee;
import com.springboot_web.service.DepartmentService;
import com.springboot_web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;  //表现层调业务层
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门信息
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加操作
        System.out.println("add==>"+ employee);
        employeeService.add(employee);
        //添加后返回员工列表
        return "redirect:/emps";
    }

    //跳转到修改页面
    @RequestMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
        //查出原来的员工数据
        Employee employeeById = employeeService.getEmployeeById(id);
        model.addAttribute("emp",employeeById);
        //查出所有的部门信息
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    //修改
    @PostMapping("/update")
    public String updateEmp(Employee employee){
        employeeService.update(employee);
        return "redirect:/emps";
    }

    //删除
    @RequestMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.delete(id);
        return "redirect:/emps";
    }
}
