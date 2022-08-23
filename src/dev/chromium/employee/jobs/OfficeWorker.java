package dev.chromium.employee.jobs;

import dev.chromium.employee.Employee;
import dev.chromium.enums.Action;

import java.util.EnumSet;
import java.util.Set;

public class OfficeWorker extends Employee {

    private static final double HOURLY_WAGE = 15.13;
    private static final String JOB = "Office Worker";
    private static final Set<Action> skills = EnumSet.of(Action.SUPPORT_CLIENTS, Action.SORT_DOCUMENTS);

    public OfficeWorker(int id, String name) {
        super(id, name, HOURLY_WAGE, skills);
    }

    @Override
    public String getJob() {
        return JOB;
    }
}
