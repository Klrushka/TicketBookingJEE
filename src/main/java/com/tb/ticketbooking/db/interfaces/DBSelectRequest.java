package com.tb.ticketbooking.db.interfaces;

import com.tb.ticketbooking.db.requestStrategies.select.SelectRequests;

import java.sql.ResultSet;
import java.util.HashMap;

public interface DBSelectRequest {
    ResultSet getData(SelectRequests request, HashMap<Enum<?>, String> fields);
}
