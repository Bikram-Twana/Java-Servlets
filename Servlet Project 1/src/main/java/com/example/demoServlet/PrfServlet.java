package com.example.demoServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileStore;

@WebServlet(name = "PrfServlet", value = "/PrfServlet")
public class PrfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();
        //String n = request.getParameter("name");
        HttpSession session = request.getSession(false);
        String n = (String) session.getAttribute("nm");
        printWriter.print("Welcome " + n);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
