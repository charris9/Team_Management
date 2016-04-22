<%-- 
    Document   : Storylog
    Created on : Apr 12, 2016, 5:05:49 PM
    Author     : zawiramin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instant Management</title>
    </head>
    <body>
        <h1>Main Page</h1>
        
        <%--Create table--%>
        <table border="0">
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
                        <form name="ViewNewMainPage" action="Story_Interface.jsp">
                            <input type="submit" value="View New Main Page" name="ViewMainPage" />
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
        
    </body>
</html>