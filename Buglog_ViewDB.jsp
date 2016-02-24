<%-- 
    Document   : DBTest
    Created on : Feb 16, 2016, 10:26:51 AM
    Author     : caseyharris
--%>
<%@include file = "Bug_DBconfig.jsp"%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Bugs</title>
    </head>
    <body>
        <h1>("Story's Name) + Total Bugs From Data Base</h1>
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
      
 <%
         Bug bug = new Bug();
         ResultSet bugs=bug.getBug();%>
         <table border="1">
             <tbody>
             
             
             
                        <%-- 
                         <tr>
                             <td>Bug ID</td>
                             <td>Title</td>
                             <td>Owner</td>
                             <td>Description</td>
                             <td>Priority</td>
                             <td>Date Created</td>
                             
                         </tr>
                        --%>
                        <tr>
                          <td>Title</td>
                          <td>Priority</td>
                          <td>Date Created</td>
                          <td>Status</td>
                        </tr>
                        
                         <% while (bugs.next()) { %>
                         <tr>
                            <form name="Find_Bug" action="Bug_Search.jsp" method="POST">
                             <td><input type="submit" 
                                   style="height:25px; width:500px" 
                                   value="<%= bugs.getString("Bug_Title") %> <%//+ <%= bugs.getString("Bug_Owner") %>" 
                                   name="CGHJ"  /></td>
                             </form>
                              
                             <td><%= bugs.getString("Bug_Priority") %></td>
                             <td><%= bugs.getString("Bug_Date_Added") %></td>
                             <td><%= bugs.getString("Bug_Status") %></td>
                         </tr>
                            
   
                            <%-- 
                            <tr>
                             <td><%= bugs.getString("Bug_ID") %></td>
                             <td><%= bugs.getString("Bug_Title") %></td>
                             <td><%= bugs.getString("Bug_Owner") %></td>
                             <td><%= bugs.getString("Bug_Description") %></td>
                             <td><%= bugs.getString("Bug_Priority") %></td>
                             <td><%= bugs.getString("Bug_Date_Added") %></td>
                            </tr>
                            --%>
                         
                         <%}%>
                     </tbody>
         </table>
                              

         
    </body>
</html>
