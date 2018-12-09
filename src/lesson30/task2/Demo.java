package lesson30.task2;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {

        Customer customer1 = new Customer("First1", "Ukraine", 1000);
        Customer customer2 = new Customer("First2", "Ukraine", 1100);
        Customer customer3 = new Customer("First3", "Ukraine", 1200);
        Customer customer4 = new Customer("First4", "Ukraine", 1300);
        Customer customer5 = new Customer("First5", "Ukraine", 1400);
        Customer customer6 = new Customer("First6", "Ukraine", 1500);
        Customer customer7 = new Customer("First7", "Ukraine", 1600);
        Customer customer8 = new Customer("First8", "Ukraine", 1700);
        Customer customer9 = new Customer("First9", "Ukraine", 1800);

        Project project1 = new Project("Found1", customer1);
        Project project2 = new Project("Found2", customer2);
        Project project3 = new Project("Found3", customer3);
        Project project4 = new Project("Found4", customer4);
        Project project5 = new Project("Found5", customer5);
        Project project6 = new Project("Found6", customer6);
        Project project7 = new Project("Found7", customer7);
        Project project8 = new Project("Found8", customer8);
        Project project9 = new Project("Found9", customer9);

        Set<Project> projectSet1 = new HashSet<>();
        projectSet1.add(project1);
        projectSet1.add(project2);
        projectSet1.add(project3);

        Set<Project> projectSet2 = new HashSet<>();
        projectSet2.add(project4);
        projectSet2.add(project5);
        projectSet2.add(project6);

        Set<Project> projectSet3 = new HashSet<>();
        projectSet3.add(project7);
        projectSet3.add(project8);
        projectSet3.add(project9);

        Department departmentAnalytics = new Department(DepartmentType.ANALYTICS);
        Department departmentDevelopment = new Department(DepartmentType.DEVELOPMENT);
        Department departmentDesign = new Department(DepartmentType.DESIGN);


        Employee employeeAnalyst1 = new Employee("Alex1", "Gordon1", new Date(), Position.TEAM_LEAD, departmentAnalytics, projectSet1);
        Employee employeeAnalyst2 = new Employee("Alex2", "Gordon2", new Date(), Position.ANALYST, departmentAnalytics, projectSet1);
        Employee employeeAnalyst3 = new Employee("Alex3", "Gordon3", new Date(), Position.ANALYST, departmentAnalytics, projectSet1);
        Employee employeeDev1 = new Employee("Alex4", "Gordon4", new Date(), Position.DEVELOPER, departmentDevelopment, projectSet2);
        Employee employeeDev2 = new Employee("Alex5", "Gordon5", new Date(), Position.DEVELOPER, departmentDevelopment, projectSet2);
        Employee employeeDev3 = new Employee("Alex6", "Gordon6", new Date(), Position.DEVELOPER, departmentDevelopment, projectSet2);
        Employee employeeDesigner1 = new Employee("Alex7", "Gordon7", new Date(), Position.DESIGNER, departmentDesign, projectSet3);
        Employee employeeDesigner2 = new Employee("Alex8", "Gordon8", new Date(), Position.DESIGNER, departmentDesign, projectSet3);
        Employee employeeDesigner3 = new Employee("Alex9", "Gordon9", new Date(), Position.DESIGNER, departmentDesign, null);

        Set<Employee>employeeSetAnalystDepartment = new HashSet<>();
        Set<Employee>employeeSetDeveloperDepartment = new HashSet<>();
        Set<Employee>employeeSetDesignerDepartment = new HashSet<>();

        employeeSetAnalystDepartment.add(employeeAnalyst1);
        employeeSetAnalystDepartment.add(employeeAnalyst2);
        employeeSetAnalystDepartment.add(employeeAnalyst3);

        employeeSetDeveloperDepartment.add(employeeDev1);
        employeeSetDeveloperDepartment.add(employeeDev2);
        employeeSetDeveloperDepartment.add(employeeDev3);

        employeeSetDesignerDepartment.add(employeeDesigner1);
        employeeSetDesignerDepartment.add(employeeDesigner2);
        employeeSetDesignerDepartment.add(employeeDesigner3);

        departmentAnalytics.setEmployees(employeeSetAnalystDepartment);
        departmentDevelopment.setEmployees(employeeSetDeveloperDepartment);
        departmentDesign.setEmployees(employeeSetDesignerDepartment);

        Set<Employee>employeeSet = new HashSet<>();
        employeeSet.addAll(employeeSetAnalystDepartment);
        employeeSet.addAll(employeeSetDeveloperDepartment);
        employeeSet.addAll(employeeSetDesignerDepartment);

        System.out.println(employeeSet);

        System.out.println("+++++++++++++++++++++++++++++++++++++");

        EmployeesDAO employeesDAO = new EmployeesDAO(employeeSet);
        Controller controller = new Controller(employeesDAO);
//        System.out.println(controller.employeesByProject("Found1"));
//        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.DESIGN));
//        System.out.println(controller.employeesWithoutProject());
        System.out.println(controller.employeesByTeamLead(employeeAnalyst1));
//
//
//        ProjectDAO projectDAO = new ProjectDAO();
//        Controller controller1 = new Controller(projectDAO);
//        System.out.println(controller1.projectsByEmployee(employeeAnalyst1));


//









    }
}
