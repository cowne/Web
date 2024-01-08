package com.thinhnee.controller.user;

import java.io.*;

import com.thinhnee.model.user.DAO;
import com.thinhnee.model.user.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class UserController{
    @WebServlet(urlPatterns = "/user")
    public  static  class User extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }

    @WebServlet(urlPatterns = "/user/delete")
    public static class DeleteAccount extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();

            DAO.deleteAccount(username);
            session.removeAttribute("user");//remove the session and log out.
            req.setAttribute("message","Delete account successfully");
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }
    }

    @WebServlet(urlPatterns = "/user/update")
    public static class UpdateAccount extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();

            String fullname = request.getParameter("fullname");
            DAO.changeFullName(fullname, username);
            user.setFullname(fullname);
            request.setAttribute("message","Update information successfully.");
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }
    }

    @WebServlet(urlPatterns = "/login")
    public static class Login extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserModel user = DAO.login(username,password);
            if(user == null){
                request.setAttribute("message","Wrong username or password!");
                request.getRequestDispatcher("/views/login.jsp").forward(request,response);
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("/user");
            }
        }
    }

    @WebServlet(urlPatterns = "/logout")
    public static class Logout extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            session.removeAttribute("user");
            resp.sendRedirect("/home.jsp");
        }
    }

    @WebServlet(urlPatterns = "/signUp")
    public static class SignUp extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/views/signUp.jsp").forward(req,resp);
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

    @WebServlet(urlPatterns = "/home")
    public static class Home extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }
    }
}