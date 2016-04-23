<%-- 

    Document   : Story_DBconfig
    Created on : Mar 8, 2016, 2:52:05 AM
    Author     : zawiramin  

    Modified From:
    Document   : Bug_DBconfig
    Created on : Feb 18, 2016, 8:26:33 PM
    Author     : caseyharris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>

<!DOCTYPE html>
<%@include file ="Bug_DBconfig.jsp"%>
<%! 
//need to add a method that gets the number of bugs for this class.    

public class Story 
{
    String URL = "jdbc:mysql://teaminstantmanagement.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement";
    String USERNAME = "TeamIM";
    String PASSWORD = "BUCS673SPR";
    //Bug numBug=new Bug();
    
        // initialize all variables
    Connection connection = null;
    PreparedStatement insertStory = null;
    PreparedStatement selectStory = null;
    PreparedStatement selectStoryTitle = null;
    PreparedStatement selectStoryLocation =null;

    PreparedStatement UpdateStoryStatus = null;
    PreparedStatement UpdateStoryPriority = null;
    PreparedStatement UpdateStoryOwner = null;
    PreparedStatement UpdateStoryTitle = null;
    PreparedStatement UpdateStoryDescription = null;
    PreparedStatement UpdateStoryLocation =null;
    PreparedStatement UpdateStoryBugNum =null;

    ResultSet resultSet = null;
    String resultString = "";

    
    public Story() 
    {
        try
        {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                //SQl Statements
                insertStory = connection.prepareStatement("INSERT INTO Story_Table(Story_Title, Story_Owner, Story_Description, Story_Priority, Story_Date_Added, Story_Status, Story_Location, Story_BugNum)"
                        + "VALUE (?, ?, ?, ?, ?, ?,?,?)");

                selectStory = connection.prepareStatement("SELECT Story_ID, Story_Title, Story_Owner, Story_Description, Story_Priority, Story_Date_Added, Story_Status, Story_Updated, Story_Location, Story_BugNum, Story_Unresolved_BugNum FROM Story_Table");

                selectStoryTitle = connection.prepareCall("SELECT Story_Title");

                //Story update
                UpdateStoryStatus = connection.prepareStatement("UPDATE Story_Table SET Story_Status = ? " + "WHERE Story_ID = ?");


                selectStoryLocation= connection.prepareCall("SELECT Story_Location FROM Story_Table");
                UpdateStoryLocation= connection.prepareStatement("UPDATE Story_Table SET Story_Location = ? " + "WHERE Story_ID = ?");
                
                UpdateStoryBugNum= connection.prepareStatement("UPDATE Story_Table SET Story_BugNum = ? , Story_Unresolved_BugNum = ? " + "WHERE Story_ID = ?");
                
                UpdateStoryPriority = connection.prepareStatement("UPDATE Story_Table SET Story_Priority = ?" + "WHERE Story_ID = ?");
                UpdateStoryOwner = connection.prepareStatement("UPDATE Story_Table SET Story_Owner = ?" + "WHERE Story_ID = ?");
                UpdateStoryTitle = connection.prepareStatement("UPDATE Story_Table SET Story_Title = ?" + "WHERE Story_ID = ?");
                UpdateStoryDescription = connection.prepareStatement("UPDATE Story_Table SET Story_Description = ?" + "WHERE Story_ID = ?");






}
    
catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public int setStories(String title, String owner, String description, String priority, Timestamp timeStamp, String status, String location, String bugnum) {
            int results = 0;
            try {
                insertStory.setString(1, title);
                insertStory.setString(2, owner);
                insertStory.setString(3, description);
                insertStory.setString(4, priority);
                insertStory.setTimestamp(5, timeStamp);
                insertStory.setString(6, status);  
                insertStory.setString(7, location);  
                insertStory.setString(8, bugnum); 
                results = insertStory.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return results;
        }

        public ResultSet getStory() {
            try {
                resultSet = selectStory.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }

        public String getStoryTitle() {
            try {
                resultSet = selectStoryTitle.executeQuery();
                resultString = resultSet.getString("Story_Title");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultString;
        }

        public int UpdateStoryStatus(String UpdateStory_Status, String Story_ID) {
            int result = 0;
            try {
                UpdateStoryStatus.setString(1, UpdateStory_Status);               
                UpdateStoryStatus.setString(2, Story_ID);

                result = UpdateStoryStatus.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }

        public int UpdateStoryLocation(String UpdateStory_Location, String Story_ID)
        {
        int result = 0;
            try {
                UpdateStoryLocation.setString(1, UpdateStory_Location);               
                UpdateStoryLocation.setString(2, Story_ID);

                result = UpdateStoryLocation.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }
        public String getStoryLoacation()
        {
        try {
                resultSet = selectStoryLocation.executeQuery();
                resultString = resultSet.getString("Story_Title");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultString;
        }
        
        public int getBugNums(String Story_id) throws SQLException
        {
           int result=0;
            
            Bug bugs=new Bug();
            ResultSet allbugs=bugs.getBug();
                
        
            int UpdateStory_BugNum=0;
            int unresolvedStory_BugNum=0;
            while(allbugs.next())
            {
            //if bug id match the search id from bug_search.jsp retreive all that bugs data Story_Unresolved_BugNum
                if(allbugs.getString("Story_ID").trim().equals(Story_id.trim()))
                {
                    UpdateStory_BugNum++;
                    if(allbugs.getString("Bug_Status").trim().equals("INCOMPLETE"))
                    {
                        unresolvedStory_BugNum++;
                    }
                }
            }
            allbugs.close();
            bugs.closeCONN();

            String setBugNum=Integer.toString(UpdateStory_BugNum).trim();
            String setunresolvedStory_BugNum=Integer.toString(unresolvedStory_BugNum).trim();
            try 
            {   
                UpdateStoryBugNum.setString(1, setBugNum);
                UpdateStoryBugNum.setString(2, setunresolvedStory_BugNum);
                UpdateStoryBugNum.setString(3, Story_id);
                               
                result = UpdateStoryBugNum.executeUpdate();
            } 
        
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
            //allbugs.close();
            
            return result;
        }
        
public int UpdateStoryPriority(String UpdateStory_Priority, String Story_ID) {
            int result = 0;
            try {
                UpdateStoryPriority.setString(1, UpdateStory_Priority);                            
                UpdateStoryPriority.setString(2, Story_ID);                

                result = UpdateStoryPriority.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }

        public int UpdateStoryOwner(String UpdateStory_Owner, String Story_ID) {
            int result = 0;
            try {
                UpdateStoryOwner.setString(1, UpdateStory_Owner);                            
                UpdateStoryOwner.setString(2, Story_ID);                

                result = UpdateStoryOwner.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }

        public int UpdateStoryTitle(String UpdateStory_Title, String Story_ID) {
            int result = 0;
            try {
                UpdateStoryTitle.setString(1, UpdateStory_Title);                            
                UpdateStoryTitle.setString(2, Story_ID);                

                result = UpdateStoryTitle.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }

        public int UpdateStoryDescription(String UpdateStory_Description, String Story_ID) {
            int result = 0;
            try {
                UpdateStoryDescription.setString(1, UpdateStory_Description);                            
                UpdateStoryDescription.setString(2, Story_ID);                

                result = UpdateStoryDescription.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
        }








public void closeCONN() throws SQLException
{
//numBug.closeCONN();
connection.close();
}


    }  
%>



