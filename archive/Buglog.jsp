<%-- 
    Document   : Buglog
    Created on : Feb 14, 2016, 4:58:51 PM
    Author     : caseyharris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>(Story's Name here) Buglog</title>
    </head>
    <body>
        <h1>(Story's Name here) Buglog Selection</h1>
        
        <table border="0">
            
            <tbody>
                <tr>
                    <td>
                        <form name="CreateBug" action="Create_Bug.jsp">
                        <input type="submit" value="Add Bug" name="Add Bug" />
                        </form>
                    </td>
                    <td>
                        <form name="ViewBugs" action="display.jsp" >
                        <input type="submit" value="View Bugs" name="View_Bug_Log" />
                        </form>
                    </td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        
        
        
         
        
    </body>
</html>
