package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
@WebServlet(
        name = "",
        urlPatterns = { "/" }
)
public class ChangeJobServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String jobId = request.getParameter("jobId");

        //DAO call


        RequestDispatcher dispatcher = request.getRequestDispatcher("changeJobConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}
