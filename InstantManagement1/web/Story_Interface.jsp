<%-- 
    Document   : Story_Interface
    Created on : Apr 14, 2016, 6:06:00 PM
    Author     : zawiramin
--%>


<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : Storylog
    Created on : Apr 12, 2016, 5:05:49 PM
    Author     : zawiramin
--%>

<%-- 
    Document   : StoryLog
    Created on : Mar 6, 2016, 1:51:57 PM
    Author     : zawiramin

    Modified From:
    Document   : Buglog
    Created on : Feb 14, 2016, 4:58:51 PM
    Author     : caseyharris


--%>
<%@page import="java.sql.ResultSet"%>
<%@include file = "Story_DBconfig.jsp" %>
<%@page import = "java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instant Management</title>
    </head>
    
        <%          
            Story story = new Story();        
            ResultSet stories = story.getStory();           
            
//            ResultSet done = story.getStory();
            ArrayList<String> done = new ArrayList<String>();              
            ArrayList<String> icebox = new ArrayList<String>();
            ArrayList<String> current = new ArrayList<String>();
                               

            while (stories.next()) {
                if(stories.getString("Story_Location").equals("DONE")) {                    
                    done.add(stories.getString("Story_Title"));                   
                } else if (stories.getString("Story_Location").equals("CURRENT")) {
                    current.add(stories.getString("Story_Title"));
                } else if (stories.getString("Story_Location").equals("ICEBOX")) {
                    icebox.add(stories.getString("Story_Title"));
                }
            }
        %>   

        <body>
        <h1>New Main Page</h1>
        <table border="1">
            <tbody>
                <tr>
                    <td>DONE</td>
                    <td>CURRENT</td>
                    <td>ICEBOX</td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td>Title</td>
                    <td>Title</td>
                </tr>
                <tr>
                    
                </tr>
            </tbody>
        </table>

        <table border="1">                                            
            <tbody> 
                <tr>
                    <td>                                                           
                        <h3>DONE</h3>                    
                        <tr>
                            <td>Title</td>                                                                                                                  
                        </tr>

                        <%                
                            for (String item : done) {                                                       
                        %>                            
                        <tr>                                                                                                                                              
                            <td>                                   
                                <form name="Find_Story" action="Story_Search.jsp" method="POST">                                             
                                    <input             
                                        type="submit"                
                                        style="height: 10px"                                                                
                                        value="<%=item%>"                                                                
                                        name="search_title" />                                                                                                    
                                </form>                                            
                            </td>                                                                        
                        </tr>

                        <%
                        }
                        %>               
                    </td>              

                    <td>                
                        <h3>CURRENT</h3>                                        
                        <tr>                                
                            <td>Title</td>                                                                                                              
                        </tr>

                        <%  
                            for (String item : current) {                                
                        %>      
                        <tr>                                                                                                                                              
                            <td>                       
                                <form name="Find_Story" action="Story_Search.jsp" method="POST"> 
                                    <input                                       
                                        type="submit"                                        
                                        style="height: 10px"                                       
                                        value="<%=item%>"                                       
                                        name="search_title" />                                                                            
                                </form>
                            </td>
                        </tr>                 
                        <%
                        } 
                        %>                    
                    <td>                                                        
                        <h3>ICEBOX</h3>                    
                        <tr>                            
                            <td>Title</td>                                                                                                                                                                  
                        </tr>                              
                        <%                                                            
                            for (String item : icebox) {                                 
                        %>                                                                                            
                        <tr>
                            <td>                                                                                
                                <form name="Find_Story" action="Story_Search.jsp" method="POST">                                            
                                    <input                                                     
                                        type="submit"                                                            
                                        style="height: 10px"                                                            
                                        value="<%=item%>"                                                            
                                        name="search_title" />                                                                                            
                                </form>                                                                                   
                            </td>                                                                                                            
                        </tr>
                        <%                                   
                        }                                    
                        %>                                                                                      
                    </td>                                           
                </tr>
            </tbody>
        </table>        

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
