<%-- 
    Document   : Get_Bug
    Created on : Feb 23, 2016, 6:48:50 PM
    Author     : caseyharris
--%>
<%@include file ="Bug_DBconfig.jsp"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Searching DB</title>
    </head>
    <body>
        
        <%String bugTitle = request.getParameter("CGHJ").toString();
         Bug bug = new Bug();
         ResultSet bugs=bug.getBug();
        
   while(bugs.next())     
   {
       if (bugs.getString("Bug_Title").toString().trim().equals(bugTitle.trim())) { %>
         <h1>Bug Found!</h1>
         
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
        
         <% }}%>   
          
                    <a href="Bug_Create_Insert.jsp">
                    <input type="button" value="Add Another Bug"/>
                    </a>
         
                    <a href="Buglog_ViewDB.jsp">
                    <input type="button" value="Back"/>
                    </a>
                      
</body>
</html>
