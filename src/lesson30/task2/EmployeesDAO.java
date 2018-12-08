package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class EmployeesDAO {

    private Set<Employee> employees;

    public EmployeesDAO(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> employeesByProject(String projectName) {

        Set<Employee> employeesByProject1 = new HashSet<>();

        for (Employee employee : employees) {
           if (employee.getProjects().contains(new Project(projectName)))
               employeesByProject1.add(employee);

        }
        return employeesByProject1;
    }
}
