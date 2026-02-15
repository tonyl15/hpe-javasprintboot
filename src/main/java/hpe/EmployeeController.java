package hpe;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    private EmployeeManager employeeManager = new EmployeeManager();
    private Employees employees = employeeManager.initializeEmployees();
    
    @GetMapping("/")
    public List<Employee> getEmployees() {
        return employees.getEmployeeList();
    }
}
