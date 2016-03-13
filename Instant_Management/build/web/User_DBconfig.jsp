<%-- 
    Document   : Bud_DBconfig
    Created on : Mar 13, 2016, 8:26:33 PM
    Author     : caseyharris



--%>


<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! public  class User
{
    String URL2="jdbc:mysql://localhost:3306/Testing";
    String USERNAME2="root";
    String PASSWORD2 ="password";
    
    // intialization of all variables
    Connection connection2 = null;
    PreparedStatement insertUser = null;
    PreparedStatement selectUser = null;
    PreparedStatement selectUserName = null;
    PreparedStatement UpdateUserName = null;
    ResultSet resultSet = null;
    String resultString ="";

public User()
{
    try
        {
        // used to create a connection to the Database
        connection2= DriverManager.getConnection(URL2, USERNAME2, PASSWORD2);
        /*
        all prepared statements are defined here
        Criteria to add new prepared statement:
        1) Create unique variable at the top of the bug class
        2) Create a connect.prepareStatement(what the variable will do)
        3) Create method that uses the new variable
        */

//SQl Statements------------------------User---------------------------------
        insertUser=connection2.prepareStatement("INSERT INTO User(User_Name)"
        + "VALUES (?)"); 

        selectUser = connection2.prepareCall("SELECT User_ID, User_Name From User");
        UpdateUserName = connection2.prepareStatement("UPDATE User SET User_Name = ? " + "WHERE User_ID = ? ");
        



    }
              
    catch(SQLException e)
        {
        e.printStackTrace();
        }
}

    // Methods to Communcate to Database
    // This methond takes the data a user has entered and pushes it to the Database

//--------------------------------------BUG Log Methods-------------------------
public int setUser(String addUser)
{
    int result=0;
    try 
    {
        insertUser.setString(2, addUser);
        
        result = insertUser.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}
            // This method retrives all the infromation associate with a specific Bug
public ResultSet getUser()
{
    try
        {
            resultSet = selectUser.executeQuery();
        }
    catch(SQLException e)
        {
            e.printStackTrace();
        }
    return resultSet;
}

// This Method retrieves the Bug Tilte from the Database
public String getUserName()
{
    try
    {
        resultSet = selectUserName.executeQuery();
        resultString=resultSet.getString("User_Name From User");
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return resultString;
}


//---------------------------------SQL BUG Update Methods--------------------------------
public int UpdateUserName(String updateUserName, String user_ID)
{
    int result=0;
    try 
    {
        UpdateUserName.setString(1, updateUserName);
        UpdateUserName.setString(2, user_ID);
       
        result = UpdateUserName.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}





}
%>
