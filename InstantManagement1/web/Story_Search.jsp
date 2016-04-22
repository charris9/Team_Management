<%-- 
    Document   : Story_Search
    Created on : Apr 12, 2016, 5:05:38 PM
    Author     : zawiramin
--%>

<%-- 
    Document   : Story_Search
    Created on : Mar 6, 2016, 1:53:28 PM
    Author     : zawiramin

    Modified From:
    Document   : Get_Bug
    Created on : Feb 23, 2016, 6:48:50 PM
    Author     : caseyharris
--%>

<%@include file = "Story_DBconfig.jsp" %>
<%@page import = "java.sql.*"%>
<%@page import = "java.util.*"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Searching DB</title>
    </head>
    
    <body>
        <%
            String storyTitle = null;
            String storyID = null;
            
            storyTitle=request.getParameter("search_title").toString();
            
            
            
            Story story = new Story();
            ResultSet stories = story.getStory();

            //iterate till end of DB
            while (stories.next()) {
                //if story title matches the search story title retrieve all info
                if (stories.getString("Story_Title").toString().trim().equals(storyTitle.trim())) {
        %>
        <h1>Story Found!</h1>
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
                    <td>
                        <%= stories.getString("Story_Status")%>
                    </td>
                </tr>
                <tr>
                    <td>Location: </td>
                    <td>
                        <%= stories.getString("Story_Location")%>
                    </td>
                </tr>
            
            
                <td>
                    <form name="Story_Edit" action="StoryUpdate.jsp" method="POST">
                    <input type="submit"
                           value="Update Story" />
                    <input type="hidden"
                           value="<%=stories.getString("Story_ID")%>"
                           name="search_story_ID" />
                    </form>
                </td>
            
            
            
                <td>
                    <form name="Story_Cred" action="Buglog.jsp" method="POST">
                    <input type="submit" 
                           value="View Buglog "
                           name="search_story_id_submit"  />
                                
                    <input type="hidden" 
                           value="<%=  stories.getString("Story_ID") %> "
                           name="search_story_id"  />                                                    
                    </form>               
                </td>                
        </tbody>
    </table>
                           
    <table border="0">     
        <tbody>
            <td>            
                <a href="Storylog_ViewDB.jsp">
                    <input type="button" value="Story List" />
                </a>
                
            </td>
            <td>
                <a href="Storylog.jsp">
                    <input type="button" value="Main Page" />            
                </a>
                
            </td>
        </tbody>
    </table>
    <%}
}%>



<%story.closeCONN();%> 
</body>
</html>
