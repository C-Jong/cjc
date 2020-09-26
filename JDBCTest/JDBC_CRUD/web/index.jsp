<%@ page import="com.JDBCUtils.JDBCUtil" %>
<%@ page import="com.JAVABean.Categories" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/9/26
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table cellpadding="5px" cellspacing="0px" border="3px">
    <tr>
      <th>类别编号</th>
      <th>类别名称</th>
      <th>类别描述</th>
      <th>删除</th>
      <th>更新</th>
    </tr>

      <%
        ArrayList<Categories> retrieve = JDBCUtil.Retrieve();
        for (Categories categories : retrieve){
      %>
      <tr>
      <td><%=categories.getCategoryID()%></td>
      <td><%=categories.getCategoryName()%></td>
      <td><%=categories.getDescription()%></td>
      <td>删除</td>
      <td>更新</td>
      <%}%>
    </tr>
  </table>
  </body>
</html>
