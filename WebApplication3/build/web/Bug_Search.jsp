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
        <%
            String bugTitle = request.getParameter("search_title").toString();
            String bugid=null;
            String StoryID=null;
            
            Bug bug = new Bug();
         
            ResultSet bugs=bug.getBug();
            // iterating until end of database     
            while(bugs.next())
            {
                // if bug tilte matches the search bug title retrieve all information
                if (bugs.getString("Bug_Title").toString().trim().equals(bugTitle.trim())) 
                {
                
        %>
        
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
                                <%StoryID=bugs.getString("Story_ID");%>
                            </tr>

                            <form name="Bug_Convo" action="Bug_Conversation.jsp" method="POST">
                                <td>
                                    <input 
                                        type="submit" 
                                        value="View Conversations "
                                        name="search_bug_id_submit"  />

                                    <input 
                                        type="hidden" 
                                        value="<%= bugs.getString("Bug_ID") %> "
                                        name="search_bug_id"  />
                                </td>
                            </form>

                            <form name="Bug_Edit" action="Bug_Edit.jsp" method="POST">
                                <td>
                                    <input 
                                        type="submit" 
                                        value="Edit Bug"
                                        name="search_bug_edit_submit"  />

                                    <input 
                                        type="hidden"
                                        value="<%= bugs.getString("Bug_ID") %> "
                                        name="search_bug_ID"  />
                                </td>
                            </form>
                                        
                            
                            
                        </tbody>
                    </table>
        
           <%
                }
            }%>
            
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <form name="CreateBug3" action="Buglog_ViewDB.jsp" method="POST" >
                            <input type="hidden" value="<%=StoryID%>" name="search_story_id"/>
                            <input type="submit" value="Back" name="search_story_id2" />
                        </form>
                    </td>
                    
                    
                    <td>
                        <form name="CreateBug" action="Bug_Create_Insert.jsp" method="POST" >
                            <input
                                type="hidden"
                                value="<%=StoryID%>"
                                name="Story_ID"/>
                            <input
                                type="submit"
                                value="Add Another Bug"
                                name="Add Bug" />
                        </form>   
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
    <%bug.closeCONN();%> 
</html>
