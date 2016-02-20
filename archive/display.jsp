<%-- 
    Document   : display
    Created on : Feb 14, 2016, 12:05:43 PM
    Author     : caseyharris
--%>
<%@page import = "java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bug Created</title>
    </head>
    <body>
        <h1>Bug Created!</h1>
        <%
        String Bug_Name = request.getParameter("Bug_Title");
        String Owner = request.getParameter("Owner");
        String Description = request.getParameter("Description");
        String Priority = request.getParameter("Priority");
        
        Date date = new Date();
        String Status = request.getParameter("Status");
        
         %>
         
         <table border="1">
                
                <tbody>
                    <tr>
                        <td>Bug Title: </td>
                        <td><%=Bug_Name%></td>
                    </tr>
                    
                    <tr>
                        <td>Owner: </td>
                        <td><%=Owner%></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><%=Description%></td>
                    </tr>
                    
                    <tr>
                        <td>Priority:</td>
                        <td><%=Priority%></td>
                    </tr>
                    <tr>
                        <td>Current Status:</td>
                        <% if (Status==null)
                        {Status="Open";}%>
                                
                       <td><%=Status%></td>
                    </tr>
                    <tr>
                        <td>Date Created:</td>
                        <td><%=date%></td>
                    </tr>
                    
                </tbody>
            </table>
                    
                    
                   <form name="Finished" action="Buglog.jsp">
                        <input type="submit" value="Continue" name="Finished" />
                        </form>
    </body>
</html>
