package com.JDBCUtils;

import com.JAVABean.Categories;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtil {
private JDBCUtil(){

}
    //创建连接的方法
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://192.168.226.240:1433;DatabaseName=northwind", "sa", "123456a@");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    //关闭资源的方法
    public static void close(Connection connection,Statement statement,ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }if (connection != null){
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }if (connection != null){
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public  static ArrayList<Categories> Retrieve() throws SQLException {
        ArrayList<Categories> arrayList = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = JDBCUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select CategoryID,CategoryName,Description from categories");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (resultSet.next()){
            arrayList.add(new Categories(
                    resultSet.getString("CategoryID"),
                    resultSet.getString("CategoryName"),
                    resultSet.getString("Description")));
        }
        return arrayList;
    }


    public static void main(String[] args) throws SQLException {
        System.out.println(JDBCUtil.Retrieve());
    }



}
