<%-- 
    Document   : Buglog_ViewDB
    Created on : Apr 12, 2016, 5:03:50 PM
    Author     : zawiramin
--%>

<%-- 
    Document   : DBTest
    Created on : Feb 16, 2016, 10:26:51 AM
    Author     : caseyharris
--%>
<%@include file = "Bug_DBconfig.jsp"%>
<%@page import="java.sql.*"%>
<% //Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Bugs</title>
    </head>
    
    <% 
        String story_id =request.getParameter("search_story_id").toString();
        
        String Story_Title=null;
        String Story_Description=null;
        
        Story Temp_Story = new Story();
        Bug bug = new Bug();
        
        ResultSet bugs=bug.getBug();
        ResultSet storytitleretrieve=Temp_Story.getStory();

        //iterates through the DB of all the bug titles
        while(storytitleretrieve.next())
        {
            //if bug id match the search id from bug_search.jsp retreive all that bugs data
            if(storytitleretrieve.getString("Story_ID").toString().trim().equals(story_id.trim()))
            {
                Story_Title = storytitleretrieve.getString("Story_Title");
                Story_Description = storytitleretrieve.getString("Story_Description");
            }
        }
    %>
    
    <body>
        <h1><%= Story_Title %>'s + Bugs From Data Base</h1>
        <table border="0">
            <thead>
                <tr>
                    <td>
                        <form name="CreateBug2" action="Buglog.jsp" method="POST" >
                            <input type="hidden" value="<%=story_id%>" name="search_story_id"/>
                            <input type="submit" value="Cancel" name="search_story_id2" />
                        </form>  
                        
                    </td>
                    
                    <td>
                        <form name="CreateBug" action="Bug_Create_Insert.jsp" method="POST" >
                            <input type="hidden" value="<%=story_id %>" name="Story_ID" />
                            <input type="submit" value="Add Bug" name="Add Bug" />
                        </form>
                    </td>
                </tr>
            </thead>
        </table>
        
        <table border="1">
            <tbody>
                <tr>
                    <td>Title</td>
                    <td>Priority</td>
                    <td>Date Created</td>
                    <td>Status</td>
                </tr>
               
                <% 
                    // need to have match story id
                    while (bugs.next()) 
                    {
                        bugs.getString("Story_ID");
                        if(bugs.getString("Story_ID").trim().equals(story_id.trim()))
                        {
                %>
                <tr>
                    <td>
                        <form name="Find_Bug" action="Bug_Search.jsp" method="POST">                        
                            <input type="submit" style="height:25px; width:500px" value="<%= bugs.getString("Bug_Title") %> " name="search_title"/>
                        </form>                        
                    </td>
                    <td><%= bugs.getString("Bug_Priority") %></td>
                    <td><%= bugs.getString("Bug_Date_Added") %></td>                    
                    <td><%= bugs.getString("Bug_Status") %></td>
                </tr>
                <%     
                        }
                    }
                %>
            </tbody>
        </table>
    <%
        bug.closeCONN(); 
        Temp_Story.closeCONN();
        
    %>
    </body>
</html>
