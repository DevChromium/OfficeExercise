package dev.chromium.employee.jobs;

import dev.chromium.employee.Employee;
import dev.chromium.enums.Action;

import java.util.EnumSet;
import java.util.Set;

public class Janitor extends Employee {
    private static final double HOURLY_WAGE = 11.90;
    private static final String JOB = "Janitor";
    private static final Set<Action> skills = EnumSet.of(Action.CLEAN_FLOOR, Action.CHANGE_TOILET_PAPER);

    public Janitor(int id, String name) {
        super(id, name, HOURLY_WAGE);
    }

    @Override
    public String getJob() {
        return JOB;
    }

    @Override
    public Set<Action> getSKills() {
        return skills;
    }
}
