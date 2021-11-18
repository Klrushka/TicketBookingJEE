package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.db.requests.UpdateSQLRequests;
import com.tb.ticketbooking.models.factory.UserFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;
import com.tb.ticketbooking.models.enums.UserFields;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;


@WebServlet(name = "SignUpServlet", value = "/sign-up")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        HashMap<Enum<?>, String> data = new HashMap<>();

        ModelFactory modelFactory = new UserFactory();

        DBUpdateRequest updateRequest = new UpdateSQLRequests();

        Model model = modelFactory.getInstance();


        data.put(UserFields.NAME, request.getParameter("name"));
        data.put(UserFields.PASSWORD, request.getParameter("password"));
        data.put(UserFields.BIRTHDAY, String.valueOf(request.getParameter("birthday")));
        data.put(UserFields.PHONENUMBER, request.getParameter("phoneNumber"));
        data.put(UserFields.MAIL, request.getParameter("mail"));


        model.setModelData(data);

        updateRequest.update(model);

       session.setAttribute("user", model);

       response.sendRedirect("sgn-in");

    }
}
