<%-- 
    Document   : Bug_Create_Insert
    Created on : Apr 12, 2016, 5:02:15 PM
    Author     : zawiramin
--%>

<%-- 
    Document   : Bug_Create_Insert
    Created on : Feb 14, 2016, 4:58:51 PM
    Author     : caseyharris

    This purpose of this class is to take the information from the user and push
    is to the database. Then show the user that the last enter bug is theirs.
--%>
<%@include file ="Bug_DBconfig.jsp"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<%//@ page import="test.*"%>
<%Class.forName("com.mysql.jdbc.Driver");%>
<%//Class.forName("com.mysql.jdbc.log.LogFactory.getLogger");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserting</title>
    </head>
    
    <%--<link rel="stylesheet" href="style.css" type="text/css">--%>
    
    <body onload="displayResults()" >
        <div class="main-window">
            <h1>Insert Data into a DB</h1>
            <%
                int results=0; 
                String UserName=null; 
                String StoryID=null;
                
                Bug addBug=new Bug(); //open bug and user
                ResultSet Userretrieve=null;
                
                Userretrieve = addBug.user.getUser(); // opens another connection;
                
                StoryID = request.getParameter("Story_ID");
                
                if(request.getParameter("Submit")!=null)
                {
                    String bug_title= null;
                    String bug_owner = null;
                    String bug_description= null;
                    String bug_priority = null;
                    String bug_status = null;
                    
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
                    results=addBug.setBugs(bug_title, bug_owner, bug_description, bug_priority, bug_timestamp, bug_status, StoryID);
                } 
            %>
            
            <form name= "myform" action="Bug_Create_Insert.jsp" method="POST">
                <table border="0">
                    <tbody> 
                        <tr>
                            <td>Bug Title : </td>
                            <td><input type="text" name="bug_title" value="" size="50"  /></td>
                        </tr>
                        
                        <tr>
                            <td>Owner: </td>
                            <td>
                                <select name="bug_owner">
                                    <option></option>
                                    <%
                                        while (Userretrieve.next())
                                        {
                                            UserName=Userretrieve.getString("User_Name"); 
                                    %> 
                                            <option><%=UserName %></option>
                                    <%          
                                        }
                                        addBug.user.closeCONN();
                                    %> 
                                    
                                </select>
                            </td>
                        </tr>
                    
                        <tr>
                            <td>Bug Description: </td>
                            <td><input type="text" name="bug_description" value = "" size="50"/></td>
                            <td><input type="hidden" name="Story_ID" value="<%= StoryID%>" /></td>
                        </tr>
                
                        <tr>
                            <td>Select Priority</td>
                            <td>
                                <select name="bug_priority">
                                    <option></option>
                                    <option>Easy</option>
                                    <option>Medium</option>
                                    <option>Hard</option>
                                </select>
                            </td>
                        </tr>
                    </tbody>
                </table>
                        
                        
                <%addBug.closeCONN();%>    
                <input type="hidden" name="hidden" value="<%= results%>" />
                <input type="reset" value="Clear" name="Clear" />
                <input type="submit" value="Sumbit" name="Submit"  />
            </form>
                
                
            <form name="CreateBug2" action="Buglog.jsp" method="POST" >
                <input type="hidden" value="<%=StoryID%>" name="search_story_id"/>
                <input type="submit" value="Cancel" name="search_story_id2" />
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
        </div> 
    </body>
</html>

