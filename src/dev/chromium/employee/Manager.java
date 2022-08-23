package dev.chromium.employee;

import dev.chromium.enums.Action;
import dev.chromium.exceptions.CannotExecuteException;

public class Manager extends Employee {

    private static final double HOURLY_WAGE = 20.53;
    private static final String JOB = "Manager";

    public Manager(int id, String name) {
        super(id, name, HOURLY_WAGE);
    }

    @Override
    public void executeAction(Action action) throws CannotExecuteException {
        if (canExecuteAction(JOB, action)) {
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
        return super.toString() + "\t⌁ job: Manager \n}";
    }
}
