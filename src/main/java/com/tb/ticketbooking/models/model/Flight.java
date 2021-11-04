package com.tb.ticketbooking.models.model;

import com.tb.ticketbooking.models.enums.FlightFields;
import com.tb.ticketbooking.models.interfaces.Model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Flight implements Model {
    private int id;
    private Timestamp time;
    private String from;
    private String to;
    private String name;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public HashMap<Enum<?>, String> getModelData() {
        HashMap<Enum<?>, String> data = new HashMap<>();
        data.put(FlightFields.TIME, format.format(time));
        data.put(FlightFields.FROM, from);
        data.put(FlightFields.TO, to);
        data.put(FlightFields.NAME, name);
        return data;
    }

    @Override
    public void setModelData(HashMap<Enum<?>, String> data) {
        time = Timestamp.valueOf(data.get(FlightFields.TIME));
        from = data.get(FlightFields.FROM);
        to = data.get(FlightFields.TO);
        name = data.get(FlightFields.NAME);
    }
}
