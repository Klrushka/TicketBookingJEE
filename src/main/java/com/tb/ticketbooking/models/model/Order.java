package com.tb.ticketbooking.models.model;

import com.tb.ticketbooking.models.enums.OrderFields;
import com.tb.ticketbooking.models.interfaces.Model;

import java.util.HashMap;

public class Order implements Model {
    private int id;
    private int user_id;
    private String status;
    private int seat_id;
    private int flight_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    @Override
    public HashMap<Enum<?>, String> getModelData() {

        HashMap<Enum<?>, String> data = new HashMap<>();

        data.put(OrderFields.FLIGHT_ID, String.valueOf(flight_id));
        data.put(OrderFields.SEAT_ID, String.valueOf(seat_id));
        data.put(OrderFields.STATUS, "book");
        data.put(OrderFields.USER_ID, String.valueOf(user_id));

        return data;

    }

    @Override
    public void setModelData(HashMap<Enum<?>, String> data) {

        flight_id = Integer.parseInt(data.get(OrderFields.FLIGHT_ID));
        seat_id = Integer.parseInt(data.get(OrderFields.SEAT_ID));
        status = data.get(OrderFields.STATUS);
        user_id = Integer.parseInt(data.get(OrderFields.USER_ID));

    }
}
