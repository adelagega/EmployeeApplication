package com.employee.EmployeeApplication.controller;


import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){

        return employeeService.getAllEmployees();
    }

     @GetMapping("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id)
     {
       return  employeeService.getAnEmployee(id);
     }

     //@RequestMapping(value = "/employees",method = RequestMethod.POST)
    @PostMapping("/employees")
     public void createEmployee(@RequestBody Employee employee) {
         employeeService.createEmployee(employee);
     }

    //@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @PutMapping("/employees/{id}")
     public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
         employeeService.updateEmployee(employee);
     }


     //@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/employees/{id}")
     public List<Employee> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployees();
     }
}
  