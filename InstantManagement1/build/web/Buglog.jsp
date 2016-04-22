<%-- 
    Document   : Buglog
    Created on : Apr 12, 2016, 5:03:31 PM
    Author     : zawiramin
--%>

<%-- 
    Document   : Buglog
    Created on : Feb 14, 2016, 4:58:51 PM
    Author     : caseyharris

    This purpose of this class to to serve as a directory for the Bug log
--%>
<%@include file ="Story_DBconfig.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css" type="text/css">
        <% 
            String story_id = null;
            String Story_Title=null;
            String Story_Description=null;
            
            story_id=request.getParameter("search_story_id").toString();
            Story Temp_Story = new Story();
            
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
            
           Temp_Story.closeCONN(); 
        %>
        
        <title><%= Story_Title %>'s Buglog</title>
    </head>
    
    <body>
        <h1><%= Story_Title %>'s Buglog Selection</h1>
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <form name="Back" action="Story_Search.jsp" >
                            <input type="hidden" value="<%=Story_Title %>" name="search_title" />
                            <input type="submit" value="Back" name="View_Bug_Log" />
                        </form>
                    </td>
                    
                    <td>
                        <form name="CreateBug" action="Bug_Create_Insert.jsp" method="POST" >
                            <input type="hidden" value="<%=story_id %>" name="Story_ID" />
                            <input type="submit" value="Add Bug" name="Add Bug" />
                        </form>
                    </td>
                    
                    <td>
                        <form name="ViewBugs" action="Buglog_ViewDB.jsp" >
                            <input type="hidden" value="<%=story_id %>" name="search_story_id" />
                            <input type="submit" value="View Bugs" name="View_Bug_Log" />
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
        <%//Temp_Story.closeCONN();%> 
    </body>
</html>
