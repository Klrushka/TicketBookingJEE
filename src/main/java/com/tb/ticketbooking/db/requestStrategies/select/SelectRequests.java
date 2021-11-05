package com.tb.ticketbooking.db.requestStrategies.select;

import com.tb.ticketbooking.db.requestStrategies.select.signin.SignInFields;

import java.util.HashMap;

public enum SelectRequests {
    SIGN_IN("SELECT * FROM users WHERE (mail = '?') AND (password = '?')") {
        public String returnRequest(HashMap<Enum<?>, String> data) {
            StringBuffer buffer = new StringBuffer();

            buffer
                    .append("SELECT * FROM users WHERE (mail = '")
                    .append(data.get(SignInFields.LOGIN))
                    .append("') AND (password = '")
                    .append(data.get(SignInFields.PASSWORD))
                    .append("')");

            return buffer.toString();
        }
    };

    SelectRequests(String s) {
        value = s;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public String returnRequest(HashMap<Enum<?>, String> data){
        return null;
    }
}
