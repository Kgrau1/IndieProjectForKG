package controller;

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

        String userId = request.getParameter("userId");

        //DAO call


        RequestDispatcher dispatcher = request.getRequestDispatcher("clockingOptions.jsp");
        dispatcher.forward(request, response);
    }
}
