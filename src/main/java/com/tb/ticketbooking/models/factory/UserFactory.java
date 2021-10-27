package com.tb.ticketbooking.models.factory;

import com.tb.ticketbooking.models.user.User;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;

public class UserFactory implements ModelFactory {
    @Override
    public Model getInstance() {
        return new User();
    }
}
