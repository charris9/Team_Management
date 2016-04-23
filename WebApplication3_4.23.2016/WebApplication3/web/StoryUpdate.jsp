<%-- 
    Document   : StoryUpdate
    Created on : Mar 15, 2016, 2:27:20 PM
    Author     : zawiramin

    Modified From:
    Document   : Bug_Edit
    Created on : Mar 8, 2016, 10:52:25 AM
    Author     : caseyharris

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
        String Story_Location = null;
        String Story_Unresolved_BugNum = null;
        
        String Status1 = null;
        String Status2 = null;
        String Status3 = null;
        
        String Priority1=null;
        String Priority2=null;
        String Priority3=null;
        
        String Header = null;
        String UserName = null;

        Story story = new Story();
        User user=new User();
        ResultSet StoryRetrieve = story.getStory();
        ResultSet Userretrieve = user.getUser();

        while (StoryRetrieve.next()) {
            if (StoryRetrieve.getString("Story_ID").toString().trim().equals(storyID.trim())) 
            {
                Story_Title = StoryRetrieve.getString("Story_Title");
                Story_Owner = StoryRetrieve.getString("Story_Owner");
                Story_Description = StoryRetrieve.getString("Story_Description");
                Story_Priority = StoryRetrieve.getString("Story_Priority");
                Story_Status = StoryRetrieve.getString("Story_Status");
                Date_Added = StoryRetrieve.getString("Story_Date_Added");
                Date_Updated = StoryRetrieve.getString("Story_Updated");
                Story_Location = StoryRetrieve.getString("Story_Location");
                Story_Unresolved_BugNum=StoryRetrieve.getString("Story_Unresolved_BugNum");
                
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
                    <td>
                        <input type="text" name="UpdateStoryTitle" value="<%=Story_Title%>" />
                    </td>
                </tr>
                
                <tr>
                    <td>Owner: </td>
                    <td>
                        <%=Story_Owner %>
                        <select name="UpdateStoryOwner">
                            <option><%=Story_Owner %></option>    
                            <%
                                // pulls all users from the User table in the DB
                                // dynamically populates dropdown menu
                                while (Userretrieve.next()) 
                                {
                                    if(!Story_Owner.equals(Userretrieve.getString("User_Name")))
                                    {   
                                        UserName= Userretrieve.getString("User_Name"); 
                            %> 
                                        <option><%=UserName %></option>
                            <%      }
                                }
                             %> 
                         </select>
                    </td>
                </tr>
                
                
                <tr>
                    <td>Description: </td>
                    <td><input type="text" name="UpdateStoryDescription" value="<%=Story_Description%>"></td>
                </tr>
                
                <tr>
                    <td>Priority:  </td>
                    
                    <td>
                        <%=Story_Priority%>
                        <select name="UpdateStoryPriority">
                            <%
                                if(Story_Priority.equals("Easy"))
                                {
                                    Priority1="Low";
                                    Priority2="Medium";
                                    Priority3="Hard";
                                }
                                if(Story_Priority.equals("Low"))
                                {
                                    Priority1="Low";
                                    Priority2="Medium";
                                    Priority3="Hard";
                                }
                                if(Story_Priority.equals(null))
                                {
                                    Priority1="Low";
                                    Priority2="Medium";
                                    Priority3="Hard";
                                }
                                if(Story_Priority.equals("Medium"))
                                {
                                    Priority1="Medium";
                                    Priority2="Low"; 
                                    Priority3="Hard";
                                }
                                if(Story_Priority.equals("Hard"))
                                { 
                                    Priority1="Hard";
                                    Priority2="Low";
                                    Priority3="Medium";
                                }
                                %>
                            <option><%=Priority1%> </option>
                            <option><%=Priority2%></option> 
                            <option><%=Priority3%></option> 
                        </select>
                        
                    </td>
                </tr>
                
                <tr>
                    <td>Status:  </td>
                    <td>
                        <%=Story_Status%>
                        <select name="UpdateStoryStatus">
                            <%
                                
                                
                                
                                if (Story_Status.equals("NOT DELIVER")) 
                                {
                                    Status1 = "NOT DELIVER";
                                    Status2 = "DELIVERED";
                                    if (!Story_Unresolved_BugNum.equals("0"))
                                    {
                                        Status2= "RESOLVE BUGS";
                                    }
                                }
                                if (Story_Status.equals("DELIVERED")) 
                                {
                                    Status1 = "DELIVERED";
                                    Status2 = "NOT DELIVER";
                                }
                                if (Story_Status.equals("RESOLVE BUGS")) 
                                {
                                    Status1 = "RESOLVE BUGS";
                                    Status2 = "NOT DELIVER";
                                    if (!Story_Unresolved_BugNum.equals("0"))
                                    {
                                        Status2= "Resolve Bugs";
                                    }
                                }
                                if (Story_Status.equals(null)) 
                                {
                                    Status1 = "NOT DELIVER";
                                    Status2 = "DELIVERED";
                                    if (!Story_Unresolved_BugNum.equals("0"))
                                    {
                                        Status2= "Resolve Bugs";
                                    }
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
                
                <tr>
                    <td>Location:  </td>
                    <td>
                        <%=Story_Location%>
                        <select name="UpdateStoryLocation">
                            <%
                                if (Story_Location==null) {
                                    Status1 = "ICEBOX";
                                    Status2 = "CURRENT";
                                    Status3 = "DONE";
                                }
                                else
                                {
                                if (Story_Location.equals("ICEBOX")) {
                                    Status1 = "ICEBOX";
                                    Status2 = "CURRENT";
                                    Status3 = "DONE";
                                }
                                if (Story_Location.equals("CURRENT")) {
                                    Status1 = "CURRENT";
                                    Status2 = "DONE";
                                    Status3 = "ICEBOX";
                                }
                                if (Story_Location.equals("DONE")) {
                                    Status1 = "DONE";
                                    Status2 = "ICEBOX";
                                    Status3 = "CURRENT";
                                }
                                }  
                            %>
                            <option><%=Status1%></option>
                            <option><%=Status2%></option>
                            <option><%=Status3%></option>
                        </select>
                    </td>
                </tr>
            </tbody>
        </table>  
                        
        <input type="hidden" value="<%=storyID %>" name="search_story_ID" />
        <input type="hidden" value="<%=Story_Title %>" name="DB_StoryTitle" />
        <input type="hidden" value="<%=Story_Owner %>" name="DB_StoryOwner" />
        <input type="hidden" value="<%=Story_Description %>" name="DB_StoryDescription" />
        <input type="hidden" value="<%=Story_Priority %>" name="DB_StoryPriority" />
        <input type="hidden" value="<%=Story_Status %>" name="DB_StoryStatus" />
        <input type="hidden" value="<%=Story_Location %>" name="DB_StoryLocation" />
        
        <input type="submit" value="Save" name="Update_Values" />
        
        
        
        <a href="Storylog_ViewDB.jsp">
            <input type="button" value="Story List" />
        </a>
        
        <a href="Story_Interface.jsp">
                            <input type="button" value="Main Page" />
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
            
           if (!request.getParameter("UpdateStoryTitle").equals(Story_Title)) {
                
                
                story.UpdateStoryTitle(request.getParameter("UpdateStoryTitle"), storyID);

           }
            
            
            
            
            if (!request.getParameter("UpdateStoryStatus").equals(Story_Status)) {
                
                story.UpdateStoryStatus(request.getParameter("UpdateStoryStatus"), storyID);
                

            }
            
            
            if (!request.getParameter("UpdateStoryDescription").equals(Story_Description))
            {
              story.UpdateStoryDescription(request.getParameter("UpdateStoryDescription"), storyID);
            }
            
            
            
            if (!request.getParameter("UpdateStoryOwner").equals(Story_Owner))
            {
                story.UpdateStoryOwner(request.getParameter("UpdateStoryOwner"), storyID);
            }
            
            
            if (!request.getParameter("UpdateStoryPriority").equals(Story_Priority))
            {
                story.UpdateStoryPriority(request.getParameter("UpdateStoryPriority"), storyID);
            }
            
            if (!request.getParameter("UpdateStoryLocation").equals(Story_Location))
            {
                story.UpdateStoryLocation(request.getParameter("UpdateStoryLocation"), storyID);
            }
            
            
        }
    %>            


<%story.closeCONN();%> 
</html >
