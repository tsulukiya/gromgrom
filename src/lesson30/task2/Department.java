package lesson30.task2;

import java.util.Set;

public class Department {
    private DepartmentType type;
    private Set<Employee> employees;

    public Department(DepartmentType type) {
        this.type = type;
    }

    public Department(DepartmentType type, Set<Employee> employees) {
        this.type = type;
        this.employees = employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                '}';
    }
}
