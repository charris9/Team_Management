<%-- 
    Document   : UserForm1
    Created on : Feb 14, 2016, 11:55:41 AM
    Author     : caseyharris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Bug</title>
    </head>
    <body>
        <h1>Create Bug</h1>
        <form name= "myform" action="display.jsp" method=""POST">
              <table border="0">
                
                <tbody>
                    <tr>
                        <td>Bug Title : </td>
                        <td><input type="text" name="Bug_Title" value="" size="50" /></td>
                    </tr>
                    
                    <tr>
                        <td>Owner: </td>
                        <td><input type="text" name="Owner" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Bug Description: </td>
                        <td><textarea name="Description" rows="8" cols="48" >
                            </textarea></td>
                    </tr>
                    <tr>
                        <td>Select Priority</td>
                        <td><select name="Priority">
                                <option>Easy</option>
                                <option>Medium</option>
                                <option>Hard</option>
                            </select></td>
                    </tr>
                  
                </tbody>
            </table>

              <input type="reset" value="Clear" name="Clear" />
            <input type="submit" value="Sumbit" name="Submit"  />
           <form name="CreateBug" action="Buglog.jsp">
                        <input type="submit" value="Cancel" name="Add_Bug_Cancel " />
        </form>
    
        </form>
        
        
        
        
        
    </body>
</html>
