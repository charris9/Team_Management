package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.util.*;

public final class Story_005fSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public class Story {

        String URL = "jdbc:mysql://teaminstantmanagement.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement";
        String USERNAME = "TeamIM";
        String PASSWORD = "BUCS673SPR";

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
                insertStory = connection.prepareStatement("INSERT INTO Story_Table(Story_Title, Story_Owner, Story_Description, "
                        + "Story_Priority, Story_Date_Added, Story_Status)"
                        + "VALUE (?, ?, ?, ?, ?, ?)");

                selectStory = connection.prepareCall("SELECT Story_ID, Story_Title, Story_Owner, "
                        + "Story_Description, Story_Priority, Story_Date_Added,  Story_Status, Story_Updated From Story_Table");

                selectStoryTitle = connection.prepareCall("SELECT Story_Title");

                //Story update
                UpdateStoryStatus = connection.prepareStatement("UPDATE Story_Table SET Story_Status = ? " + "WHERE Story_ID = ?");
                
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
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
      out.write("        <title>Searching DB</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        ");

            String storyTitle = null;
            String storyID = null;
            
            storyTitle=request.getParameter("search_title").toString();
            
            
            
            Story story = new Story();
            ResultSet stories = story.getStory();

            //iterate till end of DB
            while (stories.next()) {
                //if story title matches the search story title retrieve all info
                if (stories.getString("Story_Title").toString().trim().equals(storyTitle.trim())) {
        
      out.write("\n");
      out.write("        <h1>Story Found!</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Story Title: </td>\n");
      out.write("                    <td>");
      out.print( stories.getString("Story_Title"));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Owner: </td>\n");
      out.write("                    <td>");
      out.print( stories.getString("Story_Owner"));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Description: </td>\n");
      out.write("                    <td>");
      out.print( stories.getString("Story_Description"));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Priority: </td>\n");
      out.write("                    <td>");
      out.print( stories.getString("Story_Priority"));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Date Created </td>\n");
      out.write("                    <td>");
      out.print( stories.getString("Story_Date_Added"));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>Status: </td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print( stories.getString("Story_Status"));
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            \n");
      out.write("            <form name=\"Story_Edit\" action=\"StoryUpdate.jsp\" method=\"POST\">\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"submit\"\n");
      out.write("                           value=\"Update Story\" />\n");
      out.write("                    <input type=\"hidden\"\n");
      out.write("                           value=\"");
      out.print(stories.getString("Story_ID"));
      out.write("\"\n");
      out.write("                           name=\"search_story_ID\" />\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            <form name=\"Story_Cred\" action=\"Buglog.jsp\" method=\"POST\">\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"submit\" \n");
      out.write("                           value=\"View Buglog \"\n");
      out.write("                           name=\"search_story_id_submit\"  />\n");
      out.write("                                \n");
      out.write("                    <input type=\"hidden\" \n");
      out.write("                           value=\"");
      out.print(  stories.getString("Story_ID") );
      out.write(" \"\n");
      out.write("                           name=\"search_story_id\"  />\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                </td>\n");
      out.write("                ");
//story.closeCONN();
      out.write(" \n");
      out.write("            </form>\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    <table border=\"0\">\n");
      out.write("        <tbody>\n");
      out.write("        <td>\n");
      out.write("            <a href=\"Storylog_ViewDB.jsp\">\n");
      out.write("                <input type=\"button\" value=\"Back\" />\n");
      out.write("            </a>\n");
      out.write("        </td>\n");
      out.write("        <td>\n");
      out.write("            <a href=\"Storylog.jsp\">\n");
      out.write("                <input type=\"button\" value=\"Continue\" />\n");
      out.write("            </a>\n");
      out.write("        </td>\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    ");
}
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
story.closeCONN();
      out.write(" \n");
      out.write("</body>\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
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
