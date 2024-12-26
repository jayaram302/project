import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int id;
    private String department;
    private boolean attendance;
    private int performanceRating;
    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.attendance = false;
        this.performanceRating = 0;
    }
    public void markAttendance() {
        this.attendance = true;
    }
    public void evaluatePerformance(int rating) {
        this.performanceRating = rating;
    }
    public String getDetails() {
        return "Name: " + name + ", ID: " + id + ", Department: " + department + 
               ", Attendance: " + attendance + ", Performance Rating: " + performanceRating;
    }
}
class EmployeeManagementSystem {
    private List<Employee> employees;
    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }
    public void addEmployee(String name, int id, String department) {
        Employee employee = new Employee(name, id, department);
        employees.add(employee);
    }
    public void markEmployeeAttendance(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.markAttendance();
                break;
            }
        }
    }
    public void evaluateEmployeePerformance(int id, int rating) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.evaluatePerformance(rating);
                break;
            }
        }
    }
    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.getDetails());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.addEmployee("John Doe", 1, "HR");
        ems.addEmployee("Jane Smith", 2, "IT");
        ems.markEmployeeAttendance(1);
        ems.evaluateEmployeePerformance(1, 5);
        ems.displayEmployees();
    }
}