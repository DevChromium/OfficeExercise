package dev.chromium.enums;

public enum Action {

    CLEAN_FLOOR( 1.30, "Clean Floor"),
    CHANGE_TOILET_PAPER(1.32, "Change Toilet Paper"),
    SUPPORT_CLIENTS(3.09, "Support Client"),
    SORT_DOCUMENTS(3.00, "Sort Documents"),
    BUY_EQUIPMENT(6.90, "Buy Equipment"),
    PLAN_MEETING( 4.20, "Plan Meeting");

    private final double extra;
    private final String friendlyName;

    Action(double extra, String friendlyName) {
        this.extra = extra;
        this.friendlyName = friendlyName;
    }

    public double getBonus() {
        return extra;
    }

    public String getFriendlyName() {
        return friendlyName;
    }
}

