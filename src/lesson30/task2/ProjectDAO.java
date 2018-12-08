package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {
    private Set <Project>projects = new HashSet<>();

    public ProjectDAO(Set<Project> projects) {
        this.projects = projects;
    }

    public Set <Project> projectByEmployee (Employee employee) {

        Set <Project> projects1 = new HashSet<>();

        projects1.addAll(employee.getProjects());

        return projects1;
    }
}
