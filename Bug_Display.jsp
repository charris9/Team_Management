<%-- 
    Document   : display
    Created on : Feb 14, 2016, 12:05:43 PM
    Author     : caseyharris
--%>
<%@include file ="Bug_DBconfig.jsp"%>
<%@page import="java.sql.*"%>
<%@page import = "java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>Bug Created</title>
    </head>
    <body>
        <div class="main-window">
        <h1>Bug Created!</h1>
        <% Bug bug = new Bug();
         ResultSet bugs=bug.getBug();%>
         <% if (bugs.last()) { %>
       <table border="1">
                
                <tbody>
                    <tr>
                        <td>Bug Title: </td>
                        <td><%= bugs.getString("Bug_Title") %></td>
                    </tr>
                    
                    <tr>
                        <td>Owner: </td>
                        <td><%= bugs.getString("Bug_Owner") %></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><%= bugs.getString("Bug_Description") %></td>
                    </tr>
                    
                    <tr>
                        <td>Priority:</td>
                        <td><%= bugs.getString("Bug_Priority") %></td>
                    </tr>
                    <tr>
                        <td>Current Status:</td>
                        <td><%= bugs.getString("Bug_Status") %></td>
                    </tr>
                    <tr>
                        <td>Date Created:</td>
                        <td><%= bugs.getString("Bug_Date_Added") %></td>
                    </tr>
                    
                </tbody>
            </table>
        
         <% } %>   
          
                    <a href="Bug_Create_Insert.jsp">
                    <input type="button" value="Add Another Bug"/>
                    </a>
         
                    <a href="Buglog.jsp">
                    <input type="button" value="Continue"/>
                    </a>
                  </div>      
   </body>
</html>
