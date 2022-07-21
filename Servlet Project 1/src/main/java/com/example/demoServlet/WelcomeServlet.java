package com.example.demoServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
// use urlpatterns instead of value below.
@WebServlet(name = "WelcomeServlet", value = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");



        //creating a cookie object.
        Cookie cookie = new Cookie("user",userName);
        response.addCookie(cookie); // adding cookie to res header.

        cookie.setMaxAge(5); // delete cookie after 5 sec

        // printWriter.println("<a href = 'WelcomeServlet'>Secondservlet");

        Cookie[] cookies = request.getCookies(); // get all the cookies
        PrintWriter printWriter = response.getWriter();
        printWriter.println(cookies[0].getValue());



        String passWord = request.getParameter(("password"));

        //PrintWriter printWriter = response.getWriter();
        System.out.println("Hello from second servlet.");
        printWriter.println("your userName is:" + userName + " and password is: "+ passWord);


//        //gettting session value
//
//        if(session != null){
//            String pass = (String) session.getAttribute("user");
//            printWriter.println("From welcome: Your password is : " + pass);
//        }
        //deleting session
        HttpSession session = request.getSession(false);
        session.invalidate();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);



    }
}
