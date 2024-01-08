package com.thinhnee.controller.note;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.thinhnee.model.note.Note;
import com.thinhnee.model.note.NoteDAO;
import com.thinhnee.model.user.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class NoteController{
    @WebServlet(urlPatterns = "/note")
    public static class viewAllNote extends HttpServlet{
        static HttpSession session = null;
        static UserModel user = null;
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            session = req.getSession();
            user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();

            List<Note> list = NoteDAO.printAllNote(username);
            req.setAttribute("listNote", list);
            req.getRequestDispatcher("/note.jsp").forward(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            session = req.getSession();
            user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();

            String content = req.getParameter("content");

            NoteDAO.addNote(content,username);
            resp.sendRedirect("/note");
        }
    }

    @WebServlet(urlPatterns = "/note/update")
    public static class updateNote extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            req.setAttribute("id", id);
            req.getRequestDispatcher("/noteUpdate.jsp").forward(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            String content = req.getParameter("content");
            HttpSession session = req.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            String username = user.getUsername();

            NoteDAO.updateNote(Integer.parseInt(id),content,username);
            resp.sendRedirect("/note");
        }
    }

    @WebServlet(urlPatterns = "/note/delete")
    public static class deleteNote extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            int id = Integer.parseInt(req.getParameter("id"));
            String username = user.getUsername();

            NoteDAO.deleteNote(id,username);
            resp.sendRedirect("/note");

        }
    }
}
