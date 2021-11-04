package com.tb.ticketbooking.db.requestStrategies.update;

import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.models.enums.FlightFields;
import com.tb.ticketbooking.models.interfaces.Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class UpdateFlightStrategy implements DBUpdateRequest {

    // TODO LOGGER
    private static final String REQUEST = "INSERT flights (time, `from`, `to`, name) VALUES(?,?,?,?)";

    @Override
    public void update(Model model) {

        Connection connection = DBConnection.getConnection();

        try {

            HashMap<Enum<?>, String> data = model.getModelData();

            PreparedStatement statement = connection.prepareStatement(REQUEST);

            String date1 = data.get(FlightFields.TIME).replace("T"," ");

            Timestamp date = Timestamp.valueOf((data.get(FlightFields.TIME).replace("T"," ") + ":00"));


            statement.setString(2, data.get(FlightFields.FROM));
            statement.setString(3, data.get(FlightFields.TO));
            statement.setString(4, data.get(FlightFields.NAME));
            statement.setTimestamp(1,date);

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
