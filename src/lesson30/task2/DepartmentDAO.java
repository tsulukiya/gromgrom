package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    private Set<Employee> employees = new HashSet<>();

    public DepartmentDAO(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> EmployeesByDepartmentWithoutProject(DepartmentType departmentType) {
        Set<Employee> employees1 = new HashSet<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().getType().name().equals(departmentType.name()) && (employee.getProjects() == null))
                employees1.add(employee);
        }
        return employees1;
    }
}
