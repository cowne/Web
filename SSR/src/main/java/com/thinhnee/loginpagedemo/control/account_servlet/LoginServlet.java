package com.thinhnee.loginpagedemo.control.account_servlet;

import java.io.*;

import com.thinhnee.loginpagedemo.dao.AccountDAO;
import com.thinhnee.loginpagedemo.entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //dosomething here
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = new Account(username,password);
        AccountDAO accountDAO = new AccountDAO();
        if(accountDAO.checkAccount(account)){
            response.sendRedirect("/user?username="+username);
        }else{
            request.setAttribute("message","The username or password is incorrect.");
            doGet(request,response);
        }
    }
}