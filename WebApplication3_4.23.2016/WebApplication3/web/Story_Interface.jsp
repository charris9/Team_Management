<%-- 
    Document   : Story_Interface
    Created on : Apr 23, 2016, 11:53:20 AM
    Author     : caseyharris
--%>






<%@page import = "java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "Story_DBconfig.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instant Management</title>
    </head>
    
        <%          
           
            
            
            //Story story = new Story();
            Story done = new Story();
            Story current = new Story();
            Story icebox = new Story();
                        
            ResultSet resultSet1 = done.getStory();
            ResultSet resultSet2 = current.getStory();
            ResultSet resultSet3 = icebox.getStory();
            
        %>   

        <body>
        <h1>New Main Page</h1>
        <table>
            <tbody>       
                <tr>           
                    <td>            
                        <form name="CreateStory" action="Story_Create_Insert.jsp">                
                            <input type="submit" value="Add Story" name="AddStory" />
                        </form>
                    </td>
                    <td>            
                        <form name="ViewStories" action="Storylog_ViewDB.jsp">                
                            <input type="submit" value="View All Stories" name="ViewStory" />
                        </form>                    
                    </td> 
                    <td>            
                        <form name="Logout" action="index.jsp">                
                            <input type="submit" value="LOGOUT" name="logout" />
                            <%
                            session.invalidate();
                            %>
                        </form>                    
                    </td> 
                </tr>            
            </tbody>        
        </table>    
        
        <table border="1">
            <tbody>
                <tr>
                    <td>DONE</td>
                    <td>CURRENT</td>
                    <td>ICEBOX</td>
                </tr> 
                
                
                <tr>    
                    
                    <td>
                        <% 
                        while(resultSet1.next()) 
                        {                            
                            if (resultSet1.getString("Story_Location").equals("DONE")) 
                            { 
                        %>
                                <form name="Find_Story" action="Story_Search.jsp" method="POST">                                                                                                  
                                    <input type="submit" style="height: 25px" value="<%= resultSet1.getString("Story_Title") %>" name="search_title" />                                 
                                </form>
                        <%  } 
                        }
                        %>                         
                    <% done.closeCONN(); %>
                    </td>
                    
                    
                    <td>
                        <%
                        while(resultSet2.next()) {    
                            if (resultSet2.getString("Story_Location").trim().equals("CURRENT")) { 
                        %>
                            <form name="Find_Story" action="Story_Search.jsp" method="POST">                                                                                                  
                                <input type="submit" style="height: 25px" value="<%= resultSet2.getString("Story_Title") %>" name="search_title" /> 
                            </form>
                        <%  } 
                        } 
                        %>
                    <% current.closeCONN(); %>
                    </td>
                    
                    
                    
                    <td>
                        <%
                        while (resultSet3.next()) {    
                            if (resultSet3.getString("Story_Location").trim().equals("ICEBOX") ) { 
                        %>
                            <form name="Find_Story" action="Story_Search.jsp" method="POST">                                                                                                  
                                <input type="submit" style="height: 25px" value="<%= resultSet3.getString("Story_Title") %>" name="search_title" /> 
                            </form>
                        <%  } 
                        }
                        %>
                    <% icebox.closeCONN(); %>                         
                    </td>                                                           
                </tr>                                                       
            </tbody>
        </table>
        <%  
        %>                    

        <table>
            <tbody>       
                <tr>           
                    <td>            
                        <form name="CreateStory" action="Story_Create_Insert.jsp">                
                            <input type="submit" value="Add Story" name="AddStory" />
                        </form>
                    </td>
                    <td>            
                        <form name="ViewStories" action="Storylog_ViewDB.jsp">                
                            <input type="submit" value="View All Stories" name="ViewStory" />
                        </form>                    
                    </td>                
                </tr>            
            </tbody>        
        </table>         
</body>

</html>

