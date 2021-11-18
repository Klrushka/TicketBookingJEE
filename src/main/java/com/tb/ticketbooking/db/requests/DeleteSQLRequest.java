package com.tb.ticketbooking.db.requests;

import com.tb.ticketbooking.models.enums.SeatFields;

import java.util.HashMap;

public enum DeleteSQLRequest {


    DELETE_ORDER_BY_ID{
        @Override
        public String returnRequest(HashMap<Enum<?>, String> data) {
            StringBuffer buffer = new StringBuffer();

            buffer
                    .append("DELETE FROM orders WHERE seat_id = ")
                    .append(data.get(SeatFields.ID));

            return buffer.toString();
        }
    };



    public String returnRequest(HashMap<Enum<?>, String> data){
        return null;
    }
}
