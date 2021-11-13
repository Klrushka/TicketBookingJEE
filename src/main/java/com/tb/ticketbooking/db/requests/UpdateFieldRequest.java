package com.tb.ticketbooking.db.requests;

import com.tb.ticketbooking.models.enums.OrderFields;
import com.tb.ticketbooking.models.enums.SeatFields;

import java.util.HashMap;

public enum UpdateFieldRequest {

    UPDATE_SEAT_ORDER_ID{
        @Override
        public String returnRequest(HashMap<Enum<?>, String> data) {

            StringBuffer buffer = new StringBuffer();

            buffer
                    .append("UPDATE seats SET order_id = ")
                    .append(data.get(OrderFields.ID))
                    .append(" WHERE id = ")
                    .append(data.get(SeatFields.ID));

            return buffer.toString();

        }
    };

    UpdateFieldRequest() {
    }

    public String returnRequest (HashMap<Enum<?>, String> data){
        return null;
    }
}
