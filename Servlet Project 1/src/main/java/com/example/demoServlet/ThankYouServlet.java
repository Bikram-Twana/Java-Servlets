package com.example.demoServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ThankYouServlet", value = "/ThankYouServlet")
public class ThankYouServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("your userName is:" + userName );
        System.out.println("your userName is:" + userName);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName = request.getParameter("hiddenField");

        PrintWriter printWriter = response.getWriter();
        printWriter.println("your userName is:" + uName );
    }
}
