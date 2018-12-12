package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class Controller {
    private EmployeesDAO employeesDAO;
    private ProjectDAO projectDAO;
    private DepartmentDAO departmentDAO;

    public Controller(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public Controller(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public Controller(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }


    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        return employeesDAO.employeesByDepartmentWithoutProject(departmentType);
    }


    public Set<Project> projectsByEmployee(Employee employee) {
        return projectDAO.projectByEmployee(employee);
    }

    public Set<Project> projectByCustomer(Customer customer) {
        return projectDAO.projectByCustomer(customer);
    }

    public Set<Employee> employeesByProject(String projectName) {
        return employeesDAO.employeesByProject(projectName);
    }

    public Set<Employee> employeesWithoutProject() {
        return employeesDAO.employeesWithoutProject();
    }

    public Set<Employee> employeesByTeamLead(Employee lead) {
        return employeesDAO.employeesByTeamLead(lead);
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee) {
        return employeesDAO.teamLeadsByEmployee(employee);
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee) {
        return employeesDAO.employeesByProjectEmployee(employee);
    }

    public Set<Employee> employeesByCustomerProjects(Customer customer) {
        return employeesDAO.employeesByCustomerProjects(customer);
    }


    @Override
    public String toString() {
        return "Controller{" +
                "employeesDAO=" + employeesDAO +
                '}';
    }
}
