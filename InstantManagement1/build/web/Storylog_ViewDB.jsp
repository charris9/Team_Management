<%-- 
    Document   : Storylog_ViewDB
    Created on : Apr 12, 2016, 5:06:18 PM
    Author     : zawiramin
--%>

<%-- 
    Document   : Storylog_ViewDB
    Created on : Mar 8, 2016, 2:25:17 AM
    Author     : zawiramin

    Modified From:
    Document   : Buglog_ViewDB
    Created on : Feb 16, 2016, 10:26:51 AM
    Author     : caseyharris
--%>

<%@include file = "Story_DBconfig.jsp" %>
<%@page import = "java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Stories</title>
    </head>
    <body>
        <h1>List of Stories (Icebox)</h1>
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <form name="CreateStory" action="Story_Create_Insert.jsp">
                            <input type="submit" value="Add Story" name="Add Story" />
                        </form>
                    </td>
                    <td>
                        <form name="Storylog" action="Storylog.jsp">
                            <input type="submit" value="Back" name="Back" />
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>

        <%
            Story story = new Story();
            ResultSet stories = story.getStory(); %>

        <table border="1">
            
                <tr>
                    <td>Story <br />Title</td>
                    <td>Story <br />Owner</td>    
                    <td>Story <br />Priority</td>
                    <td>Story <br />Date Created</td>                    
                    <td>Story <br />Status</td>
                    <td>Story <br />Location</td> 
                    <td>Total Bug<br /> Number</td> 
                    <td>Unresolved<br /> Bugs</td> 
                    
                </tr>

                <% while (stories.next()) {%>
                <tr>                    
                    <td>
                        <form name="Find_Story" action="Story_Search.jsp" method="POST">
                        <input 
                        type="submit"
                        style="height: 10px; width: 200px"
                        value="<%= stories.getString("Story_Title")%>"
                        name="search_title" />
                        </form>
                    </td>                    
                    <td><%= stories.getString("Story_Owner")%></td>
                    <td><%= stories.getString("Story_Priority")%></td>
                    <td><%= stories.getString("Story_Date_Added")%></td>
                    <td><%= stories.getString("Story_Status")%></td>  
                    <td><%= stories.getString("Story_Location")%></td>
                    <td><%= stories.getString("Story_BugNum")%></td> 
                    <td><%= stories.getString("Story_Unresolved_BugNum")%></td> 
                </tr>
               <%
                }
               %>
               
            
        </table>
                <table border="0">
                    <tbody>
                        <tr>
                            <td>
                                <form name="CreateStory" action="Story_Create_Insert.jsp">
                                    <input type="submit" value="Add Story" name="Add Story" />
                                </form>
                            </td>
                            <td>
                                <form name="Storylog" action="Storylog.jsp">
                                    <input type="submit" value="Back" name="Back" />
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>  
        
    
    
    <%story.closeCONN();%> 
    
</html>
