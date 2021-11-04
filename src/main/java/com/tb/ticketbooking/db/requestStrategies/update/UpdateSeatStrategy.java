package com.tb.ticketbooking.db.requestStrategies.update;

import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.models.enums.SeatFields;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.model.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateSeatStrategy implements DBUpdateRequest {

    private static final String REQUEST = "INSERT seats (flight_id, price, class, order_id, seat_number) VALUES (?,?,?,?,?)";

    @Override
    public void update(Model model) {

        Connection connection = DBConnection.getConnection();

        HashMap<Enum<?>, String> data = model.getModelData();

        try {
            PreparedStatement statement = connection.prepareStatement(REQUEST);

            statement.setInt(1,Integer.parseInt(data.get(SeatFields.FLIGHT_ID)));
            statement.setFloat(2, Float.parseFloat(data.get(SeatFields.PRICE)));
            statement.setString(3,data.get(SeatFields.CLASS));
            statement.setInt(4,Integer.parseInt(data.get(SeatFields.ORDER_ID)));
            statement.setInt(5,Integer.parseInt(data.get(SeatFields.SEAT_NUMBER)));

            statement.execute();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
