package dev.chromium.enums;

public enum Action {

    CLEAN_FLOOR("janitor", 1.30, "Clean Floor"),
    CHANGE_TOILET_PAPER("janitor", 1.32, "Change Toilet Paper"),
    SUPPORT_CLIENTS("office worker", 3.09, "Support Client"),
    SORT_DOCUMENTS("office worker", 3.00, "Sort Documents"),
    BUY_EQUIPMENT("manager", 6.90, "Buy Equipment"),
    PLAN_MEETING("manager", 4.20, "Plan Meeting");

    private String job;
    private double bonus;
    private String friendlyName;

    Action(String job, double bonus, String friendlyName) {
        this.job = job;
        this.bonus = bonus;
        this.friendlyName = friendlyName;
    }

    public String getJob() {
        return job;
    }

    public double getBonus() {
        return bonus;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}

