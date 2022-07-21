package com.example.FinalServletProject;

import Service.UserService;
import hashing.PasswordHashing;
import model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("page");

        if(action.equalsIgnoreCase("newUser")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/register.jsp");
            requestDispatcher.forward(request,response);
        }
        if (action.equalsIgnoreCase("login")){
            String userName = request.getParameter("userName");
            String password = PasswordHashing.hashPassword(request.getParameter("password"));

            User user = new UserService().getUser(userName,password);

            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("fullName",user.getFullName());
                session.setAttribute("user",user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/dash.jsp");
                requestDispatcher.forward(request,response);
            }
            else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.include(request,response);
            }
        }

        if (action.equalsIgnoreCase("register")){
            User user = new User();
            //String userName = request.getParameter("userName");
            //System.out.println(userName);

            user.setUserName(request.getParameter("userName"));
            user.setFullName(request.getParameter("fullName"));
            user.setPassword(PasswordHashing.hashPassword(request.getParameter("password")));
            new UserService().insertUser(user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }

        if(action.equalsIgnoreCase("dash")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/dash.jsp");
            requestDispatcher.forward(request,response);
        }

        if(action.equalsIgnoreCase("listUser")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/listUser.jsp");
            requestDispatcher.forward(request,response);
        }

        if(action.equalsIgnoreCase("logout")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }

        if(action.equalsIgnoreCase("liUser")){
            User user = new User();
            List<User> list = new UserService().getUserList();
            request.setAttribute("list",list);
            request.setAttribute("user",user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/listUser.jsp");
            requestDispatcher.forward(request,response);
        }

        if(action.equalsIgnoreCase("addNew")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/addUser.jsp");
            requestDispatcher.forward(request,response);
        }


        if (action.equalsIgnoreCase("addUser")){
            User user = new User();

            user.setFullName(request.getParameter("fullName"));
            user.setUserName(request.getParameter("userName"));
            user.setPassword(request.getParameter("password"));
            new UserService().insertUser(user);

            // if user list button is clicked, show the list of users
            User newUser = new User();
            ArrayList<User> newUserlist = (ArrayList<User>) new UserService().getUserList();

            request.setAttribute("list", newUserlist);
            request.setAttribute("user",newUser);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/listUser.jsp");
            requestDispatcher.forward(request,response);
        }



        //for user Details
        if(action.equalsIgnoreCase("userDetails")){
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUserRow(id);
            request.setAttribute("user",user);
            request.setAttribute("id",id);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/userDetails.jsp");
            requestDispatcher.forward(request,response);
        }

        //delete
        if(action.equalsIgnoreCase("userDelete")){
            int  id = Integer.parseInt(request.getParameter("id"));
            UserService userService = new UserService();
            userService.deleteUser(id);

            List<User> list = new UserService().getUserList();
            request.setAttribute("list",list);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/listUser.jsp");
            requestDispatcher.forward(request,response);

        }

        //for edit User
        if(action.equalsIgnoreCase("userEdit")){
            int  id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUserRow(id);
            request.setAttribute("user",user);
            request.setAttribute("id",id);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/editUser.jsp");
            requestDispatcher.forward(request,response);
        }

        if(action.equalsIgnoreCase("editUser")){
            User user = new User();
            int  id = Integer.parseInt(request.getParameter("id"));

           // user.setId(id);
            user.setUserName(request.getParameter("userName"));
            user.setFullName(request.getParameter("fullName"));
            user.setPassword(PasswordHashing.hashPassword(request.getParameter("password")));

            try{
                new UserService().editUser(id,user);
            }
            catch (SQLException e){
                //System.out.println("Cannot edit User");
                e.printStackTrace();
            }
            List<User> list = new UserService().getUserList();
            request.setAttribute("list",list);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pages/listUser.jsp");
            requestDispatcher.forward(request,response);
        }



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        doPost(request,response);
    }

    public void destroy() {
    }
}