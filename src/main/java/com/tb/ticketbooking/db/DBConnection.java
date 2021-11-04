package com.tb.ticketbooking.db;

import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {

    private static Connection connection;
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class);
    private static final Properties dbProperties = new Properties();

    /**
     * Returns dbConnection to change db? edit property file DbConnectionConfigs.properties
     * @return Connection
     */
    public static Connection getConnection(){

        try {
            dbProperties.load(new FileReader("E:\\University\\Programming\\JavaDirectory\\TicketBookingJEE\\src\\main\\resources\\DbConnectionConfigs.properties"));
            LOGGER.info("Property file was loaded");

        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Can not load property file");
        }


        String connectionConfig = "jdbc:mysql://" + dbProperties.getProperty("dbHost") + ":" +
                dbProperties.getProperty("dbPort") + "/" + dbProperties.getProperty("dbName");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            connection = DriverManager.getConnection(connectionConfig, dbProperties.getProperty("dbUser"), dbProperties.getProperty("dbPass"));
            LOGGER.info("Successful connection");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("Connection to DB was failed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LOGGER.error(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            LOGGER.error(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            LOGGER.error(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            LOGGER.error(e);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            LOGGER.error(e);
        }


        return connection;

    }
}
