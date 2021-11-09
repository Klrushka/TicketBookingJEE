package com.tb.ticketbooking.db.requestStrategies.select;

import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.interfaces.DBSelectRequest;
import com.tb.ticketbooking.db.requests.SelectSQLRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DBGetResult implements DBSelectRequest {


    @Override
    public ResultSet getData(SelectSQLRequests request, HashMap<Enum<?>, String> fields) {



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
