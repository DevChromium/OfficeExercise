package dev.chromium.employee;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class EmployeeHolder {

    private List<Employee> employees;

    public EmployeeHolder() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> get() {
        return this.employees;
    }

    public Employee get(int id) {
        return employees.stream()
                .filter(employee -> id == employee.getId())
                .findFirst()
                .orElse(null);
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    public void print() {
        Formatter fmt = new Formatter();
        fmt.format("%-3s %-25s %-20s %-15s %-15s %-15s%n", "ID", "Name", "Job", "Hourly Wage", "Salary", "Actions");
        for (Employee employee : employees) {
            employee.print(fmt);
        }
        System.out.println(fmt);
    }
}
