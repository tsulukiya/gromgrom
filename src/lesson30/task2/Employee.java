package lesson30.task2;

import java.util.Date;
import java.util.Set;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private Set<Project> projects;

    public Employee(Set<Project> projects) {
        this.projects = projects;
    }

    public Employee(String firstName, Set<Project> projects) {
        this.firstName = firstName;
        this.projects = projects;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Set<Project> getProjects() {
        return projects;
    }


}
