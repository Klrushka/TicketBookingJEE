package com.tb.ticketbooking.models.interfaces;

import java.util.HashMap;

public interface Model {
    HashMap<Enum<?>, String> getModelData();
    void setModelData (HashMap<Enum<?>, String> data);
}
