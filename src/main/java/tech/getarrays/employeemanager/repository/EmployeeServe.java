package tech.getarrays.employeemanager.repository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.employeemanager.exceptions.UserNotFound;
import tech.getarrays.employeemanager.model.Employee;

@Service
public class EmployeeServe 
{
    private final EmployeeRepo rep;

    @Autowired
    public EmployeeServe(EmployeeRepo repo)
    {
        this.rep = repo;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setCodeName(UUID.randomUUID().toString());
        return rep.save(employee);
    }

    public List<Employee> findAllEmployees() { return rep.findAll(); }
    public Employee findById(long id) 
    { 
        return rep
                .findById(id)
                .orElseThrow(
                    () -> new UserNotFound("Employee " + id + " not found")
                ); 
    }

    public Employee updateEmployee(Employee emp) { return rep.save(emp); }

    public void deleteEmployee(long id) { rep.deleteById(id); }
}
