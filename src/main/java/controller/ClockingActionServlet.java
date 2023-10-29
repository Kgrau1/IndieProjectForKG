package controller;

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

        String jobId = request.getParameter("jobId");
        String action = request.getParameter("action");

        if ("Clock In".equals(action)) {

        } else if ("Clock out".equals(action)) {

        } else if ("Change job".equals(action)) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}
