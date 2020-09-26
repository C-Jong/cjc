<%@page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/9/17
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

  </head>
  <style>
    h2{text-align: center; color: blue; font-family: 华文行楷; font-size: 50px}
    .del{color: red; font-size: 20px}
    .update{color: green ;font-size: 20px}
  </style>
  <body style="background-color: pink">
  <h2>所有产品种类</h2>

    <%
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;


    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      conn = DriverManager.getConnection("jdbc:sqlserver://192.168.226.240:1433;DatabaseName=northwind", "sa", "123456a@");
      stat = conn.createStatement();
      String strSQL = "select CategoryID,CategoryName,Description from categories";
      rs = stat.executeQuery(strSQL);


    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  %>
    <center>
  <table cellpadding="5px" cellspacing="0px" border="3px">
    <tr>
      <th>类别编号</th>
      <th>类别名称</th>
      <th>类别描述</th>
      <th>删除</th>
      <th>更新</th>
    </tr>
    <%
      while (rs.next()){
    %>
    <tr>
      <td style="font-size:20px"><%= rs.getString("CategoryID")%> </td>
      <td style="font-size:20px"><%= rs.getString("CategoryName")%> </td>
      <td style="font-size:20px"><%= rs.getString("Description")%> </td>
      <td class="del">删除</td>
      <td class="update">更新</td>
    </tr>
    <%
      }
      if (rs != null){
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (stat != null){
        try {
          stat.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (conn != null){
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

    %>


  </table><br><br><h4>修改上表数据</h4><br>
      <form action="Update.jsp" method="post">
        类别编号<input name="CategoryID" type="text">
        类别名称<input name="CategoryName" type="text">
        类别描述<input name="Description" type="text"><br><br>
        <input type="submit" value="确认修改">
        <input type="reset" value="清空内容">

      </form>
      <br><br><h4>增加上表数据</h4><br>
      <form action="Create.jsp" method="post">
      类别名称<input name="CategoryName" type="text">
      类别描述<input name="Description" type="text"><br><br>
      <input type="submit" value="确认增加">
      <input type="reset" value="清空内容">

    </form>
        </form>
        <br><br><h4>删除上表数据</h4><br>
        <form action="Delete.jsp" method="post">
            类别编号<input name="CategoryID" type="text"><br><br>
            <input type="submit" value="确认删除">
            <input type="reset" value="清空内容">

        </form>
    </center>

  </body>
</html>
