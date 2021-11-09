package com.tb.ticketbooking.db.interfaces;

import com.tb.ticketbooking.db.requests.SelectSQLRequests;

import java.sql.ResultSet;
import java.util.HashMap;

public interface DBSelectRequest {
    ResultSet getData(SelectSQLRequests request, HashMap<Enum<?>, String> fields);
}
