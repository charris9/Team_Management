<%-- 
    Document   : Bud_DBconfig
    Created on : Feb 18, 2016, 8:26:33 PM
    Author     : caseyharris
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! public  class Bug
         {
             String URL="jdbc:mysql://localhost/Testing";
             String USERNAME="root";
             String PASSWORD ="password";
             
             Connection connection = null;
             PreparedStatement insertBug = null;
             PreparedStatement selectBug = null;
             ResultSet resultSet = null;
             
             public Bug()
             {
                 try
                 {
                    connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    insertBug=connection.prepareStatement("INSERT INTO Buglog(Bug_Title, Bug_Owner,Bug_Description,Bug_Priority,Bug_Date_Added)"
                        + "VALUES (?,?,?,?,?)");
                    selectBug = connection.prepareCall("SELECT Bug_ID, Bug_title, Bug_Owner, Bug_Description, Bug_Priority, Bug_Date_Added From BugLog");
                     
                 }
                 catch(SQLException e)
                 {
                     e.printStackTrace();
                 }
             }
             
            public int setBugs(String addBug_Title, String addBug_Owner, String addBug_Description, String addBug_Priority, Timestamp addBug_Date_Added)
            {
             int result=0;
             try {
                insertBug.setString(1, addBug_Title);
                insertBug.setString(2, addBug_Owner);
                insertBug.setString(3, addBug_Description);
                insertBug.setString(4, addBug_Priority);
                insertBug.setTimestamp(5, addBug_Date_Added);
                result = insertBug.executeUpdate();
                }   
                catch(SQLException e)
                {
                e.printStackTrace();
                }
            return result;
            }
        
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




             
         }
         %>