package com.tb.ticketbooking.db.requestStrategies.select;

public enum SelectRequests {
    SIGN_IN("SELECT * FROM users WHERE (mail = ?) AND (mail = ?)");

    SelectRequests(String s) {
        value = s;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
