<%-- 
    Document   : DBTest
    Created on : Feb 16, 2016, 10:26:51 AM
    Author     : caseyharris
--%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="Bug_DBconfig.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Bugs</title>
    </head>
    <body>
        <h1>("Story's Name) + Total Bugs</h1>
        <table border="0">
            <thead>
                <tr>
                <td>
                        <form name="CreateBug" action="Bug_Create_Insert.jsp">
                        <input type="submit" value="Add Bug" name="Add Bug" />
                        </form>
                    </td>
                    <td>
                        <form name="Bug Log" action="Buglog.jsp" >
                        <input type="submit" value="Back" name="Back" />
                        </form>
                    </td>
                </tr>
                    
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        
        
        
        
        
        <h1>Selecting Data From a DB</h1>
        <%!
         public  class Bug
         {
             String URL="jdbc:mysql://localhost/Testing";
             String USERNAME="root";
             String PASSWORD ="password";
             
             Connection connection = null;
             PreparedStatement selectBug = null;
             ResultSet resultSet = null;
             
             public Bug()
             {
                 try
                 {
                    connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    selectBug = connection.prepareCall("SELECT Bug_ID, Bug_title, Bug_Owner, Bug_Description, Bug_Priority, Bug_Date_Added From BugLog");
                }
                 catch(SQLException e)
                 {
                     e.printStackTrace();
                 }
             }
             
             public ResultSet getBug()
             {
                 try
                 {
                     resultSet = selectBug.executeQuery();
                 }
                 catch(SQLException e)
                 {
                         e.printStackTrace();
                 }
                 return resultSet;
             }
         }
         %>
         
         <%
         Bug bug = new Bug();
         ResultSet bugs=bug.getBug();%>
         <table border="1">
                     <tbody>
                         <tr>
                             <td>Bug ID</td>
                             <td>Title</td>
                             <td>Owner</td>
                             <td>Description</td>
                             <td>Priority</td>
                             <td>Date Created</td>
                             
                         </tr>
                         
                         <% while (bugs.next()) { %>
                         <tr>
                             <td><%= bugs.getString("Bug_ID") %></td>
                             <td><%= bugs.getString("Bug_Title") %></td>
                             <td><%= bugs.getString("Bug_Owner") %></td>
                             <td><%= bugs.getString("Bug_Description") %></td>
                             <td><%= bugs.getString("Bug_Priority") %></td>
                             <td><%= bugs.getString("Bug_Date_Added") %></td>
                             
                         </tr>
                         <%}%>
                     </tbody>
         </table>

         
    </body>
</html>
