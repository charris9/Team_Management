<%-- 
    Document   : Story_DBconfig
    Created on : Mar 8, 2016, 2:52:05 AM
    Author     : zawiramin
--%>

<%@page import = "java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%! public class Story {

        String URL = "jdbc:mysql://localhost:3306/Testing1";
        String USERNAME = "root";
        String PASSWORD = "1234";

        // initialize all variables
        Connection connection = null;
        PreparedStatement insertStory = null;
        PreparedStatement selectStory = null;
        PreparedStatement selectStoryTitle = null;
        ResultSet resultSet = null;
        String resultString = "";

        PreparedStatement UpdateStoryStatus = null;

        public Story() {

            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                //SQl Statements
                insertStory = connection.prepareStatement("INSERT INTO story_table(Story_Title, Story_Owner, Story_Description, "
                        + "Story_Priority, Story_Date_Added, Story_Status)"
                        + "VALUE (?, ?, ?, ?, ?, ?)");

                selectStory = connection.prepareCall("SELECT Story_ID, Story_Title, Story_Owner, "
                        + "Story_Description, Story_Priority, Story_Date_Added,  Story_Status, Story_Updated From story_table");

                selectStoryTitle = connection.prepareCall("SELECT Story_Title");

                //Story update
                UpdateStoryStatus = connection.prepareStatement("UPDATE story_table SET Story_Status = ? " + "WHERE Story_ID = ?");
                
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public int setStories(String title, String owner, String description, String priority, Timestamp timeStamp, String status) {
            int results = 0;
            try {
                insertStory.setString(1, title);
                insertStory.setString(2, owner);
                insertStory.setString(3, description);
                insertStory.setString(4, priority);
                insertStory.setTimestamp(5, timeStamp);
                insertStory.setString(6, status);           
                
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
    }  
%>



