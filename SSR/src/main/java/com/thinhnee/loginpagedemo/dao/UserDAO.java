package com.thinhnee.loginpagedemo.dao;

import com.thinhnee.loginpagedemo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private static final String getInfoQuery = "call get_user_info(?)";
    private static final String updateInfoQuery = "call update_user_info(?,?,?)";
    private static final String deleteInfoQuery = "delete from user_info where username = ?";

    private static final String createUserQuery = "insert into user_info(firstname,lastname,username)\n" +
            "value(?,?,?)";

    public static User getUserInfoByUsername(String username){
        User user = null;
        try{
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(getInfoQuery);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String firstName = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                //String username = resultSet.getString("username");
                user = new User(firstName,lastname,username);
            }
        }catch(Exception e){
            System.out.println("something went wrong here.");
        }
        return user;
    }

    public static boolean updateInfo(User user){
        boolean rowUpdate = false;
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateInfoQuery);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3, user.getLastName());

            rowUpdate  = preparedStatement.executeUpdate() > 0;
        }catch (Exception e){
            System.out.println(e);
        }
        return rowUpdate;
    }

    public static void deleteUserInfo(String username){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteInfoQuery);
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void createUser(User user){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(createUserQuery);
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getUsername());

            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
