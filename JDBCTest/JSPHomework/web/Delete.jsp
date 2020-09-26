<%@ page import="java.sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/9/26
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int index = 0;
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:sqlserver://192.168.226.240:1433;DatabaseName=northwind", "sa", "123456a@");
        ps = conn.prepareStatement("delete from Categories where CategoryID = ?");
        ps.setString(1,request.getParameter("CategoryID"));
        index = ps.executeUpdate();
        if (index == 1) out.print("删除成功！");
        else out.print("删除失败！");


    } catch (ClassNotFoundException | SQLException e) {
        out.print("删除失败！");
    }

%><br>
<a href="index.jsp">返回上一页</a>
</body>
</html>
