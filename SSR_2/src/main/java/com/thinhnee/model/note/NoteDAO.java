package com.thinhnee.model.note;

import com.thinhnee.model.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public static void addNote(String content, String username){
        String query = "insert into note(content, username)\n" +
                "value(?,?)";
        try {
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,content);
            preparedStatement.setString(2,username);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static List<Note> printAllNote(String username){
        List<Note> list = new ArrayList<>();
        String query = "select * from note where username = ?";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(new Note(resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3)));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }

    public static void deleteNote(int id, String username){
        String query = "delete from note where id = ? and username = ?";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.setString(2,username);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void updateNote(int id, String content, String username){
        String query = "update note\n" +
                "set content =?\n" +
                "where id = ? and username=?";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,content);
            preparedStatement.setString(2, String.valueOf(id));
            preparedStatement.setString(3,username);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
