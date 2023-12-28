package com.thinhnee.controller;

import java.io.*;

import com.thinhnee.model.DAO;
import com.thinhnee.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SignUpController", urlPatterns = "/signUp")
public class SignUpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/signUp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirmPassword");
        if(!password.equals(confirmPass)){
            request.setAttribute("message","Incorrect confirm password!");
            request.getRequestDispatcher("/views/signUp.jsp").forward(request,response);
        }else {
            UserModel user = DAO.checkAccountExist(username);
            if(user == null){
                // user doesn't exist, do sign up
                DAO.signUp(username,password,fullname);
                response.sendRedirect("/login");
            }else{
                //user already exist
                request.setAttribute("message","Username is exist.");
                request.getRequestDispatcher("/views/signUp.jsp").forward(request,response);
            }
        }
    }
}