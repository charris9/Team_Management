<%-- 
    Document   : Story_Display
    Created on : Mar 6, 2016, 1:55:04 PM
    Author     : zawiramin
--%>

<%@include file = "Story_DBconfig.jsp" %>
<%@page import = "java.sql.*"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>Story Added</title>
    </head>
    <body>
        <div class="main-window">
            <h1>Story Added!</h1>
            <% Story story = new Story();
                ResultSet stories = story.getStory();
                if (stories.last()) {%>

            <table border="1">
                <tbody>
                    <tr>
                        <td>Story Title: </td>
                        <td><%= stories.getString("Story_Title")%></td>
                    </tr>
                    <tr>
                        <td>Owner: </td>
                        <td><%= stories.getString("Story_Owner")%></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><%= stories.getString("Story_Description")%></td>
                    </tr>
                    <tr>
                        <td>Priority: </td>
                        <td><%= stories.getString("Story_Priority")%></td>
                    </tr>
                    <tr>
                        <td>Date Created </td>
                        <td><%= stories.getString("Story_Date_Added")%></td>
                    </tr>
                    <tr>
                        <td>Status: </td>
                        <td><%= stories.getString("Story_Status")%></td>
                    </tr>
                </tbody>
            </table>


            <%}%>
            
            <table border="0">
                <tbody>
                    <td>
                        <a href="Story_Create_Insert.jsp">
                            <input type="button" value="Add More Story" />
                        </a>
                    </td>
                    <td>
                        <a href="Storylog.jsp">
                            <input type="button" value="Main Page" />
                        </a>
                    </td>
                </tbody>
            </table>
        </div>

    </body>
</html>
