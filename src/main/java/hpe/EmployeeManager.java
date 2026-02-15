package hpe;

import java.util.Arrays;

public class EmployeeManager {
    public Employees initializeEmployees() {
        Employees employees = new Employees();
        
        employees.setEmployeeList(Arrays.asList(
            new Employee("1", "John", "Doe", "john.doe@company.com", "Engineering"),
            new Employee("2", "Jane", "Smith", "jane.smith@company.com", "Marketing"),
            new Employee("3", "Bob", "Johnson", "bob.johnson@company.com", "Sales"),
            new Employee("4", "Alice", "Williams", "alice.williams@company.com", "HR")
        ));
        
        return employees;
    }
}