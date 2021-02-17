package com.programing.springboot.curdapp.rest;

import com.programing.springboot.curdapp.entity.Employee;
import com.programing.springboot.curdapp.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private final EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @RequestMapping("/employees")
  public List<Employee> findAllEmployee() {
    return employeeService.findAll();
  }

  @RequestMapping("/employees/{employeeId}")
  public Employee findByEmployeeId(@PathVariable int employeeId) {
    return employeeService.findById(employeeId);
  }

  @PostMapping("/employee")
  public Employee saveEmployee(@RequestBody Employee employee) {
    if (employee.getId() != 0) {
      throw new RuntimeException(
          "The input JSON to insert a new employee is not correctly formatted");
    }
    return employeeService.save(employee);
  }

  @DeleteMapping("/employees/{employeeId}")
  public String deleteEmployee(@PathVariable int employeeId) {

    Employee tempEmployee = employeeService.findById(employeeId);

    // throw exception if null

    if (tempEmployee == null) {
      throw new RuntimeException("Employee id not found - " + employeeId);
    }

    employeeService.deleteById(employeeId);

    return "Deleted employee id - " + employeeId;
  }

  @PutMapping("/employee")
  public Employee updateEmployee(@RequestBody Employee employee) {
    if (employee.getId() == 0) {
      throw new RuntimeException(
          "The input JSON to update the employee is not correctly formatted");
    }
    return employeeService.save(employee);
  }
}
