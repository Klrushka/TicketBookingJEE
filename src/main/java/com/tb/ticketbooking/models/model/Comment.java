package com.tb.ticketbooking.models.model;

import com.tb.ticketbooking.models.enums.CommentsFields;
import com.tb.ticketbooking.models.interfaces.Model;

import java.util.HashMap;

public class Comment implements Model {
    private int id;
    private int flightId;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public HashMap<Enum<?>, String> getModelData() {
        HashMap<Enum<?>, String> data = new HashMap<>();

        data.put(CommentsFields.FLIGHT_ID, String.valueOf(flightId));
        data.put(CommentsFields.TEXT, text);

        return data;
    }

    @Override
    public void setModelData(HashMap<Enum<?>, String> data) {
        flightId = Integer.parseInt(data.get(CommentsFields.FLIGHT_ID));
        text = data.get(CommentsFields.TEXT);
    }
}
