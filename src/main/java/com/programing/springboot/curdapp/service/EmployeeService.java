package com.programing.springboot.curdapp.service;

import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(int theId);

  Employee save(Employee employee);

  void deleteById(int theId);

}
