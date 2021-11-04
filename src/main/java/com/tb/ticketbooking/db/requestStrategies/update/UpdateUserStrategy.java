package com.tb.ticketbooking.db.requestStrategies.update;


import com.tb.ticketbooking.db.DBConnection;
import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.enums.UserFields;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class UpdateUserStrategy implements DBUpdateRequest {

    private static final Logger LOGGER = Logger.getLogger(UpdateUserStrategy.class);
    private static final String REQUEST = "INSERT USERS (name, mail, password, birthday, phonenumber) VALUES (?,?,?,?,?)";

    @Override
    public void update(Model model) {


        HashMap<Enum<?>, String> data = model.getModelData();

        Connection connection = DBConnection.getConnection();


        String name = data.get(UserFields.NAME);
        LOGGER.info("Name is correct");

        String mail = data.get(UserFields.MAIL);
        LOGGER.info("Mail is correct");

        String password = data.get(UserFields.PASSWORD);
        LOGGER.info("Password is correct");

        Date birthday = Date.valueOf(data.get(UserFields.BIRTHDAY));
        LOGGER.info("Birthday is correct");

        String phoneNumber = data.get(UserFields.PHONENUMBER);
        LOGGER.info("PhoneNumber is correct");


        try {
            PreparedStatement statement = connection.prepareStatement(REQUEST);


            statement.setString(1, name);
            statement.setString(2, mail);
            statement.setString(3, password);
            statement.setDate(4, birthday);
            statement.setString(5, phoneNumber);

            statement.execute();

            statement.close();


        } catch (SQLException e) {
            LOGGER.error("Incorrect \"update\" SQL request");
            e.printStackTrace();
        }

    }
}
