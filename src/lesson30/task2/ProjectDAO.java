package lesson30.task2;

import java.util.Set;

public class ProjectDAO {

    public Set<Project> projectByEmployee(Employee employee) {
        return employee.getProjects();
    }
}
