package tech.getarrays.employeemanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repository.EmployeeServe;

@RestController
@RequestMapping("/employee")
public class EmpControl 
{
    private final EmployeeServe eServe;
    
    public EmpControl(EmployeeServe serve) { this.eServe = serve; }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employees = eServe.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") long id)
    {
        return new ResponseEntity<>(eServe.findById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmp(@RequestBody Employee emp)
    {
        return new ResponseEntity<Employee>(
            eServe.addEmployee(emp), HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp)
    {
        return new ResponseEntity<Employee>(
            eServe.updateEmployee(emp), HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmp(@PathVariable("id") long id)
    {
        eServe.deleteEmployee(id);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
}
