package com.thinhnee.loginpagedemo.control.image_servlet;

import java.io.*;
import java.util.List;

import com.thinhnee.loginpagedemo.dao.ImageDAO;
import com.thinhnee.loginpagedemo.entity.Image;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ImageServlet", urlPatterns = "/image")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //get data from dao
        List<Image> list = ImageDAO.getAllImage(username);
        //set data to jsp
        request.setAttribute("imageList", list);

        request.getRequestDispatcher("/image.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}