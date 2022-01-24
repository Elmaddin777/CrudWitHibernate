package com.project.crudwithibernate.dao.impl;

import com.project.crudwithibernate.dao.EmployeeDAO;
import com.project.crudwithibernate.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        // Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // Create a query
        Query<Employee> theQuery = currentSession.createQuery("FROM Employee", Employee.class);
        // Execute query
        List<Employee> employees = theQuery.getResultList();
        // Return result
        return employees;
    }

    @Override
    public Employee findById(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        Employee emp = currSession.find(Employee.class, id);
        return emp;
    }

    @Override
    public void save(Employee employee) {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(long id) {
        Session currSession = entityManager.unwrap(Session.class);
        Query deleteQuery = currSession.createQuery("delete from Employee where id = :id");
        deleteQuery.setParameter("id", id);
        deleteQuery.executeUpdate();
    }
}
