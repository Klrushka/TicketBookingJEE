package com.tb.ticketbooking.models.model;

import com.tb.ticketbooking.models.enums.UserFields;
import com.tb.ticketbooking.models.interfaces.Model;

import java.util.HashMap;

public class User implements Model {

    private String name;
    private String password;
    private String birthday;
    private String phoneNumber;
    private String mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public HashMap<Enum<?>, String> getModelData() {
        HashMap<Enum<?>, String> data = new HashMap<>();

        data.put(UserFields.NAME, name);
        data.put(UserFields.PASSWORD, password);
        data.put(UserFields.BIRTHDAY, birthday);
        data.put(UserFields.PHONENUMBER, phoneNumber);
        data.put(UserFields.MAIL, mail);

        return data;
    }

    @Override
    public void setModelData(HashMap<Enum<?>,String> data) {
        name = data.get(UserFields.NAME);
        mail = data.get(UserFields.MAIL);
        password = data.get(UserFields.PASSWORD);
        birthday = data.get(UserFields.BIRTHDAY);
        phoneNumber = data.get(UserFields.PHONENUMBER);
    }
}
