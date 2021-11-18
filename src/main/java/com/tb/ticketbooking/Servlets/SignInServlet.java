package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBSelectRequest;
import com.tb.ticketbooking.db.requests.SelectSQLRequests;
import com.tb.ticketbooking.db.requestStrategies.select.DBGetResult;
import com.tb.ticketbooking.db.requestStrategies.Fields;
import com.tb.ticketbooking.models.enums.UserFields;
import com.tb.ticketbooking.models.factory.UserFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/SignIn.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        ModelFactory factory = new UserFactory();

        Model model = factory.getInstance();

        DBSelectRequest selectRequest = new DBGetResult();

        HashMap<Enum<?>,String> data = new HashMap<>();

        data.put(Fields.LOGIN,request.getParameter("login-login"));
        data.put(Fields.PASSWORD,request.getParameter("login-password"));


        ResultSet resultSet = selectRequest.getData(SelectSQLRequests.SIGN_IN,data);


        session.setAttribute("user",null);


        try {
            if (resultSet.next()){
                data.put(UserFields.ID, String.valueOf(resultSet.getInt("id")));
                data.put(UserFields.BIRTHDAY, String.valueOf(resultSet.getDate("birthday")));
                data.put(UserFields.MAIL, resultSet.getString("mail"));
                data.put(UserFields.NAME, resultSet.getString("name"));
                data.put(UserFields.PHONENUMBER, resultSet.getString("phonenumber"));

                model.setModelData(data);


                session.setAttribute("user", model);
            }




            if (session.getAttribute("user") != null){
               response.sendRedirect("http://localhost:8080/TicketBookingJEE_war_exploded/all-flights");
            } else {
                getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
