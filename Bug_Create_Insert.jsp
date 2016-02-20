

<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TestInsert</title>
    </head>
    
    
    <body onload="displayResults()">
        <h1>Insert Data into a DB</h1>
        <%!
         public  class Bug
         {
             String URL="jdbc:mysql://localhost/Testing";
             String USERNAME="root";
             String PASSWORD ="password";
             
             Connection connection = null;
             PreparedStatement insertBug = null;
             ResultSet resultSet = null;
             
             public Bug()
             {
                 try
                 {
                    connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    insertBug=connection.prepareStatement("INSERT INTO Buglog(Bug_Title, Bug_Owner,Bug_Description,Bug_Priority,Bug_Date_Added)"
                        + "VALUES (?,?,?,?,?)");
                 }
                 catch(SQLException e)
                 {
                     e.printStackTrace();
                 }
             }
             
            public int setBugs(String addBug_Title, String addBug_Owner, String addBug_Description, String addBug_Priority, Timestamp addBug_Date_Added)
            {
             int result=0;
             try {
                insertBug.setString(1, addBug_Title);
                insertBug.setString(2, addBug_Owner);
                insertBug.setString(3, addBug_Description);
                insertBug.setString(4, addBug_Priority);
                insertBug.setTimestamp(5, addBug_Date_Added);
                result = insertBug.executeUpdate();
                }   
                catch(SQLException e)
                {
                e.printStackTrace();
                }
            return result;
            }
             
         }
         %>
         
        <%
            int results=0;
            
            if(request.getParameter("Submit")!=null)
            {
            String bug_title= new String();
            String bug_owner = new String();
            String bug_description= new String();
            String bug_priority = new String();
            
            
            
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
            
           
            Date date =new Date();
            Timestamp bug_timestamp = new Timestamp(date.getTime());
            Bug addBug = new Bug();
            
            results=addBug.setBugs(bug_title, bug_owner, bug_description, bug_priority, bug_timestamp);
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
                        <td><input type="text" name="bug_owner" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Bug Description: </td>
                        <td><textarea name="bug_description" rows="8" cols="48" >
                            </textarea></td>
                    </tr>
                    <tr>
                        <td>Select Priority</td>
                        <td><select name="bug_priority">
                                <option>Easy</option>
                                <option>Medium</option>
                                <option>Hard</option>
                                
                            </select></td>
                    </tr>
                  
                </tbody>
            </table>
            <%//if(request.getParameter("bug_title").isEmpty())
                        {
                            //System.out.println("sad");
                        }%>
            
            <a href="Buglog.jsp">
            <input type="button" value="Cancel" />
            </a>
            
            <input type="hidden" name="hidden" value="<%= results%>" />
            <input type="reset" value="Clear" name="Clear" />
            <input type="submit" value="Sumbit" name="Submit"  />
          
            
    
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
