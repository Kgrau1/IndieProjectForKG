package controller;

import entity.Hours;
import entity.User;
import persistence.GenericDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(
        name = "",
        urlPatterns = { "/" }
)
public class ClockingActionServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String jobId = request.getParameter("jobId");
        String action = request.getParameter("action");
        GenericDao<User> dao = new GenericDao<>(User.class);
        Hours hours = new Hours();

        if ("Clock In".equals(action)) {
            User user = dao.getById(Integer.parseInt(userId));
            user.setClockedIn(true);
            dao.clockIn(hours);
            user.getLoggedHours().add(hours);
        } else if ("Clock out".equals(action)) {

        } else if ("Change job".equals(action)) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
