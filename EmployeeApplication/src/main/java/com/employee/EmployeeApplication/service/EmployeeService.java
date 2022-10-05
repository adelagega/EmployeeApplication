package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class EmployeeService {
    List<Employee> employeelist = new ArrayList(Arrays.asList(
            new Employee(1, "First Employee",
                    "Washington"),
            new Employee(2, "Second Employee",
                    "New York")));


    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
       //return employeelist;
        return employeeRepository.findAll();
    }



    public Employee getAnEmployee(int id)
    {
        /*return employeelist.stream().filter(e -> (
                e.getEmployeeId() == id)).findFirst().get();
                 */
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void createEmployee(Employee employee)
    {
        //employeelist.add(employee);
        ArrayList<Address> addressArrayList=new ArrayList<>();
         for(Address address : employee.getAdresses()) {
             addressArrayList.add(new Address(address.getLine1(),
                     address.getLine2(),
                     address.getZipCode(),
                     address.getCity(),
                     address.getState(),
                     address.getCountry(),employee));
         }
          employee.setAdresses(addressArrayList);
        employeeRepository.save(employee);
    }



    public void updateEmployee(Employee employee) {
       /* List<Employee> tempEmployee = new ArrayList<>();
        for(Employee emp : employeelist) {
           if(emp.getEmployeeId() == employee.getEmployeeId()) {
             emp.setEmployeeName(employee.getEmployeeName());
             emp.setEmployeeCity(employee.getEmployeeCity());
           }
           tempEmployee.add(emp);
        }
        this.employeelist = tempEmployee;
        */
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id){
        /*ArrayList<Employee> tempEmployee = new ArrayList<>();
        for(Employee emp : employeelist){
            if(emp.getEmployeeId() == id)
                continue;
            tempEmployee.add(emp);
        }
        this.employeelist = tempEmployee;

         */
        employeeRepository.delete(employeeRepository.getById(id));
    }

}
