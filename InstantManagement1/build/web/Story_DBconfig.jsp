<%-- 
    Document   : Story_DBconfig
    Created on : Apr 12, 2016, 5:05:12 PM
    Author     : zawiramin
--%>

<%-- 
    Document   : Story_DBconfig
    Created on : Mar 8, 2016, 2:52:05 AM
    Author     : zawiramin

    Modified From:
    Document   : Bug_DBconfig
    Created on : Feb 18, 2016, 8:26:33 PM
    Author     : caseyharris
--%>
<%@include file ="User_DBconfig.jsp"%>
<%@page import = "java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Class.forName("com.mysql.jdbc.Driver");%>
<!DOCTYPE html>
<head></head>
<%! public class Story {

        String URL = "jdbc:mysql://localhost:3306/Testing1";
        String USERNAME = "root";
        String PASSWORD = "1234";

//        String URL = "jdbc:mysql://teaminstantmanagement.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement";
//        String USERNAME = "TeamIM";
//        String PASSWORD = "BUCS673SPR";

        User user = new User();

        // initialize all variables
        Connection connection = null;
        PreparedStatement insertStory = null;
        PreparedStatement selectStory = null;
        PreparedStatement selectStoryTitle = null;
        ResultSet resultSet = null;
        String resultString = "";

        PreparedStatement UpdateStoryStatus = null;
        PreparedStatement UpdateStoryLocation = null;
        PreparedStatement UpdateStoryPriority = null;
        PreparedStatement UpdateStoryOwner = null;
        PreparedStatement UpdateStoryTitle = null;
        PreparedStatement UpdateStoryDescription = null;

        public Story() {

            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                //SQl Statements
                insertStory = connection.prepareStatement("INSERT INTO Story_Table(Story_Title, Story_Owner, Story_Description, "
                        + "Story_Priority, Story_Date_Added, Story_Status, Story_Location, Story_BugNum ,Story_Unresolved_BugNum)"
                        + "VALUE (?, ?, ?, ?, ?, ?, ?,?,?)");

                selectStory = connection.prepareCall("SELECT Story_ID, Story_Title, Story_Owner, "
                        + "Story_Description, Story_Priority, Story_Date_Added,  Story_Status, Story_Updated, Story_Location, "
                        + "Story_BugNum ,Story_Unresolved_BugNum From Story_Table");

                selectStoryTitle = connection.prepareCall("SELECT Story_Title");

                //Story update
                UpdateStoryStatus = connection.prepareStatement("UPDATE Story_Table SET Story_Status = ? " + "WHERE Story_ID = ?");
                UpdateStoryLocation = connection.prepareStatement("UPDATE Story_Table SET Story_Location = ?" + "WHERE Story_ID = ?");
                UpdateStoryPriority = connection.prepareStatement("UPDATE Story_Table SET Story_Priority = ?" + "WHERE Story_ID = ?");
                UpdateStoryOwner = connection.prepareStatement("UPDATE Story_Table SET Story_Owner = ?" + "WHERE Story_ID = ?");
                UpdateStoryTitle = connection.prepareStatement("UPDATE Story_Table SET Story_Title = ?" + "WHERE Story_ID = ?");
                UpdateStoryDescription = connection.prepareStatement("UPDATE Story_Table SET Story_Description = ?" + "WHERE Story_ID = ?");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public String getUsername() {    
        return USERNAME; 
        }

        public int setStories(String title, String owner, String description, String priority, Timestamp timeStamp, String status, 
                                String location, String storyBugNum, String unresolvedBugNum) {
            int results = 0;
            try {
                insertStory.setString(1, title);
                insertStory.setString(2, owner);
                insertStory.setString(3, description);
                insertStory.setString(4, priority);
                insertStory.setTimestamp(5, timeStamp);
                insertStory.setString(6, status);           
                insertStory.setString(7, location);
                insertStory.setString(8, storyBugNum);
                insertStory.setString(9, unresolvedBugNum);
                
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

        public int UpdateStoryLocation(String UpdateStory_Location, String Story_ID) {
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

        int count = 0;
        public int getCount() {
            return count;
        }
        
        public void closeCONN() throws SQLException
        {
        user.connection.close();
        connection.close();
        }
    }   
%>



