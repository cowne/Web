package com.thinhnee.loginpagedemo.control.image_servlet;

import java.io.*;

import com.thinhnee.loginpagedemo.dao.ImageDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@MultipartConfig
@WebServlet(name = "AddImageServlet", urlPatterns = "/addImage")
public class AddImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/image").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post is here");
        String username = request.getParameter("username");
        System.out.println(username);

        Part file = request.getPart("image");
        String filename = file.getSubmittedFileName();
        System.out.println(filename);

        String uploadPath ="C:/Users/PC/Desktop/0toHero/SSR/src/main/webapp/images/" + filename;
        System.out.println(uploadPath);

        try{
            FileOutputStream fos = new FileOutputStream(uploadPath);
            InputStream is = file.getInputStream();
            byte[] data = new byte[is.available()];
            is.read(data);
            fos.write(data);
            fos.close();
        }catch(Exception e){
            System.out.println(e);
        }

        ImageDAO.addImage(filename,username);
        String url = "/image?username=" + username;
        response.sendRedirect(url);

    }
}