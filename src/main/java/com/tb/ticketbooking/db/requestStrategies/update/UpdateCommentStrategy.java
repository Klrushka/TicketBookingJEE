package com.tb.ticketbooking.db.requestStrategies.update;

import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.models.enums.CommentsFields;
import com.tb.ticketbooking.models.enums.FlightFields;
import com.tb.ticketbooking.models.interfaces.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateCommentStrategy implements DBUpdateRequest {


    private static final String REQUEST = "INSERT comments (flight_id, text) VALUES(?,?)";

    @Override
    public void update(Model model) {
        Connection connection = DBConnection.getConnection();

        try {
            HashMap<Enum<?>, String> data = model.getModelData();

            PreparedStatement statement = connection.prepareStatement(REQUEST);

            statement.setString(2, data.get(CommentsFields.TEXT));
            statement.setString(1, data.get(CommentsFields.FLIGHT_ID));


            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
