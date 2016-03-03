<%-- 
    Document   : Bud_DBconfig
    Created on : Feb 18, 2016, 8:26:33 PM
    Author     : caseyharris

    The purpose of this JSP is to house the BUG class which handles all interactions related to bugs when 
    communicating with the Database. In this class the connnection with the 
    database is established. It also provide the creations of variables methods
    that will enables the passing of information from other codes to and from 
    the database.


--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! public  class Bug
{
    String URL="jdbc:mysql://localhost:3306/Testing";
    String USERNAME="root";
    String PASSWORD ="password";
    
    // intialization of all variables
    Connection connection = null;
    PreparedStatement insertBug = null;
    PreparedStatement selectBug = null;
    PreparedStatement selectBugTitle = null;
    ResultSet resultSet = null;
    String resultString ="";
public Bug()
{
    try
        {
        // used to create a connection to the Database
        connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
        /*
        all prepared statements are defined here
        Criteria to add new prepared statement:
        1) Create unique variable at the top of the bug class
        2) Create a connect.prepareStatement(what the variable will do)
        3) Create method that uses the new variable
        */

        //SQl Statements
        insertBug=connection.prepareStatement("INSERT INTO Buglog(Bug_Title,Bug_Owner,Bug_Description,Bug_Priority,Bug_Date_Added,Bug_Status)"
        + "VALUES (?,?,?,?,?,?)");

        selectBug = connection.prepareCall("SELECT Bug_ID, Bug_title,Bug_Owner,Bug_Description, Bug_Priority, Bug_Date_Added, Bug_Status From BugLog");
                    
        selectBugTitle = connection.prepareCall("SELECT Bug_title");
        }
              
    catch(SQLException e)
        {
        e.printStackTrace();
        }
}

    // Methods to Communcate to Database
    // This methond takes the data a user has entered and pushes it to the Database
public int setBugs(String addBug_Title, String addBug_Owner,String addBug_Description, String addBug_Priority, Timestamp addBug_Date_Added, String addBug_Status)
{
    int result=0;
    try 
    {
        insertBug.setString(1, addBug_Title);
        insertBug.setString(2, addBug_Owner);
        insertBug.setString(3, addBug_Description);
        insertBug.setString(4, addBug_Priority);
        insertBug.setTimestamp(5, addBug_Date_Added);
        insertBug.setString(6, addBug_Status);
        result = insertBug.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}
            // This method retrives all the infromation associate with a specific Bug
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

// This Method retrieves the Bug Tilte from the Database
public String getBugTitle()
{
    try
    {
        resultSet = selectBugTitle.executeQuery();
        resultString=resultSet.getString("Bug_title");
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return resultString;
}
}
%>
