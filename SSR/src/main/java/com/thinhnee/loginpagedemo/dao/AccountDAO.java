package com.thinhnee.loginpagedemo.dao;

import com.thinhnee.loginpagedemo.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO extends DAO {
    //This class connect with the database and execute the command.
    //private static final String selectUser = "select * from users where username=? and password=?";
    //the procedure must have in the database.
    private static final String selectUser = "call check_user_exist(?,?)";

    private static final String deleteAccount = "delete from users where username = ?";
    private static final String createAccount ="insert into users(username, password) value(?,?)";
    // Method connect with the db

    public boolean checkAccount(Account account){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectUser);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public static void deleteAccount(String username){
        try{
            UserDAO dao = new UserDAO();
            dao.deleteUserInfo(username);
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteAccount);
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void createAccount(Account account){
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(createAccount);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());

            preparedStatement.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
