package com.project.crudwithibernate.controller;

import com.project.crudwithibernate.entity.Employee;
import com.project.crudwithibernate.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/crudwithibernate/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        var emps = employeeService.findAll();
        return new ResponseEntity<>(emps, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        Employee emp = employeeService.findById(id);
        if (emp == null)
            throw new RuntimeException("Employee not found");
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public void addEmployee(@RequestBody Employee emp){
        emp.setId(null);
        employeeService.save(emp);
    }

    @PutMapping(value = "")
    public void updateEmployee(@RequestBody Employee emp){
        employeeService.save(emp);
    }

    @DeleteMapping(value = "{id}")
    public void deleteEmployee(@PathVariable Long id){
        Employee emp = employeeService.findById(id);
        if (emp == null)
            throw new RuntimeException("Employee not found");
        employeeService.delete(id);
    }
}
