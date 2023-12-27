package com.thinhnee.loginpagedemo.control;

import java.io.*;

import com.thinhnee.loginpagedemo.dao.UserDAO;
import com.thinhnee.loginpagedemo.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = UserDAO.getUserInfoByUsername(username);
        String fname = user.getFirstName();
        String lname = user.getLastName();

        request.setAttribute("username",username);
        request.setAttribute("firstname", fname);
        request.setAttribute("lastname",lname);
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}