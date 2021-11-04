package com.tb.ticketbooking.models.factory;

import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;
import com.tb.ticketbooking.models.model.Flight;

public class FlightFactory implements ModelFactory {
    @Override
    public Model getInstance() {
        return new Flight();
    }
}
