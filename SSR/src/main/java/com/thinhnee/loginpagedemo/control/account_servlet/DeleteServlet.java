package com.thinhnee.loginpagedemo.control.account_servlet;

import java.io.*;

import com.thinhnee.loginpagedemo.dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        // phải xóa user info trc khi xóa account vì user info có quan hệ với account.
        AccountDAO accountDAO = new AccountDAO();
        AccountDAO.deleteAccount(username);

        response.sendRedirect("/login");

    }
}