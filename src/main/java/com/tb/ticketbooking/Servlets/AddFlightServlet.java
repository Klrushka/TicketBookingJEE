package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.db.requests.UpdateSQLRequests;
import com.tb.ticketbooking.models.enums.FlightFields;
import com.tb.ticketbooking.models.factory.FlightFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "AddFlightServlet", value = "/add-flight")
public class AddFlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/AddFlight.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<Enum<?>, String> data = new HashMap<>();

        ModelFactory factory = new FlightFactory();

        Model model = factory.getInstance();

        DBUpdateRequest updateRequest = new UpdateSQLRequests();

        data.put(FlightFields.NAME,request.getParameter("name"));
        data.put(FlightFields.FROM,request.getParameter("from"));
        data.put(FlightFields.TO,request.getParameter("to"));
        data.put(FlightFields.TIME,request.getParameter("time"));

        model.setModelData(data);

        updateRequest.update(model);

        // TODO forward to main page

    }
}
