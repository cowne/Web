package com.thinhnee.loginpagedemo.control.account_servlet;

import java.io.*;

import com.thinhnee.loginpagedemo.dao.UserDAO;
import com.thinhnee.loginpagedemo.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        User user = new User(fname,lname,username);
        UserDAO.updateInfo(user);

        response.sendRedirect("/user?username="+username);

    }
}