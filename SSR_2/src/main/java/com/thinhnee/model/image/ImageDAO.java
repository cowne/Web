package com.thinhnee.model.image;

import com.thinhnee.model.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {
    static Connection connection;
    static PreparedStatement preparedStatement;
    ResultSet resultSet;

    public static List<ImageModel> getAllImage(String username){
        List<ImageModel> listImage = new ArrayList<>();
        String query = "select * from image where username = ?";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ImageModel image = new ImageModel(resultSet.getInt(1),
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
        String query ="insert into image(imageName,username) value(?,?)";
        try{
            connection = DBContext.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,imgFileName);
            preparedStatement.setString(2,username);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteImage(int id, String username){
        String query = "delete from image where id =? and username = ?";
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

    public static void updateImage(int id,String imageFileName, String username){
        String query = "update image set imageName = ? where id =? and username=?";
        try{
            connection = DBContext.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,imageFileName);
            preparedStatement.setString(2, String.valueOf(id));
            preparedStatement.setString(3,username);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
