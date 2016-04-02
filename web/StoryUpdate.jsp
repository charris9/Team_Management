<%-- 
    Document   : StoryUpdate
    Created on : Mar 15, 2016, 2:27:20 PM
    Author     : zawiramin
--%>

<%@include file = "Story_DBconfig.jsp" %>
<%@page import = "java.sql.*"%>
<%@page import = "java.util.*"  %>
<%--<%@page import="java.util.Date"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Story Updating</title>
    </head>
    <%
        String storyID = request.getParameter("search_story_ID").toString();
        String Story_Title = null;
        String Story_Description = null;
        String Story_Owner = null;
        String Story_Priority = null;
        String Story_Status = null;
        String Date_Added = null;
        String Date_Updated = null;
        
        String Status1 = null;
        String Status2 = null;
        String Header = null;
        //String UserName = null;

        Story story = new Story();
        ResultSet StoryRetrieve = story.getStory();
        //ResultSet UserRetrieve = story.user.getUser();

        while (StoryRetrieve.next()) {
            if (StoryRetrieve.getString("Story_ID").toString().trim().equals(storyID.trim())) {
                Story_Title = StoryRetrieve.getString("Story_Title");
                Story_Owner = StoryRetrieve.getString("Story_Owner");
                Story_Description = StoryRetrieve.getString("Story_Description");
                Story_Priority = StoryRetrieve.getString("Story_Priority");
                Story_Status = StoryRetrieve.getString("Story_Status");
                Date_Added = StoryRetrieve.getString("Story_Date_Added");
                Date_Updated = StoryRetrieve.getString("Story_Updated");
            }
        }
    %>
    
    <%--Create Form--%>
    <form name="Story_Update" action="StoryUpdate.jsp" method="POST">
        <%
            if (request.getParameter("Update_Values") == null) {
                Header = Story_Title;
            } else {
                Header = new String("UPDATING");
            }
        %>
        
        <%--Call the header according to the specific name--%>
        <h1><%=Header%></h1>
        <%--Create table inside the form--%>
        
        <table border="1">
            <tbody>
                <tr>
                    <td>Story Title: </td>
                    <td><input type="text" name="UpdateStoryTitle" value="<%=Story_Title%>" /></td>
                </tr>
                <tr>
                    <td>Owner: </td>
                    <td><input type="text" name="StoryOwner" value="<%=Story_Owner%>"</td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td><input type="text" name="Description" value="<%=Story_Description%>"></td>
                </tr>
                <tr>
                    <td>Priority:  </td>
                    <td><input type="text" name="Priority" value="<%=Story_Priority%>"></td>
                </tr>
                <tr>
                    <td>Status:  </td>
                    <td>
                        <%=Story_Status%>
                        <select name="UpdateStoryStatus">
                            <%
                                if (Story_Status.equals("NOT DELIVER")) {
                                    Status1 = "NOT DELIVER";
                                    Status2 = "DELIVERED";
                                }
                                if (Story_Status.equals("DELIVERED")) {
                                    Status1 = "DELIVERED";
                                    Status2 = "NOT DELIVER";
                                }
                            %>
                            <option><%=Status1%></option>
                            <option><%=Status2%></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Date Created: </td>
                    <td><%= Date_Added %></td>
                </tr>
                <tr>
                    <td>Date Updated: </td>
                    <td><%=Date_Updated %></td>
                </tr>

            </tbody>
        </table>  
        <input type="hidden" value="<%=storyID %>" name="search_story_ID" />
        <input type="hidden" value="<%=Story_Title %>" name="DB_StoryTitle" />
        <input type="hidden" value="<%=Story_Owner %>" name="DB_StoryOwner" />
        <input type="hidden" value="<%=Story_Description %>" name="DB_StoryDescription" />
        <input type="hidden" value="<%=Story_Priority %>" name="DB_StoryPriority" />
        <input type="hidden" value="<%=Story_Status %>" name="DB_StoryStatus" />

        <input type="submit" value="Save" name="Update_Values" />
        <a href="Storylog_ViewDB.jsp">
            <input type="button" value="Back" />
        </a>
        <%
            if (request.getParameter("Update_Values") != null) {            
        %>
        <script type="text/javascript">
            document.forms["Story_Update"].submit();
        </script>
        <%
            }
        %>

    </form>
    <%
        if (request.getParameter("Update_Values") != null) {
            if (!request.getParameter("UpdateStoryStatus").equals(Story_Status)) {
                story.UpdateStoryStatus(request.getParameter("UpdateStoryStatus"), storyID);

            }
        }
%>            
</table> 
</html >
