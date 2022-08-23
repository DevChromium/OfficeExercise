package dev.chromium.enums;

public enum Action {

    CLEAN_FLOOR( 1.30, "Clean Floor"),
    CHANGE_TOILET_PAPER(1.32, "Change Toilet Paper"),
    SUPPORT_CLIENTS(3.09, "Support Client"),
    SORT_DOCUMENTS(3.00, "Sort Documents"),
    BUY_EQUIPMENT(6.90, "Buy Equipment"),
    PLAN_MEETING( 4.20, "Plan Meeting");

    private double bonus;
    private String friendlyName;

    Action(double bonus, String friendlyName) {
        this.bonus = bonus;
        this.friendlyName = friendlyName;
    }

    public double getBonus() {
        return bonus;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}

