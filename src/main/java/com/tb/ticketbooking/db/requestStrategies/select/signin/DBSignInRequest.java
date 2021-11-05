package com.tb.ticketbooking.db.requestStrategies.select.signin;

import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.interfaces.DBSelectRequest;
import com.tb.ticketbooking.db.requestStrategies.select.SelectRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DBSignInRequest implements DBSelectRequest {


    @Override
    public ResultSet getData(SelectRequests request, HashMap<Enum<?>, String> fields) {



        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(request.returnRequest(fields));

            return statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }


       return null;
    }
}
