package lesson30.task2;

import java.util.List;

public class Controller {

    public List<Employee> employeesByProject(String projectName) {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        return employeesDAO.employeesByProject(projectName);
    }
}
