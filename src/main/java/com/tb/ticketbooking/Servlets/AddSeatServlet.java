package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateSeatStrategy;
import com.tb.ticketbooking.models.enums.SeatFields;
import com.tb.ticketbooking.models.factory.SeatFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;
import com.tb.ticketbooking.models.model.Seat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "AddSeatServlet", value = "/add-seat")
public class AddSeatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/AddSeat.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Enum<?>, String> data = new HashMap<>();

        ModelFactory factory = new SeatFactory();

        Model model = factory.getInstance();

        DBUpdateRequest updateRequest = new UpdateSeatStrategy();

        data.put(SeatFields.FLIGHT_ID, request.getParameter("flight_id"));
        data.put(SeatFields.PRICE, request.getParameter("price"));
        data.put(SeatFields.CLASS, request.getParameter("class"));
        data.put(SeatFields.ORDER_ID, request.getParameter("order_id"));



        for (int i = Integer.parseInt(request.getParameter("seat_number"));
             i < Integer.parseInt(request.getParameter("n")) + Integer.parseInt(request.getParameter("seat_number"));
             i++) {

            data.put(SeatFields.SEAT_NUMBER, String.valueOf(i));

            model.setModelData(data);

            updateRequest.update(model);
        }




    }
}
