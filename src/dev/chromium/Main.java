package dev.chromium;

import dev.chromium.employee.EmployeeHolder;
import dev.chromium.employee.jobs.Janitor;
import dev.chromium.employee.Employee;
import dev.chromium.employee.jobs.Manager;
import dev.chromium.employee.jobs.OfficeWorker;
import dev.chromium.enums.Action;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        EmployeeHolder employees = new EmployeeHolder();

        employees.add(new Manager(1, "James Greene"));
        employees.add(new Janitor(2, "Gail Mckay"));
        employees.add(new OfficeWorker(3, "Garfield Francis"));
        employees.add(new OfficeWorker(4, "Ben Hayes"));


        employees.get(1).executeAction(Action.PLAN_MEETING);
        employees.get(2).executeAction(Action.CLEAN_FLOOR);
        employees.get(2).executeAction(Action.SUPPORT_CLIENTS);
        employees.get(2).executeAction(Action.CLEAN_FLOOR);
        employees.get(3).executeAction(Action.SUPPORT_CLIENTS);
        employees.get(3).executeAction(Action.SORT_DOCUMENTS);

        for (Employee employee : employees.get()) {
            employee.calculateSalary();
        }

        Collections.sort(employees.get());
        employees.print();

    }

}
