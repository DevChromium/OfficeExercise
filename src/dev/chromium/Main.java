package dev.chromium;

import dev.chromium.employee.CleaningLady;
import dev.chromium.employee.Employee;
import dev.chromium.employee.Manager;
import dev.chromium.employee.OfficeWorker;
import dev.chromium.enums.Action;

import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>() {
            {
                add(new Manager(1, "James Greene"));
                add(new CleaningLady(2, "Gail Mckay"));
                add(new OfficeWorker(3, "Garfield Francis"));
                add(new OfficeWorker(4, "Ben Hayes"));
            }
        };

        try {
            employees.get(0).executeAction(Action.PLAN_MEETING);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            employees.get(1).executeAction(Action.CLEAN_FLOOR);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            employees.get(2).executeAction(Action.SUPPORT_CLIENTS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            employees.get(2).executeAction(Action.CLEAN_FLOOR);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            employees.get(3).executeAction(Action.SUPPORT_CLIENTS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            employees.get(3).executeAction(Action.SORT_DOCUMENTS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Employee employee : employees) {
            employee.calculateSalary();
        }

        Collections.sort(employees);
        Formatter fmt = new Formatter();
        Locale america = new Locale("en", "US");
        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(america);
        fmt.format("%-3s %-25s %-20s %-15s %-15s %-15s\n", "ID", "Name", "Job", "Hourly Wage", "Salary", "Actions");
        for (Employee employee : employees) {
            fmt.format("%-3s %-25s %-20s %-15s %-15s %-15s\n",employee.getId(), employee.getName(), employee.getJob(), usdFormat.format(employee.getHourlyWage()),usdFormat.format(employee.getSalary()), employee.getFormattedActions());
        }
        System.out.println("\n");
        System.out.println(fmt);
    }

}
