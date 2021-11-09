package com.tb.ticketbooking.db.requestStrategies.select.alldata;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.interfaces.SelectAllData;
import com.tb.ticketbooking.models.enums.FlightFields;
import com.tb.ticketbooking.models.factory.FlightFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SelectAllFlights implements SelectAllData {

    private static final String REQUEST = "SELECT * FROM bookingsystem.flights";

    @Override
    public ArrayList<Model> getFields() {

        ArrayList<Model> models = null;
        try {

            models = new ArrayList<>();

            HashMap<Enum<?>, String> data = new HashMap<>();

            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(REQUEST);


            while (resultSet.next()) {
                ModelFactory factory = new FlightFactory();

                Model model = factory.getInstance();

                data.put(FlightFields.TIME, String.valueOf(resultSet.getTimestamp("time")));
                data.put(FlightFields.FROM, resultSet.getString("from"));
                data.put(FlightFields.TO, resultSet.getString("to"));
                data.put(FlightFields.NAME, resultSet.getString("name"));

                model.setModelData(data);

                models.add(model);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return models;
    }
}
