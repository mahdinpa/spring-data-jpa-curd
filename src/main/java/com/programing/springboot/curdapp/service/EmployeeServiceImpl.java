package com.programing.springboot.curdapp.service;

import com.programing.springboot.curdapp.dao.EmployeeDAO;
import com.programing.springboot.curdapp.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements
    EmployeeService {

  EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImpl(
      EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  public Employee findById(int theId) {

    Employee theEmployee = null;
    Optional<Employee> employee = employeeDAO.findById(theId);
    if (employee.isPresent()) {
      theEmployee = employee.get();
    }
    return theEmployee;
  }

  @Override
  public Employee save(Employee employee) {
    return employeeDAO.save(employee);
  }

  @Override
  public void deleteById(int theId) {
    employeeDAO.deleteById(theId);
  }
}
