package com.thinhnee.model.user;

import com.thinhnee.model.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    public static UserModel login(String username, String password){
        String query = "select * from users where username = ? and password=?";
        try{
            connection = DBContext.getConnection();
             preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                return new UserModel(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static UserModel checkAccountExist(String username){
        String query = "select * from users where username = ?";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                return new UserModel(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static void signUp(String username, String password, String fullname){
        String query = "insert into users(username, password, fullname)\n" +
                "value(?,?,?)";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,fullname);

            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void changeFullName(String fullname,String username){
        String query = "update users\n" +
                "set fullname = ?\n" +
                "where username= ?";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,fullname);
            preparedStatement.setString(2,username);

            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteAccount(String username){
        String query = "delete from users where username=?";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);

            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
