<%-- 
    Document   : Bug_Conversation
    Created on : Apr 12, 2016, 5:01:47 PM
    Author     : zawiramin
--%>

<%--
    Document   : Bug_Conversation
    Created on : Mar 5, 2016, 7:20:27 AM


--%>
<%@include file ="Bug_DBconfig.jsp"%>

<%//@ page import="test.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%
            // for debug switch bugid = "1";//
          
            // search bug id is posted from the bug_search.jsp
            String bugid =request.getParameter("search_bug_id").toString();
             
            //Initializing all variables
            String Bug_Name=null;
            String Bug_Description=null;
            String UserName=null;
            String StoryID=null;
            
            
            Bug bug = new Bug();
           
            ResultSet Userretrieve=bug.user.getUser();
            ResultSet bugtitleretrieve=bug.getBug();
            
            //iterates through the DB of all the bug titles
            while(bugtitleretrieve.next())
            {
                //if bug id match the search id from bug_search.jsp retreive all that bugs data
                if(bugtitleretrieve.getString("Bug_ID").toString().trim().equals(bugid.trim()))
                {
                    Bug_Name = bugtitleretrieve.getString("Bug_Title");
                    Bug_Description = bugtitleretrieve.getString("Bug_Description");
                    StoryID = bugtitleretrieve.getString("Story_ID");
                }
            }
        %>
        <title>Bug Conversation</title>
    </head>
    
    <body> 
        <%
            
            int results=0; 
            ResultSet bugsconvo=bug.getBugConvo();
            
            String bugconvo_comment=null;
            String bugconvo_owner = null; 
            
            // if submit name add for form "add_comment" is not null
            if(request.getParameter("add")!=null)
            {
               // create new bug conversation 
                Integer addbug_id= 0;
                Date date =new Date();
                Timestamp bugconvo_timestamp = new Timestamp(date.getTime());
                
                // occurs only if comment field is not null
                if(request.getParameter("comment").trim() != null)
                {   
                    bugconvo_comment = request.getParameter("comment");
                }
                // occurs only if owner field is not null
                if(request.getParameter("owner").trim() != null)
                {
                    bugconvo_owner = request.getParameter("owner");
                }
                
                // conversion from string to int
                addbug_id=Integer.parseInt(bugid);
                
                if(!bugconvo_comment.equals(bugconvo_owner))// will need to change this parameter
                {
                
                results=bug.setBugConvo(addbug_id, bugconvo_comment, bugconvo_owner, bugconvo_timestamp);
                }
            }
        %>
        
        <h1><%=Bug_Name %>'s Conversation</h1>
        <h2>Description</h2>
        <h3><%=Bug_Description %></h3>
        
        
        <form name="Reload" action="Bug_Conversation">
            <% 
                while(bugsconvo.next())     
                {// if bug tilte matches the search bug title retrieve all information
                    if (bugsconvo.getString("Bug_ID").toString().trim().equals(bugid.trim()))
                    {
            %>
                        <table border="0">
                            <tbody>
                                <tr>
                                    <td><%= bugsconvo.getString("Bug_Conversation_Comment") %></td>
                                    <td><%= bugsconvo.getString("Bug_Conversation_Owner") %></td>
                                    <td><%= bugsconvo.getString("Bug_Conversation_Time_Added") %></td>
                                </tr>
                            </tbody>
                        </table>
            <%
                    }
                }//}
            %>
        </form>
        
        <form name="add_comment" action="Bug_Conversation.jsp" method="POST">
            <input type="text" name="comment"/>
            <select name="owner">
                <option></option>
                <%
                   while (Userretrieve.next())
                   {
                       UserName= Userretrieve.getString("User_Name"); 
                 %> 
                       <option><%=UserName %></option>
                <%
                    }
                %> 
            </select>
            <input type="hidden" name="hidden" value="<%= results%>" />
            <input type="hidden" name="search_bug_id" value=<%= bugid%> />
            <input type="submit" value="SEND" name="add" />
            
            <%
                if(request.getParameter("add")!=null)
                { 
            %>
                <script type="text/javascript">
                    //might have to add closes in heree
                    document.forms["add_comment"].submit();
                    
                </script> 
            <%    
                }
            %>
        </form>
        
        <form name="CreateBug3" action="Buglog_ViewDB.jsp" method="POST" >
          <input type="hidden" value="<%=StoryID%>" name="search_story_id"/>
          <input type="submit" value="Back" name="search_story_id2" />
                        
        </form>   
    
        
        
    
    </body>
    
     <%
        bug.user.closeCONN(); 
        bug.closeCONN();%> 
</html>

