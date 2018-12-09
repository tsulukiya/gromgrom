package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class EmployeesDAO {
    private Set<Employee> employees;


    public EmployeesDAO(Set<Employee> employees) {
        this.employees = employees;
    }


    public Set<Employee> employeesByProject(String projectName) {

        Set<Employee> employeesSet1 = new HashSet<>();

        for (Employee employee : employees) {
            if (employee.getProjects().contains(new Project(projectName)))
                employeesSet1.add(employee);
        }
        return employeesSet1;
    }


    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        Set<Employee> employeesSet2 = new HashSet<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().getType().name().equals(departmentType.name()) && (employee.getProjects() == null))
                employeesSet2.add(employee);
        }
        return employeesSet2;
    }


    public Set<Employee> employeesWithoutProject() {
        Set<Employee> employeeSet3 = new HashSet<>();

        for (Employee employee : employees) {
            if (employee.getProjects() == null)
                employeeSet3.add(employee);
        }
        return employeeSet3;
    }


    public Set<Employee> employeesByTeamLead(Employee lead) {
        Set<Employee> employeeSet4 = new HashSet<>();

        for (Employee employee : employees) {
            if (employee.getPosition() != lead.getPosition() && employee.getDepartment().
                    getType().name().equals(lead.getDepartment().getType().name()))
                employeeSet4.add(employee);
        }
        return employeeSet4;
    }


    public Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> employeeSet5 = new HashSet<>();
        for (Employee employee1 : employees) {
            if ((employee.getPosition() != Position.TEAM_LEAD && employee.getPosition() != Position.LEAD_DESIGNER)&&
            (employee1.getDepartment().getType().name().equals(employee.getDepartment().getType().name()) &&
                    employee1.getPosition().equals(Position.TEAM_LEAD) || (employee1.getDepartment().getType().name().
                    equals(employee.getDepartment().getType().name()) && employee1.getPosition().equals(Position.LEAD_DESIGNER))))
            employeeSet5.add(employee1);
        }
        return employeeSet5;
    }

}
