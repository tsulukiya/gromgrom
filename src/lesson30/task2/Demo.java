package lesson30.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(new Project("rem"));
        projectSet.add(new Project("item"));
        projectSet.add(new Project("item1"));

        Set<Project> projectSet1 = new HashSet<>();
        projectSet1.add(new Project("rem1"));
        projectSet1.add(new Project("item"));
        projectSet1.add(new Project("item1"));

        Set<Project> projectSet2 = new HashSet<>();
        projectSet2.add(new Project("rem2"));
        projectSet2.add(new Project("item"));
        projectSet2.add(new Project("item1"));


        Controller controller = new Controller();

        System.out.println(controller.employeesByProject("rem"));
    }
}
