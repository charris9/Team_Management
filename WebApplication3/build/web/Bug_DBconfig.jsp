<%-- 
    Document   : Bug_DBconfig
    Created on : Feb 18, 2016, 8:26:33 PM
    Author     : caseyharris

    The purpose of this JSP is to house the BUG class which handles all interactions related to bugs when 
    communicating with the Database. In this class the connnection with the 
    database is established. It also provide the creations of variables methods
    that will enables the passing of information from other codes to and from 
    the database.


--%>
<%@include file ="User_DBconfig.jsp"%>
<%@include file ="Story_DBconfig.jsp" %>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%! 

public  class Bug
{
    String URL="jdbc:mysql://teaminstantmanagement.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement";//jdbc:mysql://localhost:3306/Testing";

    String USERNAME="TeamIM";//root";//TeamIM
    String PASSWORD ="BUCS673SPR";//password";//BUCS673SPR
    User user = new User();
    
 
    
    // intialization of all variables
    Connection connection=null;

    PreparedStatement setStoryID=null;
    PreparedStatement getStoryID=null;
    PreparedStatement insertBug=null;
    PreparedStatement selectBug=null;
    PreparedStatement selectBugTitle=null;
    ResultSet resultSet=null;
    String resultString ="";
    
    PreparedStatement UpdateBugTitle=null;
    PreparedStatement UpdateBugDescription=null;
    PreparedStatement UpdateBugPriority=null;
    PreparedStatement UpdateBugStatus=null;
    PreparedStatement UpdateBugOwner=null;
    // might add date modified to here and DB

    PreparedStatement insertBugConvo = null;
    PreparedStatement selectBugConvo = null;
    PreparedStatement selectBugConvo_Bug_ID = null;
    




public Bug() //throws SQLException
{
    try
        {
        // used to create a connection to the Database
        
        //Class.forName("com.mysql.jdbc.Driver"); 
        //Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        /*
        all prepared statements are defined here
        Criteria to add new prepared statement:
        1) Create unique variable at the top of the bug class
        2) Create a connect.prepareStatement(what the variable will do)
        3) Create method that uses the new variable*/
        

//SQl Statements------------------------BUG LOG---------------------------------
setStoryID = connection.prepareStatement("INSERT INTO Buglog(Story_ID)" + "VALUES (?)");

getStoryID = connection.prepareStatement("SELECT Story_ID FROM Buglog;");




          insertBug=connection.prepareStatement("INSERT INTO Buglog(Bug_Title,Bug_Owner,Bug_Description,Bug_Priority,Bug_Date_Added,Bug_Status, Story_ID)"
        + "VALUES (?,?,?,?,?,?,?)");

        selectBug = connection.prepareStatement("SELECT Bug_ID, Bug_Title,Bug_Owner,Bug_Description, Bug_Priority, Bug_Date_Added, Bug_Status, Story_ID From Buglog;");
                    
        selectBugTitle = connection.prepareStatement("SELECT Bug_title From Buglog"); //Might want to add From BugLog 

            //---------------------------BUG LOG Updates--------------------------


        UpdateBugTitle = connection.prepareStatement("UPDATE Buglog SET Bug_Title = ? " + "WHERE Bug_ID = ? ");
        UpdateBugDescription = connection.prepareStatement("UPDATE Buglog SET Bug_Description = ? " + "WHERE Bug_ID = ?");
        UpdateBugPriority = connection.prepareStatement("UPDATE Buglog SET Bug_Priority = ? " + "WHERE Bug_ID = ?");
        UpdateBugStatus = connection.prepareStatement("UPDATE Buglog SET Bug_Status = ? " + "WHERE Bug_ID = ?");
        UpdateBugOwner  = connection.prepareStatement("UPDATE Buglog SET Bug_Owner = ? " + "WHERE Bug_ID = ?");


//SQl Statements------------------------BUG's Conversations---------------------------------
        
        insertBugConvo = connection.prepareStatement("INSERT INTO Bug_Conversation(Bug_ID, Bug_Conversation_Comment, Bug_Conversation_Owner, Bug_Conversation_Time_Added)" + "VALUES (?,?,?,?)");

       selectBugConvo = connection.prepareStatement("SELECT Bug_Conversation_ID, Bug_ID,Bug_Conversation_Comment,Bug_Conversation_Owner, Bug_Conversation_Time_Added FROM Bug_Conversation");
        selectBugConvo_Bug_ID = connection.prepareStatement("SELECT Bug_ID From Bug_Conversation");

}
              
    catch(SQLException e)
        {
       e.printStackTrace();
        }
}

    // Methods to Communcate to Database
    // This methond takes the data a user has entered and pushes it to the Database

//--------------------------------------BUG Log Methods-------------------------
public String getUsername()
{
    return USERNAME;
}


public ResultSet getStoryID()
{
try
        {
            resultSet = getStoryID.executeQuery();
        }
    catch(SQLException e)
        {
            e.printStackTrace();
        }
    return resultSet;
}

public int setStoryID(String addStory_ID)
{
    int result=0;
    try 
    {
        setStoryID.setString(8, addStory_ID);
        
        result = setStoryID.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public int setBugs(String addBug_Title, String addBug_Owner,String addBug_Description, String addBug_Priority, Timestamp addBug_Date_Added, String addBug_Status, String addStory_ID)
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
        insertBug.setString(7, addStory_ID);
        result = insertBug.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}
 

// This method retrives all the infromation associate with a specific Bug
public ResultSet getBug()//throws SQLException
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
        connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);  
        resultSet = selectBugTitle.executeQuery();
        resultString=resultSet.getString("Bug_Title From Buglog");
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return resultString;
}


//---------------------------------SQL BUG Update Methods--------------------------------
public int UpdateBugTitle(String UpdateBug_Title, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugTitle.setString(1, UpdateBug_Title);
        UpdateBugTitle.setString(2, Bug_ID);
       
        result = UpdateBugTitle.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public int UpdateBugOwner(String UpdateBug_Owner, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugOwner.setString(1, UpdateBug_Owner);
        UpdateBugOwner.setString(2, Bug_ID);
       
        result = UpdateBugOwner.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public int UpdateBugDescription(String UpdateBug_Description, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugDescription.setString(1, UpdateBug_Description);
        UpdateBugDescription.setString(2, Bug_ID);
       
        result = UpdateBugDescription.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public int UpdateBugPriority(String UpdateBug_Priority, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugPriority.setString(1, UpdateBug_Priority);
        UpdateBugPriority.setString(2, Bug_ID);
       
        result = UpdateBugPriority.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public int UpdateBugStatus(String UpdateBug_Status, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugStatus.setString(1, UpdateBug_Status);
        UpdateBugStatus.setString(2, Bug_ID);
       
        result = UpdateBugStatus.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}





















//--------------------------------BUG Conversation Methods--------------------------------
public int setBugConvo(int addBug_ID, String addBugConvo_Comment,String addBugConvo_Owner, Timestamp addBug_Date_Added)
{
    int result=0;
    try 
    {
        insertBugConvo.setInt(1, addBug_ID);
        insertBugConvo.setString(2, addBugConvo_Comment);
        insertBugConvo.setString(3, addBugConvo_Owner);
        insertBugConvo.setTimestamp(4, addBug_Date_Added);
        
        result = insertBugConvo.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public ResultSet getBugConvo()
{
    try
        {
            resultSet = selectBugConvo.executeQuery();
        }
    catch(SQLException e)
        {
            e.printStackTrace();
        }
    return resultSet;
}



// This Method retrieves the Bug Converstion from the Bug_Conversation in the Database
public String getBugConvo_Bug_ID()
{
    try
    {
        resultSet = selectBugConvo_Bug_ID.executeQuery();
        resultString=resultSet.getString("Bug_ID FROM Bug_Conversation");
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return resultString;
}

public void closeCONN() throws SQLException
{
user.connection.close();
connection.close();
}

}
%>
