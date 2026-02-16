package hpe;

import java.util.ArrayList;
import java.util.List;

/**
 * Employees class represents a collection of Employee objects. It provides
 * methods to get and set the list of employees.
 */
public class Employees {
    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
