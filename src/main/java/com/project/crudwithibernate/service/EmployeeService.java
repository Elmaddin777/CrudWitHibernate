package com.project.crudwithibernate.service;

import com.project.crudwithibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(long id);

    void save(Employee employee);

    void delete(Long id);
}
