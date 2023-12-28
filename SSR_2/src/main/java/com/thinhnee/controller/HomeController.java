package com.thinhnee.controller;

import java.io.*;

import com.thinhnee.model.DAO;
import com.thinhnee.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HomeController", urlPatterns = {"/home","/change-info","/delete","/logout"})
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!= null && action.equals("logout")){
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            response.sendRedirect("/home");
        }else{
            request.getRequestDispatcher("home.jsp").forward(request,response);
        }
       // request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserModel user = (UserModel) session.getAttribute("user");
        String username = user.getUsername();
        String action = request.getParameter("action");
        if(action.equals("changeName")){
            String fullname = request.getParameter("fullname");
            DAO.changeFullName(fullname, username);
            user.setFullname(fullname);
            request.setAttribute("message","Update information successfully.");
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }
        else if(action.equals("deleteAccount")){
            DAO.deleteAccount(username);
            session.removeAttribute("user");//remove the session and log out.
            request.setAttribute("message","Delete account successfully");
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }
    }
}