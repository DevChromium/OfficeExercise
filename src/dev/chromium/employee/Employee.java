package dev.chromium.employee;

import dev.chromium.enums.Action;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public abstract class Employee implements Comparable<Employee> {

    private static final int NUMBER_OF_HOURS_WORKING = 36;
    private final int id;
    private final String name;
    private final double hourlyWage;
    private double salary;
    private ArrayList<Action> actions;

    protected Employee(int id, String name, double hourlyWage) {
        this.id = id;
        this.name = name;
        this.hourlyWage = hourlyWage;
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

    public List<Action> getActions() {
        return actions;
    }

    public String getFormattedActions() {
        StringBuilder formattedActions = new StringBuilder();
        if (this.actions.isEmpty()) {
            formattedActions.append("No actions performed");
        }
        for (Action action : this.actions) {
            formattedActions.append(action.getFriendlyName()).append(", ");
        }
        return formattedActions.toString();
    }


    public void executeAction(Action action) {
        if (this.getSkills().contains(action)) {
            System.out.println(this.getName() + " has executed the action " + action.getFriendlyName());
            actions.add(action);
        } else System.out.println("The employee " + this.getName() + " cannot execute " + action.getFriendlyName());
    }
    public void calculateSalary() {
        double extra = 0.00;
        for (Action action : actions) {
            extra += action.getBonus();
        }
        salary = (hourlyWage * NUMBER_OF_HOURS_WORKING) + extra;
    }

    public abstract String getJob();

    public abstract Set<Action> getSkills();

    public void print(Formatter formatter) {
        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
        formatter.format("%-3s %-25s %-20s %-15s %-15s %-15s%n", this.getId(), this.getName(), this.getJob(), usdFormat.format(this.getHourlyWage()), usdFormat.format(this.getSalary()), this.getFormattedActions());
    }

    @Override
    public int compareTo(Employee employee) {
        if(employee.getSalary() < this.getSalary()) return -1;
        if(employee.getSalary() > this.getSalary()) return 1;
        return 0;
    }
}
