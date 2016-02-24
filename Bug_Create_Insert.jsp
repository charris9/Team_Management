
<%@include file = "Bug_DBconfig.jsp"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>TestInsert</title>
    </head>
    
    
    <body onload="displayResults()">
        
        
        <%
            int results=0;
            
            if(request.getParameter("Submit")!=null)
            {
            String bug_title= new String();
            String bug_owner = new String();
            String bug_description= new String();
            String bug_priority = new String();
            String bug_status = new String();
            
            
            if(request.getParameter("bug_title") != null)
            {
                bug_title = request.getParameter("bug_title");
            }
            if(request.getParameter("bug_owner") != null)
            {
                bug_owner = request.getParameter("bug_owner");
            }
            if(request.getParameter("bug_description") != null)
            {
                bug_description = request.getParameter("bug_description");
            }
            if(request.getParameter("bug_priority") != null)
            {
                bug_priority = request.getParameter("bug_priority");
            }
            if(request.getParameter("bug_status") != null)
            {
                bug_priority = request.getParameter("bug_status");
            }
           
            Date date =new Date();
            Timestamp bug_timestamp = new Timestamp(date.getTime());
            
            bug_status="INCOMPLETE";
            Bug addBug = new Bug();
            
            results=addBug.setBugs(bug_title, bug_owner, bug_description, bug_priority, bug_timestamp, bug_status);
            } 
        %>
     
        <div class="main-window">
        <h1>Insert Data into a DB</h1>
        <form name= "myform" action="Bug_Create_Insert.jsp" method="POST">
        
 
              <table border="0">
                
                <tbody> 
                    <tr>
                        <td>Bug Title : </td>
                        <td><input type="text" name="bug_title" value="" size="50"  /></td>
                        
                    </tr>
                    
                    <tr>
                        <td>Owner: </td>
                        <td><input type="text" name="bug_owner" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Bug Description: </td>
                        <td><input type="text" name="bug_description" value = "" size="50"   /></td>
                    </tr>
                
                    
                    <tr>
                        <td>Select Priority</td>
                        <td><select name="bug_priority">
                                <option>Easy</option>
                                <option>Medium</option>
                                <option>Hard</option>
                                <option><%= results%></option>
                            </select></td>
                    </tr>
                  
                </tbody>
            </table>
            <a href="Buglog.jsp">
            <input type="button" value="Cancel" />
            </a>
            
            <input type="hidden" name="hidden" value="<%= results%>" />
            <input type="reset" value="Clear" name="Clear" />
            <input type="submit" value="Sumbit" name="Submit"  />
          </div>  
           
    
        </form>   
           
            
        <script LANGUAGE = "JavaScript"> 
               
                    function displayResults()
                    
                    {
                        if(document.myform.hidden.value == 1)
                        {
                        location='Bug_Display.jsp';     
                         }
                    }
                   
                    
                    </script> 
    
   </html>
