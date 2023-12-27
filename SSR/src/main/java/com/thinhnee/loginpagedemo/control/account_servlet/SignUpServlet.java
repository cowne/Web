package com.thinhnee.loginpagedemo.control.account_servlet;

import java.io.*;

import com.thinhnee.loginpagedemo.dao.AccountDAO;
import com.thinhnee.loginpagedemo.dao.UserDAO;
import com.thinhnee.loginpagedemo.entity.Account;
import com.thinhnee.loginpagedemo.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signUp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if(password.equals(confirmPassword)){
            Account newAcc = new Account(username,password);
           // AccountDAO accountDAO = new AccountDAO();
            AccountDAO.createAccount(newAcc);

            User user = new User(fname,lname,username);
            //UserDAO userDAO = new UserDAO();
            UserDAO.createUser(user);

            response.sendRedirect("/login");

        }else{
            request.setAttribute("message", "The password and confirm password is not equal. Please try again.");
            doGet(request,response);
        }
    }
}