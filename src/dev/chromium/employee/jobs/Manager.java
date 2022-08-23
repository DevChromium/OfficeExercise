package dev.chromium.employee.jobs;

import dev.chromium.employee.Employee;
import dev.chromium.enums.Action;

import java.util.EnumSet;
import java.util.Set;

public class Manager extends Employee {

    private static final double HOURLY_WAGE = 20.53;
    private static final String JOB = "Manager";
    private static final Set<Action> skills = EnumSet.of(Action.BUY_EQUIPMENT, Action.PLAN_MEETING);

    public Manager(int id, String name) {
        super(id, name, HOURLY_WAGE, skills);
    }

    @Override
    public String getJob() {
        return JOB;
    }
}
