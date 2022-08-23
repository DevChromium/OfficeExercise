package dev.chromium.employee;

import dev.chromium.enums.Action;
import dev.chromium.exceptions.CannotExecuteException;

public class OfficeWorker extends Employee {

    private static final double HOURLY_WAGE = 15.13;
    private static final String JOB = "Office Worker";

    public OfficeWorker(int id, String name) {
        super(id, name, HOURLY_WAGE);
    }

    @Override
    public void executeAction(Action action) throws CannotExecuteException {
        if (canExecuteAction("officeWorker", action)) {
            System.out.println(this.getName() + " has executed the action " + action + ".");
            addAction(action);
        }
    }

    @Override
    public String getJob() {
        return JOB;
    }

    @Override
    public String toString() {
        return super.toString() + "\t⌁ job: Office Worker \n}";
    }
}
