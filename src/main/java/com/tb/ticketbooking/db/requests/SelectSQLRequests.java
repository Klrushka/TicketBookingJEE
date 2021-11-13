package com.tb.ticketbooking.db.requests;

import com.tb.ticketbooking.db.requestStrategies.Fields;
import com.tb.ticketbooking.models.enums.SeatFields;
import com.tb.ticketbooking.models.enums.UserFields;

import java.util.HashMap;

public enum SelectSQLRequests {
    SIGN_IN {
        public String returnRequest(HashMap<Enum<?>, String> data) {
            StringBuffer buffer = new StringBuffer();

            buffer
                    .append("SELECT * FROM users WHERE (mail = '")
                    .append(data.get(Fields.LOGIN))
                    .append("') AND (password = '")
                    .append(data.get(Fields.PASSWORD))
                    .append("')");

            return buffer.toString();
        }
    },

    GET_SEATS{
      public String returnRequest(HashMap<Enum<?>, String> data){
          StringBuffer buffer = new StringBuffer();

          buffer
                  .append("SELECT * FROM seats WHERE flight_id = ")
                  .append(data.get(Fields.FLIGHT_ID))
                  .append(" AND order_id = -1");

          return buffer.toString();

      }
    },

    GET_FLIGHT{
        @Override
        public String returnRequest(HashMap<Enum<?>, String> data) {

            StringBuffer buffer = new StringBuffer();


            buffer
                    .append("SELECT * FROM flights WHERE name = '")
                    .append(data.get(Fields.FLIGHT_NAME))
                    .append("'");


            return buffer.toString();
        }
    },



    GET_SEAT_BY_ID{
        @Override
        public String returnRequest(HashMap<Enum<?>, String> data) {

            StringBuffer buffer = new StringBuffer();


            buffer
                    .append("SELECT * FROM seats WHERE ")
                    .append("id = ")
                    .append(data.get(SeatFields.ID));


            return buffer.toString();

        }
    },


    GET_ORDER_ID{
        @Override
        public String returnRequest(HashMap<Enum<?>, String> data) {
            StringBuffer buffer = new StringBuffer();

            buffer
                    .append("SELECT MAX(id) FROM orders");

            return buffer.toString();
        }
    },


    GET_USER_ID_BY_MAIL{
        @Override
        public String returnRequest(HashMap<Enum<?>, String> data) {
            StringBuffer buffer = new StringBuffer();

            buffer
                    .append("SELECT * FROM users WHERE mail = '")
                    .append(data.get(UserFields.MAIL))
                    .append("'");

            return buffer.toString();
        }
    };





    public String returnRequest(HashMap<Enum<?>, String> data){
        return null;
    }
}
