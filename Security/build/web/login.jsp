<%-- 
    Document   : login
    Created on : Feb 24, 2016, 11:22:04 PM
    Author     : Amadeus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css" />
        <title>Login</title>
        
    </head>
    <body>
        <div class ="login-card">
            <h1>Login in here</h1>
            <form action="j_security_check" method="POST">
                <input type="text" value="" placeholder="Username"name="j_username"><br>
                <input type="password" value="" placeholder="Password"name="j_password">
                <input type="submit" value="Login">
            </form>
        </div>
<!--         <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>-->
    </body>
</html>
