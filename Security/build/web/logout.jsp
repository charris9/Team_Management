<%-- 
    Document   : logout
    Created on : Feb 27, 2016, 9:16:06 PM
    Author     : Amadeus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <h1>You have logged out!</h1>
        <p> <a href="index.jsp">Go to top page</a></p>
        
    </body>
</html>
<%
    session.invalidate();
%>