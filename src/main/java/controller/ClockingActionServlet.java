package controller;

import entity.Hours;
import entity.User;
import persistence.GenericDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(
        name = "ClockingActionServlet",
        urlPatterns = { "/ClockingActionServlet" }
)
public class ClockingActionServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        String jobId = request.getParameter("jobId");
        String action = request.getParameter("action");
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(userId);
        GenericDao<Hours> hoursDao = new GenericDao<>(Hours.class);
        Hours hours = new Hours();

        if ("Clock In".equals(action)) {
            user.setClockedIn(true);
            hours.setJobId(jobId);
            hours.setUser(user);
            userDao.clockIn(hours);
            user.getLoggedHours().add(hours);
            //////////////////////////////////
        } else if ("Clock out".equals(action)) {
            user.setClockedIn(false);
            userDao.clockOut(hours);
            user.getLoggedHours().add(hours);
            userDao.saveOrUpdate(user);
        } else if ("Change job".equals(action)) {
            hours.setJobId(jobId);
            user.setClockedIn(false);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
