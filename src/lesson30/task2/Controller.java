package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class Controller {
    private  EmployeesDAO employeesDAO;
    private ProjectDAO projectDAO;

    public Controller(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public Controller(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }

    public Set<Project>projectsByEmployee(Employee employee) {
        return projectDAO.projectByEmployee(employee);
    }

    public Set<Employee> employeesByProject(String projectName) {
        return employeesDAO.employeesByProject(projectName);
    }

    @Override
    public String toString() {
        return "Controller{" +
                "employeesDAO=" + employeesDAO +
                '}';
    }
}
