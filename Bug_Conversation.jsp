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
        <title>(bug Name) + Conversion</title>
    </head>
    
    <body>
        <%int results=0; 
        String bugid = request.getParameter("search_bug_id").toString();
        Bug bug = new Bug();
        ResultSet bugsconvo=bug.getBugConvo();
        Bug addBugConvo = new Bug();
        String addbugconvo_comment=new String();
        String addbugconvo_owner = new String(); 
        
        if(request.getParameter("add")!=null)
        {
            Integer addbug_id= 0;
            Date date =new Date();
            Timestamp bugconvo_timestamp = new Timestamp(date.getTime());
            if(request.getParameter("comment").trim() != null)
            {
                addbugconvo_comment = request.getParameter("comment");
            }
            if(request.getParameter("owner").trim() != null)
            {
                addbugconvo_owner = request.getParameter("owner");
            }
           
            addbug_id=Integer.parseInt(bugid);
            if(addbugconvo_comment.equals(addbugconvo_owner))// will need to change this parameter
            {
                    
            }
            else
            {
                results=addBugConvo.setBugConvo(addbug_id, addbugconvo_comment, addbugconvo_owner, bugconvo_timestamp);
                
            }
        }%>
        
        <h1>Bug Conversation</h1>
        
        <form name="Reload" action="Bug_Conversation">
            <% 
            while(bugsconvo.next())     
            {// if bug tilte matches the search bug title retrieve all information
                if (bugsconvo.getString("Bug_ID").toString().trim().equals(bugid.trim())) 
                {%>
                    <table border="0">
                        <tbody>
                        <tr>
                            <td><%= bugsconvo.getString("Bug_Conversation_Comment") %></td>
                            <td><%= bugsconvo.getString("Bug_Conversation_Owner") %></td>
                            <td><%= bugsconvo.getString("Bug_Conversation_Time_Added") %></td>
                        </tr>
                    </tbody>
                    </table>
            <%  }//}
            }%>
        </form>
        <form name="add_comment" action="Bug_Conversation.jsp" method="POST">
            <input type="text" name="comment"/>
            <input type="text" name="owner" />
            <input type="hidden" name="hidden" value="<%= results%>" />
            <input type="hidden" name="search_bug_id" value=<%= bugid%> />
            <input type="submit" value="SEND" name="add" />
            
          <%if(request.getParameter("add")!=null)
            { %>
                <script type="text/javascript">
                    document.forms["add_comment"].submit();
                </script> 
          <%}%>
        </form>
        <a href="Buglog_ViewDB.jsp">
            <input type="button" value="Back"/>
        </a>
    </body>
     
</html>
