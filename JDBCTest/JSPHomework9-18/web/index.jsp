
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="info.jsp" method="get" >
    <input name="Last Name" width="250px" height="50px" type="text">Last Name<br><br>
    <input name="First Name" width="250px" height="50px" type="text">First Name<br><br>
    <input  type="checkbox" name="Java" > Know Java &nbsp;&nbsp;&nbsp;
    <input  type="checkbox" name="C++" > Know C++ <br><br>
    <input type="radio" name="working" >Working <br><br>
    <select size="3" name="Job">
      <option value="Programmer"  selected>Programmer</option>
      <option value="Documentation" >Documentation</option>
      <option value="Other" >Other</option>
    </select> Job&nbsp;&nbsp;&nbsp;
    <select name="Middle">
      <option  value="Middle">Middle</option>
    </select>Rank<br><br>
    <textarea style="width: 300px;height: 80px" name="Comment"></textarea><br><br>
    <input type="hidden" value="Hidden Value" name="Hidden">
    <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;
    <input type="reset" value="重置">

  </form>

  </body>
</html>
