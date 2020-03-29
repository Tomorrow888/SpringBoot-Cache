package com.jiajinshuo.sbt_senior.controller;

import com.jiajinshuo.sbt_senior.domain.Employee;
import com.jiajinshuo.sbt_senior.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiajinshuo
 * @create 2020-03-24 12:43
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;
    }


}
