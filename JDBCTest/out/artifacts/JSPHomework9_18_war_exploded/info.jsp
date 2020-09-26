<%@ page import="java.util.Enumeration" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding="5px" cellspacing="0px" border="3px" style="font-size: 20px">
    <tr ><th style="background-color: grey">Name</th><th style="background-color: grey">Value</th></tr>
    <tr>
        <td>Know Java</td>
        <td><%=request.getParameter("Java")%></td>
    </tr>
    <tr>
        <td>Comment</td>
        <td><%=(request.getParameter("Comment"))%></td>
    </tr>
    <tr>
        <td>Know C++</td>
        <td><%=request.getParameter("C++")%></td>
    </tr>
    <tr>
        <td>Job</td>
        <td><%=request.getParameter("Job")%></td>
    </tr>
    <tr>
        <td>First Name</td>
        <td><%=(request.getParameter("First Name"))%></td>
    </tr>
    <tr>
        <td>Work</td>
        <td><%=request.getParameter("working")%></td>
    </tr>

    <tr>
        <td>Hidden Value</td>
        <td><%=request.getParameter("Hidden")%></td>
    </tr>
    <tr>
        <td>Rank</td>
        <td><%=request.getParameter("Middle")%></td>
    </tr>
    <tr>
        <td>Submit</td>
        <td><%="Submit"%></td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td><%=(request.getParameter("Last Name"))%></td>
    </tr>
</table>
</body>
</html>
