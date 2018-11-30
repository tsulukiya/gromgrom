package lesson30.task2;


import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {

    List <Employee> employees = new ArrayList<>();


    public List<Employee> employeesByProject (String projectName) {

        List<Employee> employeesByProject1 = new ArrayList<>();

        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                if (project.equals(projectName))
                    employeesByProject1.add(employee);
            }
        }

        return employeesByProject1;

    }

}
