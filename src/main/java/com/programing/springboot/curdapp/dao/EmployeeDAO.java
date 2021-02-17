package com.programing.springboot.curdapp.dao;

import com.programing.springboot.curdapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
