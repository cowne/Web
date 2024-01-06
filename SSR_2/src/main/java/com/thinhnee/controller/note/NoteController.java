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

@WebServlet(name = "NoteController", urlPatterns = "/note")
public class NoteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        //get username
        UserModel user = (UserModel) session.getAttribute("user");
        String username = user.getUsername();

        // set database;
        List<Note> list = new ArrayList<>();

        if(action!= null && action.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            NoteDAO.deleteNote(id);
        }else if(action != null && action.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
        }

        list = NoteDAO.printAllNote(username);
        request.setAttribute("listNote", list);
        request.getRequestDispatcher("/note.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserModel user = (UserModel) session.getAttribute("user");
        String username = user.getUsername();
        String content = request.getParameter("note");

        NoteDAO.addNote(content,username);
        response.sendRedirect("/note");
    }
}