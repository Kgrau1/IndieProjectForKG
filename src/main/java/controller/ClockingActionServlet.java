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



        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

}