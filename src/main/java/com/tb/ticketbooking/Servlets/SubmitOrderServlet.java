package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBSelectRequest;
import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.db.requestStrategies.select.DBGetResult;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateOrderStrategy;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateSeatStrategy;
import com.tb.ticketbooking.db.requestStrategies.update.field.UpdateFieldsExecutor;
import com.tb.ticketbooking.db.requests.SelectSQLRequests;
import com.tb.ticketbooking.db.requests.UpdateFieldRequest;
import com.tb.ticketbooking.models.enums.OrderFields;
import com.tb.ticketbooking.models.enums.SeatFields;
import com.tb.ticketbooking.models.enums.UserFields;
import com.tb.ticketbooking.models.factory.SeatFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;
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

@WebServlet(name = "SubmitOrderServlet", value = "/submit-order")
public class SubmitOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {


            User user = (User) session.getAttribute("user");

            ModelFactory factory = new SeatFactory();

            String seats[] = (String[]) session.getAttribute("seats-id");

            DBSelectRequest selectRequest = new DBGetResult();

            ResultSet resultSet;

            HashMap<Enum<?>, String> data = new HashMap<>();

            ArrayList<Model> models = new ArrayList<>();


            if (seats != null) {

                for (int i = 0; i < seats.length; i++) {

                    data.put(UserFields.MAIL, user.getMail());

                    data.put(SeatFields.ID, seats[i]);

                    Model model = factory.getInstance();




                    try {

                        resultSet = selectRequest.getData(SelectSQLRequests.GET_USER_ID_BY_MAIL,data);

                        if(resultSet.next()){
                            user.setId(resultSet.getInt(1));
                        }

                       session.setAttribute("user-id",user.getId());

                        resultSet = selectRequest.getData(SelectSQLRequests.GET_SEAT_BY_ID, data);

                        while (resultSet.next()) {
                            data.put(SeatFields.FLIGHT_ID, String.valueOf(resultSet.getInt("flight_id")));
                            data.put(SeatFields.PRICE, String.valueOf(resultSet.getFloat("price")));
                            data.put(SeatFields.CLASS, resultSet.getString("class"));
                            data.put(SeatFields.ORDER_ID, String.valueOf(resultSet.getInt("order_id")));
                            data.put(SeatFields.SEAT_NUMBER, String.valueOf(resultSet.getInt("seat_number")));
                        }

                        model.setModelData(data);

                        models.add(model);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            session.setAttribute("ss", models);
            request.setAttribute("seatOrder", models);

            getServletContext().getRequestDispatcher("/SubmitOrder.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/ERROR.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        ArrayList<Seat> seats = (ArrayList<Seat>) session.getAttribute("ss");


        HashMap<Enum<?>, String> data = new HashMap<>();

        DBSelectRequest selectRequest = new DBGetResult();


        ResultSet resultSet = selectRequest.getData(SelectSQLRequests.GET_ORDER_ID, data);

        DBUpdateRequest updateRequest = new UpdateOrderStrategy();

        try {

            Order order = new Order();

            if (resultSet.next()) {

                order.setId(resultSet.getInt(1) + 1);

                data.put(OrderFields.ID, String.valueOf(order.getId()));


                for (int i = 0; i < seats.size(); i++) {

                    data.put(SeatFields.ID, String.valueOf(seats.get(i).getId()));

                    data.put(OrderFields.SEAT_ID, String.valueOf(seats.get(i).getId()));

                    data.put(OrderFields.FLIGHT_ID, seats.get(i).getFlightId());

                    data.put(OrderFields.USER_ID, String.valueOf(session.getAttribute("user-id")));



                    UpdateFieldsExecutor.execute(UpdateFieldRequest.UPDATE_SEAT_ORDER_ID.returnRequest(data));

                    order.setModelData(data);

                    updateRequest.update(order);

                    data.put(OrderFields.ID, String.valueOf(order.getId() + 1));

                    order.setId(order.getId() + 1);
                }


            } else {
                throw new Exception("Invalid order");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
