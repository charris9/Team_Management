package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.util.*;

public final class Get_005fBug_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public  class Bug
         {
             String URL="jdbc:mysql://localhost/Testing";
             String USERNAME="root";
             String PASSWORD ="password";
             
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
                    connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    insertBug=connection.prepareStatement("INSERT INTO Buglog(Bug_Title, Bug_Owner,Bug_Description,Bug_Priority,Bug_Date_Added,Bug_Status)"
                        + "VALUES (?,?,?,?,?,?)");
                    selectBug = connection.prepareCall("SELECT Bug_ID, Bug_title, Bug_Owner,"
                        + "Bug_Description, Bug_Priority, Bug_Date_Added, Bug_Status From BugLog");
                    
                    selectBugTitle = connection.prepareCall("SELECT Bug_title");
                    
                 }
                 catch(SQLException e)
                 {
                     e.printStackTrace();
                 }
             }
             
            public int setBugs(String addBug_Title, String addBug_Owner, String addBug_Description, String addBug_Priority, Timestamp addBug_Date_Added, String addBug_Status)
            {
             int result=0;
             try {
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
         
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Bug_DBconfig.jsp");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
String bugTitle = request.getParameter("CGHJ");
      out.write("\n");
      out.write("        \n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td> Bug Title: </td>\n");
      out.write("                    <td> ");
      out.print( bugTitle );
      out.write(" </td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        <div class=\"main-window\">\n");
      out.write("        <h1>Bug Created!</h1>\n");
      out.write("        ");
 Bug bug = new Bug();
         ResultSet bugs=bug.getBug();
         String bug_title=bug.getBugTitle();
      out.write("\n");
      out.write("         \n");
      out.write("         ");
 if (bug_title == bugTitle ) { 
      out.write("\n");
      out.write("       <table border=\"1\">\n");
      out.write("                \n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Bug Title: </td>\n");
      out.write("                        <td>");
      out.print( bugs.getString("Bug_Title") );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Owner: </td>\n");
      out.write("                        <td>");
      out.print( bugs.getString("Bug_Owner") );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Description: </td>\n");
      out.write("                        <td>");
      out.print( bugs.getString("Bug_Description") );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Priority:</td>\n");
      out.write("                        <td>");
      out.print( bugs.getString("Bug_Priority") );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Current Status:</td>\n");
      out.write("                        <td>");
      out.print( bugs.getString("Bug_Status") );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Date Created:</td>\n");
      out.write("                        <td>");
      out.print( bugs.getString("Bug_Date_Added") );
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        \n");
      out.write("         ");
 } 
      out.write("   \n");
      out.write("          \n");
      out.write("                    <a href=\"Bug_Create_Insert.jsp\">\n");
      out.write("                    <input type=\"button\" value=\"Add Another Bug\"/>\n");
      out.write("                    </a>\n");
      out.write("         \n");
      out.write("                    <a href=\"Buglog.jsp\">\n");
      out.write("                    <input type=\"button\" value=\"Continue\"/>\n");
      out.write("                    </a>\n");
      out.write("                      \n");
      out.write("</body>\n");
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
