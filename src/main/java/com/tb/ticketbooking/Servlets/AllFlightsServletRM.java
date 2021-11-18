package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.requestStrategies.select.alldata.SelectAllFlights;
import com.tb.ticketbooking.models.interfaces.Model;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AllFlightsServletRM", value = "/all-flights-rm")
public class AllFlightsServletRM extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

            SelectAllFlights selectAllFlights = new SelectAllFlights();


            ArrayList<Model> models = selectAllFlights.getFields();


            request.setAttribute("flight", models);


            getServletContext().getRequestDispatcher("/AllFlightRM.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String s = request.getParameter("flyname");
        session.setAttribute("fl",s);

        response.sendRedirect("flight-seats-rm");
    }
}
