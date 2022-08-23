package dev.chromium.employee.jobs;

import dev.chromium.employee.Employee;
import dev.chromium.enums.Action;
public class Janitor extends Employee {
    private static final double HOURLY_WAGE = 11.90;
    private static final String JOB = "Janitor";

    public Janitor(int id, String name) {
        super(id, name, HOURLY_WAGE);
    }

    @Override
    public void executeAction(Action action) {
        if (canExecuteAction(JOB, action)) {
            System.out.println(this.getName() + " has executed the action " + action.getFriendlyName() + ".");
            addAction(action);
        }
    }

    @Override
    public String getJob() {
        return JOB;
    }
}
