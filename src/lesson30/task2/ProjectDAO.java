package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {

    private Set<Project> projects;


    public ProjectDAO(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Project> projectByEmployee(Employee employee) {
        return employee.getProjects();
    }

    public Set<Project> projectByCustomer(Customer customer) {
        Set<Project> projectsSet = new HashSet<>();
        if (projects != null)
            for (Project project : projects) {
                if (project.getCustomer() != null && project.getCustomer().equals(customer))
                    projectsSet.add(project);
            }
        return projectsSet;
    }
}
