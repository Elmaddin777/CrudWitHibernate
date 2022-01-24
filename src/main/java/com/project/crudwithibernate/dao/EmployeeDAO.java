package com.project.crudwithibernate.dao;

import com.project.crudwithibernate.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(long id);

    void save(Employee employee);

    void deleteById(long id);
}
