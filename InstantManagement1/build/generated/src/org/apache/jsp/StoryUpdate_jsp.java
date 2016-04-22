package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.util.*;

public final class StoryUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public class Story {

        String URL = "jdbc:mysql://localhost:3306/Testing1";
        String USERNAME = "root";
        String PASSWORD = "1234";

//        String URL = "jdbc:mysql://teaminstantmanagement.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement";
//        String USERNAME = "TeamIM";
//        String PASSWORD = "BUCS673SPR";

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
                        + "Story_Priority, Story_Date_Added, Story_Status, Story_Location)"
                        + "VALUE (?, ?, ?, ?, ?, ?, ?)");

                selectStory = connection.prepareCall("SELECT Story_ID, Story_Title, Story_Owner, "
                        + "Story_Description, Story_Priority, Story_Date_Added,  Story_Status, Story_Updated, Story_Location From Story_Table");

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

        public int setStories(String title, String owner, String description, String priority, Timestamp timeStamp, String status, String location) {
            int results = 0;
            try {
                insertStory.setString(1, title);
                insertStory.setString(2, owner);
                insertStory.setString(3, description);
                insertStory.setString(4, priority);
                insertStory.setTimestamp(5, timeStamp);
                insertStory.setString(6, status);           
                insertStory.setString(7, location);    
                
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

public void closeCONN() throws SQLException
{
    connection.close();
}


}  

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Story_DBconfig.jsp");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Story Updating</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        String storyID = request.getParameter("search_story_ID").toString();
        String Story_Title = null;
        String Story_Description = null;
        String Story_Owner = null;
        String Story_Priority = null;
        String Story_Status = null;
        String Date_Added = null;
        String Date_Updated = null;
        String Story_Location = null;
        
        String Status1 = null;
        String Status2 = null;

        String Priority1=null;
        String Priority2=null;
        String Priority3=null;

        
        String Location1 = null;
        String Location2 = null;
        String Location3 = null;
        String Header = null;
        //String UserName = null;

        Story story = new Story();
        ResultSet StoryRetrieve = story.getStory();
        //ResultSet UserRetrieve = story.user.getUser();

        while (StoryRetrieve.next()) {
            if (StoryRetrieve.getString("Story_ID").toString().trim().equals(storyID.trim())) {
                Story_Title = StoryRetrieve.getString("Story_Title");
                Story_Owner = StoryRetrieve.getString("Story_Owner");
                Story_Description = StoryRetrieve.getString("Story_Description");
                Story_Priority = StoryRetrieve.getString("Story_Priority");
                Story_Status = StoryRetrieve.getString("Story_Status");
                Date_Added = StoryRetrieve.getString("Story_Date_Added");
                Date_Updated = StoryRetrieve.getString("Story_Updated");
                Story_Location = StoryRetrieve.getString("Story_Location");
            }
        }
    
      out.write("\n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("    <form name=\"Story_Update\" action=\"StoryUpdate.jsp\" method=\"POST\">\n");
      out.write("        ");

            if (request.getParameter("Update_Values") == null) {
                Header = Story_Title;
            } else {
                Header = new String("UPDATING");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <h1>");
      out.print(Header);
      out.write("</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Story Title: </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(Story_Title );
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"text\" name=\"UpdateStoryTitle\" placeholder=\"Update the title if needed...\" value=\"\" size=\"30\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Owner: </td>\n");
      out.write("                    <td>                        \n");
      out.write("                        ");
      out.print(Story_Owner);
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"text\" name=\"UpdateStoryOwner\" placeholder=\"Change Owner's Name...\" value=\"\" size=\"20\" />                        \n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Description: </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(Story_Description);
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"text\" name=\"UpdateStoryDescription\" placeholder=\"Change description if needed...\" value=\"\" size=\"50\" />                                            \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Priority:  </td>\n");
      out.write("                    <td>");
      out.print(Story_Priority);
      out.write("\n");
      out.write("                    <select name=\"UpdateStoryPriority\">\n");
      out.write("                        ");

                            if(Story_Priority.equals("Low"))
                            {
                                Priority1="Low";
                                Priority2="Medium";
                                Priority3="Hard";
                            }
                            if(Story_Priority.equals("Medium"))
                            {
                                Priority1="Medium";
                                Priority2="Low"; 
                                Priority3="Hard";
                            }
                            if(Story_Priority.equals("Hard"))
                            { 
                                Priority1="Hard";
                                Priority2="Low";
                                Priority3="Medium";
                            }   
                        
      out.write("\n");
      out.write("                        <option>");
      out.print(Priority1);
      out.write(" </option>\n");
      out.write("                        <option>");
      out.print(Priority2);
      out.write("</option> \n");
      out.write("                        <option>");
      out.print(Priority3);
      out.write("</option> \n");
      out.write("                    </select>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Status:  </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(Story_Status);
      out.write("\n");
      out.write("                        <select name=\"UpdateStoryStatus\">\n");
      out.write("                            ");

                                if (Story_Status.equals("NOT DELIVER")) {
                                    Status1 = "NOT DELIVER";
                                    Status2 = "DELIVERED";
                                }
                                if (Story_Status.equals("DELIVERED")) {
                                    Status1 = "DELIVERED";
                                    Status2 = "NOT DELIVER";
                                }
                            
      out.write("\n");
      out.write("                            <option>");
      out.print(Status1);
      out.write("</option>\n");
      out.write("                            <option>");
      out.print(Status2);
      out.write("</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Date Created: </td>\n");
      out.write("                    <td>");
      out.print( Date_Added );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Date Updated: </td>\n");
      out.write("                    <td>");
      out.print(Date_Updated );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Location:  </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print(Story_Location);
      out.write("\n");
      out.write("                        <select name=\"UpdateStoryLocation\">\n");
      out.write("                            ");

                                if (Story_Location.equals("ICEBOX")) {
                                    Location1 = "ICEBOX";
                                    Location2 = "CURRENT";
                                    Location3 = "DONE";
                                }
                                if (Story_Location.equals("CURRENT")) {
                                    Location1 = "CURRENT";
                                    Location2 = "ICEBOX";
                                    Location3 = "DONE";
                                }
                                if (Story_Location.equals("DONE")) {
                                    Location1 = "DONE";
                                    Location2 = "ICEBOX";
                                    Location3 = "CURRENT";
                                }
                            
      out.write("\n");
      out.write("                            <option>");
      out.print(Location1);
      out.write("</option>\n");
      out.write("                            <option>");
      out.print(Location2);
      out.write("</option>\n");
      out.write("                            <option>");
      out.print(Location3);
      out.write("</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>  \n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(storyID );
      out.write("\" name=\"search_story_ID\" />\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(Story_Title );
      out.write("\" name=\"DB_StoryTitle\" />\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(Story_Owner );
      out.write("\" name=\"DB_StoryOwner\" />\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(Story_Description );
      out.write("\" name=\"DB_StoryDescription\" />\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(Story_Priority );
      out.write("\" name=\"DB_StoryPriority\" />\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(Story_Status );
      out.write("\" name=\"DB_StoryStatus\" />\n");
      out.write("        <input type=\"hidden\" value=\"");
      out.print(Story_Location );
      out.write("\" name=\"DB_StoryLocation\" />\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        <input type=\"submit\" value=\"Save\" name=\"Update_Values\" />\n");
      out.write("        <a href=\"Storylog_ViewDB.jsp\">\n");
      out.write("            <input type=\"button\" value=\"Back\" />\n");
      out.write("        </a>\n");
      out.write("        ");

            if (request.getParameter("Update_Values") != null) {            
        
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            document.forms[\"Story_Update\"].submit();\n");
      out.write("        </script>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("    </form>\n");
      out.write("    ");

        if (request.getParameter("Update_Values") != null) {
                       
            if (!request.getParameter("UpdateStoryStatus").equals(Story_Status)) {
                story.UpdateStoryStatus(request.getParameter("UpdateStoryStatus"), storyID);

            } 
            if (!request.getParameter("UpdateStoryLocation").equals(Story_Location)) {
                story.UpdateStoryLocation(request.getParameter("UpdateStoryLocation"), storyID);
            }
            
            if (!request.getParameter("UpdateStoryPriority").equals(Story_Priority)) {
                story.UpdateStoryPriority(request.getParameter("UpdateStoryPriority"), storyID);

            }             

            if (!request.getParameter("UpdateStoryOwner").equals(Story_Owner)) {
                story.UpdateStoryOwner(request.getParameter("UpdateStoryOwner"), storyID);

            }             

            if (!request.getParameter("UpdateStoryTitle").equals(Story_Title)) {
                story.UpdateStoryTitle(request.getParameter("UpdateStoryTitle"), storyID);

            }             

            if (!request.getParameter("UpdateStoryDescription").equals(Story_Description)) {
                story.UpdateStoryDescription(request.getParameter("UpdateStoryDescription"), storyID);

            }             
            
            
        }

      out.write("            \n");
      out.write("\n");
story.closeCONN();
      out.write(" \n");
      out.write("</html >\n");
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
