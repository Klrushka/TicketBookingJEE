package com.tb.ticketbooking.db.requestStrategies.update;

import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.models.enums.OrderFields;
import com.tb.ticketbooking.models.interfaces.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateOrderStrategy implements DBUpdateRequest {

    public static final String REQUEST = "INSERT orders (user_id, status, seat_id, flight_id) VALUES (?,?,?,?)";

    @Override
    public void update(Model model) {

        Connection connection = DBConnection.getConnection();

        try {

            HashMap<Enum<?>, String> data = model.getModelData();

            PreparedStatement statement = connection.prepareStatement(REQUEST);

            statement.setInt(1,Integer.parseInt(data.get(OrderFields.USER_ID)));
            statement.setString(2,data.get(OrderFields.STATUS));
            statement.setInt(3, Integer.parseInt(data.get(OrderFields.SEAT_ID)));
            statement.setInt(4, Integer.parseInt(data.get(OrderFields.FLIGHT_ID)));

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
