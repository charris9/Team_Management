<%--
    Document   : Bug_Conversation
    Created on : Mar 5, 2016, 7:20:27 AM


--%>
<%@include file ="Bug_DBconfig.jsp"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            String bugid = request.getParameter("search_bug_id").toString();
            String Bug_Name=null;
            String Bug_Description=null;
            Bug bug = new Bug();
            ResultSet bugtitleretrieve=bug.getBug();
            
            while(bugtitleretrieve.next())
            {
                if(bugtitleretrieve.getString("Bug_ID").toString().trim().equals(bugid.trim()))
                {
                    Bug_Name = bugtitleretrieve.getString("Bug_Title");
                    Bug_Description = bugtitleretrieve.getString("Bug_Description");
                }
            }
        %>
        <title>Bug Conversation</title>
    </head>
    
    <body>
        <%
            int results=0; 
            ResultSet bugsconvo=bug.getBugConvo();
            String bugconvo_comment=new String();
            String bugconvo_owner = new String(); 
            if(request.getParameter("add")!=null)
            {
                Integer addbug_id= 0;
                Date date =new Date();
                Timestamp bugconvo_timestamp = new Timestamp(date.getTime());
                if(request.getParameter("comment").trim() != null)
                {   
                    bugconvo_comment = request.getParameter("comment");
                }
                if(request.getParameter("owner").trim() != null)
                {
                    bugconvo_owner = request.getParameter("owner");
                }
                
                addbug_id=Integer.parseInt(bugid);
                
                if(bugconvo_comment.equals(bugconvo_owner))// will need to change this parameter
                {
                    
                }
                else
                {
                results=bug.setBugConvo(addbug_id, bugconvo_comment, bugconvo_owner, bugconvo_timestamp);
                }
            }
        %>
        
        <h1><%=Bug_Name %>'s Conversation</h1>
        <h2>Description</h2>
        <h2><%=Bug_Description %></h2>
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
            <input type="text" name="owner" />
            <input type="hidden" name="hidden" value="<%= results%>" />
            <input type="hidden" name="search_bug_id" value=<%= bugid%> />
            <input type="submit" value="SEND" name="add" />
            
            <%
                if(request.getParameter("add")!=null)
                { 
            %>
                <script type="text/javascript">
                    document.forms["add_comment"].submit();
                </script> 
            <%    
                }
            %>
        </form>
        
        <a href="Buglog_ViewDB.jsp">
            <input type="button" value="Back"/>
        </a>
    </body>
     
</html>
