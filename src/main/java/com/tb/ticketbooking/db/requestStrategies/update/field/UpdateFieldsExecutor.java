package com.tb.ticketbooking.db.requestStrategies.update.field;

import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.requests.UpdateFieldRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateFieldsExecutor {
    public static void execute(String request) {

        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(request);

            statement.execute();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
