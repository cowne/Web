package com.thinhnee.controller.image;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.thinhnee.model.image.ImageDAO;
import com.thinhnee.model.image.ImageModel;
import com.thinhnee.model.user.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class ImageController {

    @WebServlet(urlPatterns = "/image")
    public static class viewAllImage extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();
            List<ImageModel> list = ImageDAO.getAllImage(username);

//            String message = req.getParameter("message");
//
//            req.setAttribute("message", message);
            req.setAttribute("imageName", list);
            req.getServletContext().getRequestDispatcher("/image.jsp").forward(req, resp);
        }

    }

    @MultipartConfig
    @WebServlet(urlPatterns = "/image/add")
    public static class addImage extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doGet(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();

            Part image = req.getPart("image");
            String filename = image.getSubmittedFileName();
            String uploadPath = req.getServletContext().getRealPath("/") + "img/" + filename;

            try {
                FileOutputStream fos = new FileOutputStream(uploadPath);
                InputStream is = image.getInputStream();
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            ImageDAO.addImage(filename,username);
            resp.sendRedirect("/image");
        }
    }

    @WebServlet(urlPatterns = "/image/delete")
    public static class deleteImage extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();
            int id = Integer.parseInt(req.getParameter("id"));
            ImageDAO.deleteImage(id,username);

            resp.sendRedirect("/image");
        }
    }

    @WebServlet(urlPatterns = "/image/update")
    @MultipartConfig
    public static class updateImage extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();
            int id = Integer.parseInt(req.getParameter("id"));

            Part image = req.getPart("image");
            String filename = image.getSubmittedFileName();
            String uploadPath = req.getServletContext().getRealPath("/") + "img/" + filename;

            try {
                FileOutputStream fos = new FileOutputStream(uploadPath);
                InputStream is = image.getInputStream();
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            ImageDAO.updateImage(id,filename,username);
            resp.sendRedirect("/image");
        }
    }
}
