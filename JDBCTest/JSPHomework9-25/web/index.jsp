<%@ page import="com.calculator.Calculator" %><%--
  Created by IntelliJ IDEA.
  User: CC
  Date: 2020/9/25
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form>
    操作数1<input type="text" name="sum1">&nbsp;&nbsp;
    <select name="operator">
      <option>+</option>
      <option>-</option>
      <option>*</option>
      <option>/</option>
    </select>&nbsp;&nbsp;
    操作数2<input type="text" name="sum2">&nbsp;&nbsp;
    <input type="submit" value="计算">
  </form>
  <%
      com.calculator.Calculator calculator = new com.calculator.Calculator();
      calculator.setNum1(request.getParameter("sum1"));
      calculator.setNum2(request.getParameter("sum2"));
      calculator.setOperator(request.getParameter("operator"));
      if (request.getParameter("sum1")!=null && request.getParameter("sum2")!=null) out.print("计算结果：" + request.getParameter("sum1") + request.getParameter("operator") + request.getParameter("sum2") + "=" + calculator.Result());
  %>
  </body>
</html>
