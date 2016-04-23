<%-- 
    Document   : login
    Created on : Feb 24, 2016, 11:22:04 PM
    Author     : Amadeus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Cookie[] cookies=request.getCookies();
    String name="", pass="";
    
    
if (cookies != null) {
     for (Cookie cookie : cookies) {
       if (cookie.getName().equals("cookieLoginUser")) {
           name=cookie.getValue();
           
       }
           
           else if(cookie.getName().equals("cookieLoginPassword")){
            pass=cookie.getValue();
        }
          
       }
    }
%>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css" />
        <title>Login</title>
        
        <script type="text/javascript">
    	function login(form){
        	if(form.username.value === ""){
        		alert("Username can't be null！");
        		return false;
        	}
        	if(form.password.value ===""){
        		alert("Password can't be null！");
        		return false;
        	}
    	}
        </script>
        
        
    </head>
    <body>
        <div class ="login-card">
            <h1>Login in here</h1>
            <form action="LoginServlet" method="POST"onSubmit="return login(this);">
                <input type="text" value="<%= name %>" placeholder="Username"name="username"><br>
                <input type="password" value="<%= pass %>" placeholder="Password"name="password"><br>
                <input type="checkbox" name="RememberMe" value="ON" /> Remember me
                <input type="submit" value="Login"> 
            </form>
        </div>
<!--         <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>-->
    </body>
</html>
