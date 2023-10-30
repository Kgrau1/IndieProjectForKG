package controller;

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
public class ClockInStatusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));

        GenericDao<User> dao = new GenericDao<>(User.class);
        boolean isClockedIn = dao.getClockedInStatus(userId);

        request.setAttribute("isClockedIn", isClockedIn);
        request.setAttribute("userId", userId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("clockingOptions.jsp");
        dispatcher.forward(request, response);
    }
}
