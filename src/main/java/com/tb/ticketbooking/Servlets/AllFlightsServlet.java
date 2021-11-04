package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.requestStrategies.select.alldata.SelectAllFlights;
import com.tb.ticketbooking.models.interfaces.Model;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AllFlightsServlet", value = "/all-flights")
public class AllFlightsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SelectAllFlights selectAllFlights = new SelectAllFlights();


        ArrayList<Model> models = selectAllFlights.getFields();


        request.setAttribute("flight", models);

        getServletContext().getRequestDispatcher("/AllFlight.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}