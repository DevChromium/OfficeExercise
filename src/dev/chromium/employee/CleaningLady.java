package dev.chromium.employee;

import dev.chromium.enums.Action;
import dev.chromium.exceptions.CannotExecuteException;

public class CleaningLady extends Employee {
    private static final double HOURLY_WAGE = 11.90;
    private static final String JOB = "Cleaning Lady";

    public CleaningLady(int id, String name) {
        super(id, name, HOURLY_WAGE);
    }

    @Override
    public void executeAction(Action action) throws CannotExecuteException {
        if (canExecuteAction("cleaningLady", action)) {
            System.out.println(this.getName() + " has executed the action " + action + ".");
            addAction(action);
        }
    }

    @Override
    public String getJob() {
        return JOB;
    }
}
