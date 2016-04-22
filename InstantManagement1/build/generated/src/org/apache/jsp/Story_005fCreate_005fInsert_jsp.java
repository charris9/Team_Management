package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.*;
import java.util.Date;

public final class Story_005fCreate_005fInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public class User
{
    
    String URL = "jdbc:mysql://localhost:3306/Testing1";
    String USERNAME = "root";
    String PASSWORD = "1234";    

//    String URL="jdbc:mysql://teaminstantmanagement.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement";//jdbc:mysql://localhost:3306/Testing";
//    String USERNAME="TeamIM";//"root";//TeamIM
//    String PASSWORD ="BUCS673SPR";//password";//BUCS673SPR
   
    //String URL2="jdbc:mysql://localhost:3306/Testing";
    //String USERNAME2="root";//TeamIM
    //String PASSWORD2 ="password";//BUCS673SPR

    // intialization of all variables
    Connection connection = null;
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
        // used to create a connection to the Database\
    
        //Class.forName("org.postgresql.Driver");
        connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
        /*
        all prepared statements are defined here
        Criteria to add new prepared statement:
        1) Create unique variable at the top of the bug class
        2) Create a connect.prepareStatement(what the variable will do)
        3) Create method that uses the new variable
        */

//SQl Statements------------------------User---------------------------------
        insertUser=connection.prepareStatement("INSERT INTO User(User_Name)"
        + "VALUES (?)"); 

        selectUser = connection.prepareStatement("SELECT User_ID, User_Name From User");
        UpdateUserName = connection.prepareStatement("UPDATE User SET User_Name = ? " + "WHERE User_ID = ? ");
        



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


public void closeCONN() throws SQLException
{
    connection.close();
}



}

 public class Story {

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
                        + "Story_Priority, Story_Date_Added, Story_Status, Story_Location/**, Story_BugNum ,Story_Unresolved_BugNum)"
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

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Story_DBconfig.jsp");
    _jspx_dependants.add("/User_DBconfig.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
//@page import="com.mysql.jdbc.Driver"
      out.write('\n');
//@page import="com.mysql.jdbc.log.*"
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<head></head>\n");
      out.write("\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<head></head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Inserting Story</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <div class=\"main-window\">    \n");
      out.write("        <body onload=\"displayResults()\">\n");
      out.write("\n");
      out.write("        <h1>Inserting Story Into A DB</h1>\n");
      out.write("\n");
      out.write("            ");

                int results = 0;
                String story_title = new String();
                String story_owner = new String();
                String story_description = new String();
                String story_priority = new String();
                String story_status = new String();
                String story_location = new String();
                String story_BugNum = new String();
                String unresolved_BugNum = new String();

                Story addStory = new Story();


                if (request.getParameter("Submit") != null) {                                

                    if (request.getParameter("title") != null) {
                        story_title = request.getParameter("title");
                    }
                    if (request.getParameter("owner") != null) {
                        story_owner = request.getParameter("owner");
                    }
                    if (request.getParameter("description") != null) {
                        story_description = request.getParameter("description");
                    }
                    if (request.getParameter("priority") != null) {
                        story_priority = request.getParameter("priority");
                    }
                    if (request.getParameter("status") != null) {
                        story_status = request.getParameter("status");
                    }
                    if (request.getParameter("location") != null) {
                        story_location = request.getParameter("location");
                    }
                    if (request.getParameter("storyBugNum") != null) {
                        story_BugNum = request.getParameter("storyBugNum");
                    }
                    if (request.getParameter("unresolvedBugNum") != null) {
                        unresolved_BugNum = request.getParameter("unresolvedBugNum");
                    }
                    
                    Date date = new Date();
                    Timestamp timeStamp = new Timestamp(date.getTime());

                    story_status = "NOT DELIVER";
                    story_location = "ICEBOX";

                    results = addStory.setStories(story_title, story_owner, story_description, story_priority, timeStamp, story_status, story_location, story_BugNum, unresolved_BugNum);

                }
            
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <form name=\"myForm\" action=\"Story_Create_Insert.jsp\" method=\"POST\">\n");
      out.write("\n");
      out.write("                <table border=\"1\">\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Story Title: </td>\n");
      out.write("                            <td><input type=\"text\" name=\"title\" placeholder=\"Story title\" value=\"\" size=\"50\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Owner : </td>\n");
      out.write("                            <td><input type=\"text\" name=\"owner\" placeholder=\"Insert Owner's Name...\" value=\"\" size=\"50\" /></td>                        \n");
      out.write("                        </tr>                    \n");
      out.write("                        <tr>                    \n");
      out.write("                            <td>Description : </td>                        \n");
      out.write("                            <td>                        \n");
      out.write("                                <input type=\"text\" name=\"description\" placeholder=\"Describe your story in details...\" value=\"\" size=\"50\" >                            \n");
      out.write("                                \n");
      out.write("                            </td>                        \n");
      out.write("                        </tr>                    \n");
      out.write("                        <tr>                    \n");
      out.write("                            <td>Select Priority</td>                        \n");
      out.write("                            <td>\n");
      out.write("                                <select name=\"priority\">                        \n");
      out.write("                                    <option>Select Priority</option>                                \n");
      out.write("                                    <option>Low</option>                                \n");
      out.write("                                    <option>Medium</option>                                \n");
      out.write("                                    <option>Hard</option>                                \n");
      out.write("                                </select>                            \n");
      out.write("                            </td>                        \n");
      out.write("                        </tr>                    \n");
      out.write("                    </tbody>                \n");
      out.write("                </table>          \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                <table border=\"0\">                    \n");
      out.write("                    <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <a href=\"Storylog.jsp\">\n");
      out.write("                                        <input type=\"button\" value=\"Back\" name=\"Back\" />\n");
      out.write("                                    </a> \n");
      out.write("                                </td>\n");
      out.write("                                <td><input type=\"reset\" value=\"Clear\" name=\"Clear\" /></td>\n");
      out.write("                                <td><input type=\"submit\" value=\"Submit\" name=\"Submit\" /></td>\n");
      out.write("                                <td><input type=\"hidden\" name=\"hidden\" value=\"");
      out.print( results);
      out.write("\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>             \n");
      out.write("                    <table/>\n");
      out.write("            </form>\n");
      out.write("                                    \n");
      out.write("            <script LANGUAGE = \"JavaScript\">\n");
      out.write("                function displayResults() {\n");
      out.write("                    if (document.myForm.hidden.value == 1) {\n");
      out.write("                        location = 'Story_Display.jsp';\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>                                                              \n");
      out.write("    ");
addStory.closeCONN();
      out.write("\n");
      out.write("    </div>\n");
      out.write("    </html>\n");
      out.write("    ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
