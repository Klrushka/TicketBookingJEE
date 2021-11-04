package com.tb.ticketbooking.models.model;

import com.tb.ticketbooking.models.enums.SeatFields;
import com.tb.ticketbooking.models.interfaces.Model;

import java.util.HashMap;

public class Seat implements Model {

    private int id;
    private String flightId;
    private String price;
    private String sClass;
    private String orderId;
    private String seat_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public HashMap<Enum<?>, String> getModelData() {

        HashMap<Enum<?>, String> data = new HashMap<>();

        data.put(SeatFields.CLASS, sClass);
        data.put(SeatFields.PRICE, price);
        data.put(SeatFields.FLIGHT_ID, flightId);
        data.put(SeatFields.ORDER_ID, orderId);
        data.put(SeatFields.SEAT_NUMBER,seat_number);

        return data;
    }

    @Override
    public void setModelData(HashMap<Enum<?>, String> data) {
        flightId = data.get(SeatFields.FLIGHT_ID);
        price = data.get(SeatFields.PRICE);
        sClass = data.get(SeatFields.CLASS);
        orderId = data.get(SeatFields.ORDER_ID);
        seat_number = data.get(SeatFields.SEAT_NUMBER);
    }
}
