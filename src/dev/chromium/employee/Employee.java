package dev.chromium.employee;

import dev.chromium.enums.Action;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

public abstract class Employee implements Comparable<Employee> {

    private static final int NUMBER_OF_HOURS_WORKING = 36;
    private int id;
    private String name;
    private double hourlyWage;
    private double salary;
    private ArrayList<Action> actions;
    private ArrayList<String> skills;

    protected Employee(int id, String naam, double uurloon) {
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

    protected boolean canExecuteAction(String job, Action action) {
        boolean canExecute = false;
        if (action.getJob().equalsIgnoreCase(job)) {
            canExecute = true;
        } else System.out.println("The employee " + this.getName() + " cannot execute " + action.getFriendlyName() + ".");

        return canExecute;
    }

    public abstract void executeAction(Action action);

    protected void addAction(Action action) {
        actions.add(action);
    }

    public void calculateSalary() {
        double extra = 0.00;
        for (Action action : actions) {
            extra += action.getBonus();
        }
        salary = (hourlyWage * NUMBER_OF_HOURS_WORKING) + extra;
    }

    public abstract String getJob();

    public void print(Formatter formatter) {
        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
        formatter.format("%-3s %-25s %-20s %-15s %-15s %-15s%n", this.getId(), this.getName(), this.getJob(), usdFormat.format(this.getHourlyWage()), usdFormat.format(this.getSalary()), this.getFormattedActions());
    }

    @Override
    public int compareTo(Employee employee) {
        return (int) Math.floor(employee.getSalary() - this.getSalary());
    }
}
