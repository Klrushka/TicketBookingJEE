package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBUpdateRequest;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateUserStrategy;
import com.tb.ticketbooking.models.factory.UserFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;
import com.tb.ticketbooking.models.user.UserFields;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;


@WebServlet(name = "SignUpServlet", value = "/sign")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/SignUp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<Enum<?>, String> data = new HashMap<>();

        ModelFactory modelFactory = new UserFactory();

        DBUpdateRequest updateRequest = new UpdateUserStrategy();

        Model model = modelFactory.getInstance();

        data.put(UserFields.NAME, (String) request.getAttribute("name"));
        data.put(UserFields.PASSWORD, (String) request.getAttribute("password"));
        data.put(UserFields.BIRTHDAY, (String) String.valueOf(request.getAttribute("birthday")));
        data.put(UserFields.PHONENUMBER, (String) request.getAttribute("phoneNumber"));
        data.put(UserFields.MAIL, (String) request.getAttribute("mail"));


        model.setModelData(data);

        updateRequest.update(model);

        // TODO forward to main page

    }
}
