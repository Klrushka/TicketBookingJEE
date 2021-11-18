package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.requestStrategies.Fields;
import com.tb.ticketbooking.db.requestStrategies.select.DBGetResult;
import com.tb.ticketbooking.db.requestStrategies.update.field.UpdateFieldsExecutor;
import com.tb.ticketbooking.db.requests.DeleteSQLRequest;
import com.tb.ticketbooking.db.requests.SelectSQLRequests;
import com.tb.ticketbooking.db.requests.UpdateFieldRequest;
import com.tb.ticketbooking.db.requests.UpdateSQLRequests;
import com.tb.ticketbooking.models.enums.FlightFields;
import com.tb.ticketbooking.models.enums.OrderFields;
import com.tb.ticketbooking.models.enums.SeatFields;
import com.tb.ticketbooking.models.enums.UserFields;
import com.tb.ticketbooking.models.model.Flight;
import com.tb.ticketbooking.models.model.Order;
import com.tb.ticketbooking.models.model.Seat;
import com.tb.ticketbooking.models.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "UserOrdersServlet", value = "/user-orders")
public class UserOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        HashMap<Enum<?>, String> data = new HashMap<>();

        DBGetResult dbGetResult = new DBGetResult();

        data.put(UserFields.ID, String.valueOf(user.getId()));

        data.put(Fields.FLIGHT_NAME, String.valueOf(session.getAttribute("fl")));

        ResultSet resultSet = dbGetResult.getData(SelectSQLRequests.GET_FLIGHT, data);

        ArrayList<Order> orders = new ArrayList<>();

        ArrayList<Seat> seats = new ArrayList<>();


        try {

            if (resultSet.next()) {
                data.put(FlightFields.ID, String.valueOf(resultSet.getInt("id")));
            }

            resultSet = dbGetResult.getData(SelectSQLRequests.GET_ORDERS_BY_USER_AND_FLIGHT_ID, data);


            while (resultSet.next()) {

                Order order = new Order();

                data.put(OrderFields.USER_ID, String.valueOf(resultSet.getInt("user_id")));
                data.put(OrderFields.SEAT_ID, String.valueOf(resultSet.getInt("seat_id")));
                data.put(OrderFields.FLIGHT_ID, String.valueOf(resultSet.getInt("flight_id")));
                data.put(OrderFields.STATUS, resultSet.getString("status"));

                order.setModelData(data);

                orders.add(order);

            }


            for (int i = 0; i < orders.size(); i++) {

                Seat seat = new Seat();

                data.put(SeatFields.ID, String.valueOf(orders.get(i).getSeat_id()));

                resultSet = dbGetResult.getData(SelectSQLRequests.GET_SEAT_BY_ID, data);

                if (resultSet.next()) {
                    data.put(SeatFields.FLIGHT_ID, String.valueOf(resultSet.getInt("flight_id")));
                    data.put(SeatFields.SEAT_NUMBER, String.valueOf(resultSet.getInt("seat_number")));
                    data.put(SeatFields.CLASS, resultSet.getString("class"));
                    data.put(SeatFields.PRICE, String.valueOf(resultSet.getFloat("price")));

                    seat.setModelData(data);
                }

                seats.add(seat);
            }

            request.setAttribute("seats1", seats);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/UserOrders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String cancel[] = request.getParameterValues("seat-id-cancel");

        ArrayList<Order> orders = new ArrayList<>();

        DBGetResult dbGetResult = new DBGetResult();

        ResultSet resultSet;

        HashMap<Enum<?>, String> data = new HashMap<>();


        for (int i = 0; i < cancel.length; i++) {

            data.put(SeatFields.ID, cancel[i]);

            UpdateFieldsExecutor.execute(UpdateFieldRequest.DELETE_ORDER_FROM_SEAT.returnRequest(data));

            UpdateFieldsExecutor.execute(DeleteSQLRequest.DELETE_ORDER_BY_ID.returnRequest(data));

        }

        response.sendRedirect("all-flights");


    }
}
