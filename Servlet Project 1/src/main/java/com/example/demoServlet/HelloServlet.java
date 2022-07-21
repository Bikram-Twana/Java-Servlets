package com.example.demoServlet;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {
   // private String message;

    public void init() {

        // message = "Hello World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html"); // otherwise it will print html

        PrintWriter printWriter = response.getWriter();  // text in char stream and print to user.

        String userName = request.getParameter("userName");
        String passWord = request.getParameter(("password"));

        printWriter.println("your userName is:" + userName );
        System.out.println("your userName is:" + userName);

        printWriter.println("<a href='ThankYouServlet?name="+userName+"'>Access from Link</a>");
    }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        String userName = request.getParameter("userName");

        String passWord = request.getParameter(("password"));

//        if(passWord.equals("abc123")){
//            System.out.println("Succesfully Login");
//        }else{
//            System.out.println("wrong password.");
//        }

        String gender = request.getParameter("gender");
        String subject = request.getParameter("subject");

        String[] newArray = request.getParameterValues("interest");
        if(newArray != null){
            for(String str: newArray ){
                printWriter.println(str);
            }
        }



        if(passWord.equalsIgnoreCase("java" )){

            HttpSession session = request.getSession();
            session.setAttribute("user", userName);

            //setting  session inactive time.
            if(session.isNew()){
                session.setMaxInactiveInterval(20);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
            requestDispatcher.forward(request,response);

        }
            else{
                System.out.println("Invalid username or password");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.include(request,response);

        }

        printWriter.println("your userName is:" + userName + " and password is: "+ passWord + "gender is: "+ gender);
        System.out.println("your userName is:" + userName + " and password is: "+ passWord);



        //here is second form
            printWriter.println("<form action = 'ThankYouServlet' method='post'>");
            printWriter.println("<input type='text' name = 'hiddenField' value='"+userName+"'>");
            printWriter.println("<input type='submit' value='submit'>" );
            printWriter.println("</form>");
    }

    public void destroy() {

    }
}
