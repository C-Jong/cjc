<%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/9/25
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="SlectTest.jsp">
    <select name="img" multiple = "multiple" >
        <option value="1.jpg">中国</option>
        <option value="2.jpg">美国</option>
        <option value="3.jpg">英国</option>
        <option value="4.jpg">韩国</option>
    </select>
    <input type="submit" value="提交">
</form>

<p>
    <%
        String[] imgs = request.getParameterValues("img");
        if (imgs == null || imgs.length <= 0) return;
        for (int i = 0; i < imgs.length; i++) {
    %>
    <img src="images/<%=imgs[i] %>" alt="图片">
    <%
        }
    %>
</p>

</body>

</html>
