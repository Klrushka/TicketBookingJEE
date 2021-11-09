package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBSelectRequest;
import com.tb.ticketbooking.db.requestStrategies.Fields;
import com.tb.ticketbooking.db.requestStrategies.select.DBGetResult;
import com.tb.ticketbooking.db.requests.SelectSQLRequests;
import com.tb.ticketbooking.models.enums.SeatFields;
import com.tb.ticketbooking.models.factory.SeatFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "FlightSeatsServlet", value = "/flight-seats")
public class FlightSeatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        ModelFactory factory = new SeatFactory();



        HashMap<Enum<?>, String> data = new HashMap<>();

        ArrayList<Model> models = new ArrayList<>();

        DBSelectRequest selectRequest = new DBGetResult();

        data.put(Fields.FLIGHT_NAME, (String) session.getAttribute("fl"));


        ResultSet resultSet = selectRequest.getData(SelectSQLRequests.GET_SEATS, data);

        try {
            while (resultSet.next()) {
                Model model = factory.getInstance();

                data.put(SeatFields.FLIGHT_ID, resultSet.getString("flight_id"));
                data.put(SeatFields.PRICE, resultSet.getString("price"));
                data.put(SeatFields.CLASS, resultSet.getString("class"));
                data.put(SeatFields.ORDER_ID, resultSet.getString("order_id"));
                data.put(SeatFields.SEAT_NUMBER, resultSet.getString("seat_number"));

                model.setModelData(data);

                models.add(model);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("seats", models);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
