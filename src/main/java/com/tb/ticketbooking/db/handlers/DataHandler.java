package com.tb.ticketbooking.db.handlers;

import java.util.ArrayList;
import java.util.Arrays;

public class DataHandler {


    private static ArrayList<String> insertData;
    /**
     * Returns ArrayList of info to add;
     * Every model have unique order to add data
     * User:
     *      0 - name
     *      1 - mail
     *      2 - password
     *      3 - birthday
     *
     * Flight:
     *      0 - time
     *      1 - from
     *      2 - to
     *      3 - name
     *
     * Seat:
     *      0 - flight_id
     *      1 - price
     *      2 - class
     *
     * Orders:
     *      0 - user_id
     *      1 - status
     *      2 - seat_id
     *      3 - flight_id
     *
     * Comments:
     *      0 - flight_id
     *      1 - text
     *
     *
     *
     * @param data String...
     * @return ArrayList<String>
     */

    public static ArrayList<String> loadInsertData(String... data){

        insertData.addAll(Arrays.asList(data));

        return insertData;
    }
}
