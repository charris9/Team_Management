<%-- 
    Document   : Get_Bug
    Created on : Feb 23, 2016, 6:48:50 PM
    Author     : caseyharris

    The purpose of this JSP is to search the database for all the bug titles 
    that match the one the user is looking for. It will then return each bug and
    all their information.

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
        
        <%String bugTitle = request.getParameter("search_title").toString();
         String bugid=null;
         Bug bug = new Bug();
         ResultSet bugs=bug.getBug();
   // iterating until end of database     
   while(bugs.next())     
   {
       // if bug tilte matches the search bug title retrieve all information
       if (bugs.getString("Bug_Title").toString().trim().equals(bugTitle.trim())) { %>
         <h1>Bug Found!</h1>
         <%//edt feature%>
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
                    
                    <form name="Bug_Convo" action="Bug_Conversation.jsp" method="POST">
                            <td>
                                <input type="submit" 
                            style="height:25px; width:500px" 
                            <%//value="View Conversation"%>
                            
                            value="<%= bugs.getString("Bug_ID") %> "
                            name="search_bug_id"  />
                            </td>
                        </form>
                    
                    
                    
                </tbody>
            </table>
                    
                    
        <%//edt feature, view conversatiion%>
         <% }}%>   
          
                    <a href="Bug_Create_Insert.jsp">
                    <input type="button" value="Add Another Bug"/>
                    </a>
         
                    <a href="Buglog_ViewDB.jsp">
                    <input type="button" value="Back"/>
                    </a>
                    
                      
</body>
</html>
