<%-- 
    Document   : Bug_Edit
    Created on : Mar 8, 2016, 10:52:25 AM
    Author     : caseyharris
--%>


<%@include file ="Bug_DBconfig.jsp"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bug Editing</title>
    </head>
    
    <%
        String bugid =request.getParameter("search_bug_ID").toString();
        String Bug_Title=null;
        String Bug_Description=null;
        String Bug_Owner=null;
        String Bug_Priority=null;
        String Bug_Status = null;
        String Bug_DateAdded =null;
        String Priority1=null;
        String Priority2=null;
        String Priority3=null;
        String Status1=null;
        String Status2=null;
        String Header=null;
        String UserName=null;
        
        
        Bug bug = new Bug();
        ResultSet bugretrieve=bug.getBug();
        ResultSet Userretrieve=bug.user.getUser();
            
            
        while(bugretrieve.next())
        {
            if(bugretrieve.getString("Bug_ID").toString().trim().equals(bugid.trim()))
            {
                Bug_Title = bugretrieve.getString("Bug_Title");
                Bug_Description = bugretrieve.getString("Bug_Description");
                Bug_Owner= bugretrieve.getString("Bug_Owner");
                Bug_Priority=bugretrieve.getString("Bug_Priority");
                Bug_Status = bugretrieve.getString("Bug_Status");
                Bug_DateAdded = bugretrieve.getString("Bug_Date_Added");
            }
        }   
    %>
    
    <form name="Bug_Update" action="Bug_Edit.jsp" method="POST">
    <%//if sumbit button equals true then show updated bug esle shoe orignal bug
        if  (request.getParameter("Update_Values")==null) 
        {
            Header = Bug_Title;
        }
        else
        {
            Header = new String("UPDATING");
        }
    %>
       
    <h1><%=Header%></h1>
    <table border="1">
        <tbody>
            <tr>
                <td>Bug Title: </td>
                <td><input type="text" name="UpdateBugTitle" value="<%=Bug_Title %>" /></td>
            </tr>
                    
            <tr>
                <td>Owner: </td>
                <td>
                    <%=Bug_Owner %>
                    <select name="UpdateBugOwner">
                        <option><%=Bug_Owner %></option>    
                        <%
                            while (Userretrieve.next()) 
                            {
                                if(!Bug_Owner.equals(Userretrieve.getString("User_Name")))
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
                <td><input type="text" name="UpdateBugDescription" value="<%=Bug_Description%>" /></td>
            </tr>
                    
            <tr>
                <td>Priority:</td>
                <td><%=Bug_Priority%>
                <%//<input type="hidden" name="origpriority" value="<%=Bug_Priority" />%>
                <select name="UpdateBugPriority">
                    <%
                        if(Bug_Priority.equals("Easy"))
                        {
                            Priority1="Easy";
                            Priority2="Medium";
                            Priority3="Hard";
                        }
                        if(Bug_Priority.equals("Medium"))
                        {
                            Priority1="Medium";
                            Priority2="Easy"; 
                            Priority3="Hard";
                        }
                        if(Bug_Priority.equals("Hard"))
                        { 
                            Priority1="Hard";
                            Priority2="Easy";
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
                <td>Current Status:</td>
                <td><%=Bug_Status %>
                <select name="UpdateBugStatus">
                    <%
                        if(Bug_Status.equals("INCOMPLETE"))
                        {   
                            Status1="INCOMPLETE";
                            Status2="COMPLETE";
                        }
                        if(Bug_Status.equals("COMPLETE"))
                        {
                            Status1="COMPLETE";
                            Status2="INCOMPLETE"; 
                        }
                        /*if(Bug_Priority.equals("Hard"))
                        {
                            Status1="Easy";
                            Status2="Medium";
                        }*/
                    %>
                    <option><%=Status1%></option>
                    <option><%=Status2%></option>
                </select>
                </td>
            </tr>
            <tr>
                <td>Date Created:</td>
                <td><%= Bug_DateAdded %></td>
                        
            </tr>
        </tbody>
    </table>
                
                
                
                
    <input type="hidden" value="<%=bugid %>" name="search_bug_ID" />                
    <input type="hidden" value="<%=Bug_Title %>" name="DB_Bugtitle" />
    <input type="hidden" value="<%=Bug_Owner %>" name="DB_Bugowner" />
    <input type="hidden" value="<%=Bug_Description%>" name="DB_Bugdescription" />
    <input type="hidden" value="<%=Bug_Priority %>" name="DB_Bugpriority" />                
    <input type="hidden" value="<%=Bug_Status %>" name="DB_Bugstatus" />   
        
    <input type="submit" value="Save" name="Update_Values" />
    
    <a href="Buglog_ViewDB.jsp">
    <input type="button" value="Finished" name="Finish" />
    </a>
        
        
        
        <% //refresh page
            if(request.getParameter("Update_Values")!=null)
            { 
        %> 
                <script type="text/javascript">
                    document.forms["Bug_Update"].submit();
                </script> 
        <%    
            }
        %>
    </form>
        <%//
        if  (request.getParameter("Update_Values")!=null) 
        {
            
            if(!request.getParameter("UpdateBugTitle").equals("Bug_Title"))
            {
                bug.UpdateBugTitle(request.getParameter("UpdateBugTitle"), bugid);
            }
            
            
            if(!request.getParameter("UpdateBugOwner").equals(Bug_Owner))
            {
                bug.UpdateBugOwner(request.getParameter("UpdateBugOwner"), bugid);
            }
            
            if(!request.getParameter("UpdateBugDescription").equals(Bug_Description))
            {
                bug.UpdateBugDescription(request.getParameter("UpdateBugDescription"), bugid);
            }
            
            
            
            if(!request.getParameter("UpdateBugPriority").equals(Bug_Priority))
            {
                bug.UpdateBugPriority(request.getParameter("UpdateBugPriority"), bugid);
            }
            
            if(!request.getParameter("UpdateBugStatus").equals(Bug_Status))
            {
                bug.UpdateBugStatus(request.getParameter("UpdateBugStatus"), bugid);
            }
            
            
            
        }%>

        
        
    <body>

</html>
