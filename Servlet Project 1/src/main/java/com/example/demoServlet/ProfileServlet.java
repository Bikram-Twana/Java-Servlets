package com.example.demoServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pwd = request.getParameter("password");
        String name = request.getParameter("userName");
        if(pwd.equals("java")){
            HttpSession session = request.getSession(true);
            session.setAttribute("nm",name);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
            requestDispatcher.forward(request,response);
        }
        else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }


    }
}
