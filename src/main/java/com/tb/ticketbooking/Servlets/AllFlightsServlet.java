package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.requestStrategies.select.alldata.SelectAllFlights;
import com.tb.ticketbooking.models.interfaces.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AllFlightsServlet", value = "/all-flights")
public class AllFlightsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null){
            SelectAllFlights selectAllFlights = new SelectAllFlights();


            ArrayList<Model> models = selectAllFlights.getFields();


            request.setAttribute("flight", models);


            getServletContext().getRequestDispatcher("/AllFlight.jsp").forward(request,response);
        } else{
            getServletContext().getRequestDispatcher("/ERROR.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String s = request.getParameter("flyname");
        session.setAttribute("fl",s);

        response.sendRedirect("flight-seats");
    }
}
