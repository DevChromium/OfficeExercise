package dev.chromium.employee;

import dev.chromium.enums.Action;
import dev.chromium.exceptions.CannotExecuteException;

import java.util.ArrayList;

public abstract class Employee implements Comparable<Employee> {

    private static final int NUMBER_OF_HOURS_WORKING = 36;
    private int id;
    private String name;
    private double hourlyWage;
    private double salary;
    private ArrayList<Action> actions;

    public Employee(int id, String naam, double uurloon) {
        this.id = id;
        this.name = naam;
        this.hourlyWage = uurloon;
        this.salary = 0;
        this.actions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getSalary() {
        return salary;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public String getFormattedActions() {
        String actions = "";
        if (this.actions.isEmpty()) {
            actions += "No actions performed";
        }
        for (Action action : this.actions) {
            actions += action.getFriendlyName() + ", ";
        }
        return actions;
    }

    protected boolean canExecuteAction(String job, Action action) throws CannotExecuteException {
        boolean canExecute = false;
        if (action.getJob().equalsIgnoreCase(job)) {
            canExecute = true;
        } else throw new CannotExecuteException(this, action);

        return canExecute;
    }

    public abstract void executeAction(Action action) throws CannotExecuteException;

    protected void addAction(Action action) {
        actions.add(action);
    }

    public double calculateSalary() {
        double bonus = 0.00;
        for (Action action : actions) {
            bonus += action.getBonus();
        }
        salary = (hourlyWage * NUMBER_OF_HOURS_WORKING) + bonus;
        return salary;
    }

    public abstract String getJob();

    @Override
    public int compareTo(Employee employee) {
        int comparable = 0;
        if (this.getSalary() > employee.getSalary()) {
            comparable = -1;
        } else if (this.getSalary() < employee.getSalary()) {
            comparable = 1;
        } else if (this.getSalary() == employee.getSalary()) {
            comparable = 0;
        }
        return comparable;
    }
}
