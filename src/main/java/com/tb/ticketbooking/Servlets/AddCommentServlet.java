package com.tb.ticketbooking.Servlets;

import com.tb.ticketbooking.db.interfaces.DBSelectRequest;
import com.tb.ticketbooking.db.requestStrategies.Fields;
import com.tb.ticketbooking.db.requestStrategies.select.DBGetResult;
import com.tb.ticketbooking.db.requestStrategies.update.UpdateCommentStrategy;
import com.tb.ticketbooking.db.requests.SelectSQLRequests;
import com.tb.ticketbooking.db.requests.UpdateSQLRequests;
import com.tb.ticketbooking.models.enums.CommentsFields;
import com.tb.ticketbooking.models.enums.FlightFields;
import com.tb.ticketbooking.models.factory.CommentFactory;
import com.tb.ticketbooking.models.interfaces.Model;
import com.tb.ticketbooking.models.interfaces.ModelFactory;
import com.tb.ticketbooking.models.model.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "AddCommentServlet", value = "/add-comment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        HashMap<Enum<?>, String> data = new HashMap<>();

        ArrayList<Comment> comments = new ArrayList<>();

        DBSelectRequest selectRequest = new DBGetResult();

        DBGetResult dbGetResult = new DBGetResult();

        data.put(Fields.FLIGHT_NAME, (String) session.getAttribute("fl"));

        ResultSet resultSet = selectRequest.getData(SelectSQLRequests.GET_FLIGHT, data);

        try {

            if (resultSet.next()){
                data.put(CommentsFields.FLIGHT_ID, String.valueOf(resultSet.getInt("id")));
            }

            session.setAttribute("id-flight",data.get(CommentsFields.FLIGHT_ID));

            resultSet = dbGetResult.getData(SelectSQLRequests.GET_ALL_COMMENTS_ABOUT_FLIGHTS,data);

            while (resultSet.next()){

                Comment comment = new Comment();


                data.put(CommentsFields.TEXT, resultSet.getString("text"));

                comment.setModelData(data);

                comments.add(comment);
            }


            request.setAttribute("com",comments);

        } catch (SQLException e){
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/AddComment.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        HashMap<Enum<?>, String> data = new HashMap<>();

        ModelFactory factory = new CommentFactory();

        Model model = factory.getInstance();

        UpdateSQLRequests updateSQLRequests = new UpdateSQLRequests();

        data.put(CommentsFields.FLIGHT_ID, String.valueOf(session.getAttribute("id-flight")));
        data.put(CommentsFields.TEXT, request.getParameter("comment-text"));


        model.setModelData(data);

        updateSQLRequests.update(model);

        response.sendRedirect("add-comment");

    }
}
