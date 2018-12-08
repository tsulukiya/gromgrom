package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {

    public static Set<Project> projectByEmployee(Employee employee) {
        Set<Project> projects1 = new HashSet<>();
        if (employee!=null)
        projects1.addAll(employee.getProjects());
        return projects1;
    }
}
