package com.tb.ticketbooking.db.requests;


import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateCommentStrategy;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateFlightStrategy;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateUserStrategy;
import com.tb.ticketbooking.models.model.Comment;
import com.tb.ticketbooking.models.model.Flight;
import com.tb.ticketbooking.models.model.User;
import com.tb.ticketbooking.models.interfaces.Model;
import org.apache.log4j.Logger;


public class UpdateSQLRequests implements DBUpdateRequest {

    private static final Logger LOGGER = Logger.getLogger(UpdateSQLRequests.class);
    private static DBUpdateRequest request;

    public void update(Model model) {

        if (model instanceof User) {

            request = new UpdateUserStrategy();

            request.update(model);

        } else if (model instanceof Flight) {

            request = new UpdateFlightStrategy();

            request.update(model);

        } else if (model instanceof Comment) {

            request = new UpdateCommentStrategy();

            request.update(model);

        } else {
            LOGGER.error("Incorrect table");
            throw new RuntimeException("Incorrect table");
        }
    }
}
