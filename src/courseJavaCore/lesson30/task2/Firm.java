package courseJavaCore.lesson30.task2;

import java.util.Date;
import java.util.Set;

public class Firm {
    private Date dateFounded;
    private Set<Department> departments;
    private Set<Customer> customers;

    public Firm(Date dateFounded, Set<Department> departments, Set<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }
}
