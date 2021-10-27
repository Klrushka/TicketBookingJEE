package com.tb.ticketbooking.db.requests;


import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateUserStrategy;
import com.tb.ticketbooking.models.user.User;
import com.tb.ticketbooking.models.interfaces.Model;
import org.apache.log4j.Logger;


public class InsertSQLRequests implements DBUpdateRequest {

    private static final Logger LOGGER = Logger.getLogger(InsertSQLRequests.class);
    private static DBUpdateRequest request;

    public void update(Model model) {

        if (model instanceof User) {

            request = new UpdateUserStrategy();

            request.update(model);

        } else {
            LOGGER.error("Incorrect table");
            throw new RuntimeException("Incorrect table");

        }
    }
}
