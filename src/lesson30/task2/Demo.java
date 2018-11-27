package lesson30.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        List <Employee> employees = new ArrayList<>();
        Set<Project> projectSet = new HashSet<>();
        projectSet.add(new Project("rem"));
        projectSet.add(new Project("item"));
        projectSet.add(new Project("item1"));

        Set<Project> projectSet1 = new HashSet<>();
        projectSet.add(new Project("rem1"));
        projectSet.add(new Project("item"));
        projectSet.add(new Project("item1"));

        Set<Project> projectSet2 = new HashSet<>();
        projectSet.add(new Project("rem2"));
        projectSet.add(new Project("item"));
        projectSet.add(new Project("item1"));

        employees.add(new Employee("Igor",projectSet));
        employees.add(new Employee("Andrey", projectSet));
        employees.add(new Employee("Andre", projectSet1));
        employees.add(new Employee("Ivan", projectSet2));
        employees.add(new Employee("Andrey1", projectSet2));


        Controller controller = new Controller();
        System.out.println(controller.EmployeesByProject("rem"));
    }
}
