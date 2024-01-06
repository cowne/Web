package com.thinhnee.controller.user;

import java.io.*;

import com.thinhnee.model.user.DAO;
import com.thinhnee.model.user.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserModel user = DAO.login(username,password);
        if(user == null){
            request.setAttribute("message","Wrong username or password!");
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/home");
        }
    }

}