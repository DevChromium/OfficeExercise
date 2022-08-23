package dev.chromium.employee.jobs;

import dev.chromium.employee.Employee;
import dev.chromium.enums.Action;

public class Manager extends Employee {

    private static final double HOURLY_WAGE = 20.53;
    private static final String JOB = "Manager";

    public Manager(int id, String name) {
        super(id, name, HOURLY_WAGE);
    }

    @Override
    public void executeAction(Action action) {
        try {
            if (canExecuteAction(JOB, action)) {
                System.out.println(this.getName() + " has executed the action " + action.getFriendlyName() + ".");
                addAction(action);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getJob() {
        return JOB;
    }
}
