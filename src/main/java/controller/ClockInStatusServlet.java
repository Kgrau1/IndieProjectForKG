package controller;

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

        GenericDao dao = new GenericDao();
        boolean isClockedIn = dao.getClockedInStatus(userId);

        request.setAttribute("isClockedIn", isClockedIn);

        RequestDispatcher dispatcher = request.getRequestDispatcher("clockingOptions.jsp");
        dispatcher.forward(request, response);
    }
}
