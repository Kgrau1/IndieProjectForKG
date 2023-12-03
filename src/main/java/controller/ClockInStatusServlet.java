package controller;

import entity.User;
import persistence.GenericDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
@WebServlet(
        name = "ClockInStatusServlet",
        urlPatterns = { "/ClockInStatusServlet" }
)
public class ClockInStatusServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));

        GenericDao<User> dao = new GenericDao<>(User.class);
        boolean isClockedIn = dao.getClockedInStatus(Integer.parseInt(String.valueOf(userId)));

        if (!isClockedIn) {
            User user = dao.getById(Integer.parseInt(String.valueOf(userId)));
            if (user == null) {
                request.setAttribute("userNotFound", true);
                RequestDispatcher errorDispatcher = request.getRequestDispatcher("index.jsp");
                errorDispatcher.forward(request, response);
                return;
            }
        }

        request.setAttribute("isClockedIn", isClockedIn);
        request.setAttribute("userId", userId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("clockingOptions.jsp");
        dispatcher.forward(request, response);
    }
}
