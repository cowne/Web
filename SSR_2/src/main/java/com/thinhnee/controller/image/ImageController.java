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
@MultipartConfig
@WebServlet(name = "ImageController", urlPatterns = "/image")
public class ImageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserModel user = (UserModel) session.getAttribute("user");
        String username = user.getUsername();

        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if(action != null && id != null){
            int image_id = Integer.parseInt(id);
            if (action.equals("delete")) {
                ImageDAO.deleteImage(image_id, username);
                request.setAttribute("message", "Delete image successfully.");
            } else {
                System.out.println("nothing here");
            }
        }

        List<ImageModel> list = ImageDAO.getAllImage(username);
        request.setAttribute("imageName", list);
        request.getRequestDispatcher("/image.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserModel user = (UserModel) session.getAttribute("user");
        String username = user.getUsername();
        String action = request.getParameter("action");

        if(action!=null){
            Part image = request.getPart("image");
            String filename = image.getSubmittedFileName();
            String uploadPath = request.getServletContext().getRealPath("/") + "img/"+filename;

            try{
                FileOutputStream fos = new FileOutputStream(uploadPath);
                InputStream is = image.getInputStream();
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
                fos.close();
            }catch(Exception e){
                System.out.println(e);
            }

            switch (action){
                case "addImage":
                    ImageDAO.addImage(filename,username);
                    break;
                case "update":
                    int id = Integer.parseInt(request.getParameter("id"));
                    ImageDAO.updateImage(id,filename,username);
                    break;
                default:
                    System.out.println("nothing to do");
            }

        }
        response.sendRedirect("/image");
    }
}