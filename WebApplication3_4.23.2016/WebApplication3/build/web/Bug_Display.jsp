<%-- 
    Document   : display
    Created on : Feb 14, 2016, 12:05:43 PM
    Author     : caseyharris

    The purpose of this JSP is to display all the information of the last bug
    in the database. It serves as a check standard after the user has enter a 
    new bug into the database.
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
        
        <%
            String StoryID=null;   
            Bug bug = new Bug();
            ResultSet bugs=bug.getBug();
            // when the database is at its last entry return that bug.
            if (bugs.last()) 
            {  
        %>
        
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
                    
                        <%StoryID=bugs.getString("Story_ID");%>
                    </tbody>
                </table>
        <%  } 
        %>   
           
            <table>   
                <tbody>
                    <tr>
                        <td>
                            <form name="CreateBug" action="Bug_Create_Insert.jsp" method="POST" >
                                <input type="hidden" value="<%=StoryID%>" name="Story_ID"/>
                                <input type="submit" value="Add Another Bug" name="Add Bug" />
                            </form>   
                        </td>
           
                        <td>
                            <form name="CreateBug2" action="Buglog_ViewDB.jsp" method="POST" >
                                <input type="hidden" value="<%=StoryID%>" name="search_story_id"/>
                                <input type="submit" value="Continue" name="search_story_id2" />
                            </form>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
    <%bug.closeCONN();%> 
</html>
