<%-- 
    Document   : Story_Create_Insert
    Created on : Apr 12, 2016, 5:04:56 PM
    Author     : zawiramin
--%>

<%-- 
    Document   : Story_Create_Insert
    Created on : Mar 6, 2016, 1:57:35 PM
    Author     : zawiramin


    Modified from 
    Document   : Bug_Create_Insert
    Created on : Feb 14, 2016, 4:58:51 PM
    Author     : caseyharris
--%>
<%@include file = "Story_DBconfig.jsp" %>
<%@page import = "java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserting Story</title>
    </head>
    
    <div class="main-window">    
        <body onload="displayResults()">

        <h1>Inserting Story Into A DB</h1>

            <%
                int results = 0;
                String story_title = new String();
                String story_owner = new String();
                String story_description = new String();
                String story_priority = new String();
                String story_status = new String();
                String story_location = new String();
                String story_BugNum = new String();
                String unresolved_BugNum = new String();

                Story addStory = new Story();


                if (request.getParameter("Submit") != null) {                                

                    if (request.getParameter("title") != null) {
                        story_title = request.getParameter("title");
                    }
                    if (request.getParameter("owner") != null) {
                        story_owner = request.getParameter("owner");
                    }
                    if (request.getParameter("description") != null) {
                        story_description = request.getParameter("description");
                    }
                    if (request.getParameter("priority") != null) {
                        story_priority = request.getParameter("priority");
                    }
                    if (request.getParameter("status") != null) {
                        story_status = request.getParameter("status");
                    }
                    if (request.getParameter("location") != null) {
                        story_location = request.getParameter("location");
                    }
                    if (request.getParameter("storyBugNum") != null) {
                        story_BugNum = request.getParameter("storyBugNum");
                    }
                    if (request.getParameter("unresolvedBugNum") != null) {
                        unresolved_BugNum = request.getParameter("unresolvedBugNum");
                    }
                    
                    Date date = new Date();
                    Timestamp timeStamp = new Timestamp(date.getTime());

                    story_status = "NOT DELIVER";
                    story_location = "ICEBOX";

                    results = addStory.setStories(story_title, story_owner, story_description, story_priority, timeStamp, story_status, story_location, story_BugNum, unresolved_BugNum);

                }
            %> 



            <form name="myForm" action="Story_Create_Insert.jsp" method="POST">

                <table border="1">
                    <tbody>
                        <tr>
                            <td>Story Title: </td>
                            <td><input type="text" name="title" placeholder="Story title" value="" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Owner : </td>
                            <td><input type="text" name="owner" placeholder="Insert Owner's Name..." value="" size="50" /></td>                        
                        </tr>                    
                        <tr>                    
                            <td>Description : </td>                        
                            <td>                        
                                <input type="text" name="description" placeholder="Describe your story in details..." value="" size="50" >                            
                                
                            </td>                        
                        </tr>                    
                        <tr>                    
                            <td>Select Priority</td>                        
                            <td>
                                <select name="priority">                        
                                    <option>Select Priority</option>                                
                                    <option>Low</option>                                
                                    <option>Medium</option>                                
                                    <option>Hard</option>                                
                                </select>                            
                            </td>                        
                        </tr>                    
                    </tbody>                
                </table>          
                        
                        
                <table border="0">                    
                    <tbody>
                            <tr>
                                <td>
                                    <a href="Storylog.jsp">
                                        <input type="button" value="Back" name="Back" />
                                    </a> 
                                </td>
                                <td><input type="reset" value="Clear" name="Clear" /></td>
                                <td><input type="submit" value="Submit" name="Submit" /></td>
                                <td><input type="hidden" name="hidden" value="<%= results%>" /></td>
                            </tr>
                        </tbody>             
                    <table/>
            </form>
                                    
            <script LANGUAGE = "JavaScript">
                function displayResults() {
                    if (document.myForm.hidden.value == 1) {
                        location = 'Story_Display.jsp';
                    }
                }
            </script>                                                              
    <%addStory.closeCONN();%>
    </div>
    </html>
    <%--<%addStory.closeCONN();%>--%>