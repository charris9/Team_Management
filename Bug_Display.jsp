<%-- 
    Document   : display
    Created on : Feb 14, 2016, 12:05:43 PM
    Author     : caseyharris
--%>

<%@page import="java.sql.*"%>
<%@page import = "java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bug Created</title>
    </head>
    <body>
        <h1>Bug Created!</h1>
        
        <%!
         public  class Bug
         {
             String URL="jdbc:mysql://localhost/Testing";
             String USERNAME="root";
             String PASSWORD ="password";
             
             Connection connection = null;
             PreparedStatement selectBug = null;
             ResultSet resultSet = null;
             
             public Bug()
             {
                 try
                 {
                    connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    selectBug = connection.prepareCall("SELECT Bug_ID, Bug_title, Bug_Owner, Bug_Description, Bug_Priority, Bug_Date_Added From BugLog");
                }
                 catch(SQLException e)
                 {
                     e.printStackTrace();
                 }
             }
             
             public ResultSet getBug()
             {
                 try
                 {
                     resultSet = selectBug.executeQuery();
                 }
                 catch(SQLException e)
                 {
                         e.printStackTrace();
                 }
                 return resultSet;
             }
        }
         %>
        
      
        <%
         Bug bug = new Bug();
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
                        <% //if (Status==null)
                        //{Status="Open";}%>
                                
                       <td><%= bugs.getString("Bug_ID") %></td>
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
                   
   </body>
</html>
