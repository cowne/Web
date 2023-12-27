package com.thinhnee.loginpagedemo.dao;

import com.thinhnee.loginpagedemo.entity.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO extends DAO {
    private static final String selectImageQuery = "select * from image where username=?";
    private static final String addImageQuery = "insert into image(imageFileName,username) value(?,?)";

    public static List<Image> getAllImage(String username){
        List<Image> listImage = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectImageQuery);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Image image = new Image(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                listImage.add(image);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return listImage;
    }
    public static void addImage(String imgFileName,String username){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addImageQuery);
            preparedStatement.setString(1,imgFileName);
            preparedStatement.setString(2,username);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
