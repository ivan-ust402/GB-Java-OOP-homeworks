package homework7;

import java.util.Objects;

public class Employee {
    private final String fullName;
    private final String department;
    private final double salary;

    public Employee (String fullName, String department, double salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public String fullName() {
        return fullName;
    }
    public String department() {
        return department;
    }
    public double salary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        Employee employee = (Employee) obj;
        return fullName == employee.fullName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
