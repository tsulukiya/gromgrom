package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class Controller {
    private  EmployeesDAO employeesDAO;

    public Controller(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
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
