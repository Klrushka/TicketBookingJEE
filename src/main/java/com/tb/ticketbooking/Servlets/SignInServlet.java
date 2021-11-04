package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBSelectRequest;
import com.tb.ticketbooking.db.requestStrategies.select.SelectRequests;
import com.tb.ticketbooking.db.requestStrategies.select.signin.DBSignInRequest;
import com.tb.ticketbooking.db.requestStrategies.select.signin.SignInFields;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "SignInServlet", value = "/SignInServlet")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("SignIn.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        DBSelectRequest selectRequest = new DBSignInRequest();

        HashMap<Enum<?>,String> data = new HashMap<>();

        data.put(SignInFields.LOGIN,request.getParameter("login-login"));
        data.put(SignInFields.PASSWORD,request.getParameter("login-password"));


        //TODO login session atribute  user
        try {
            if (selectRequest.getData(SelectRequests.SIGN_IN,data).next() || );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
