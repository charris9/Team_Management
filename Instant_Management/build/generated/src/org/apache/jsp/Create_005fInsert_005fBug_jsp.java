package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.Date;

public final class Create_005fInsert_005fBug_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


         public  class Bug
         {
             String URL="jdbc:mysql://localhost/Testing";
             String USERNAME="root";
             String PASSWORD ="password";
             
             Connection connection = null;
             PreparedStatement insertBug = null;
             ResultSet resultSet = null;
             
             public Bug()
             {
                 try
                 {
                    connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    insertBug=connection.prepareStatement("INSERT INTO Buglog(Bug_Title, Bug_Owner,Bug_Description,Bug_Priority,Bug_Date_Added)"
                        + "VALUES (?,?,?,?,?)");
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
             
         }
         
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>TestInsert</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body onload=\"displayResults()\">\n");
      out.write("        <h1>Insert Data into a DB</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("         \n");
      out.write("        ");

            int results=0;
            
            if(request.getParameter("Submit")!=null)
            {
            String bug_title= new String();
            String bug_owner = new String();
            String bug_description= new String();
            String bug_priority = new String();
            
            
            
            if(request.getParameter("bug_title") != null)
            {
                bug_title = request.getParameter("bug_title");
            }
            if(request.getParameter("bug_owner") != null)
            {
                bug_owner = request.getParameter("bug_owner");
            }
            if(request.getParameter("bug_description") != null)
            {
                bug_description = request.getParameter("bug_description");
            }
            if(request.getParameter("bug_priority") != null)
            {
                bug_priority = request.getParameter("bug_priority");
            }
            
           
            Date date =new Date();
            Timestamp bug_timestamp = new Timestamp(date.getTime());
            Bug addBug = new Bug();
            
            results=addBug.setBugs(bug_title, bug_owner, bug_description, bug_priority, bug_timestamp);
            } 
        
      out.write("\n");
      out.write("      <form name= \"myform\" action=\"Create_Insert_Bug.jsp\" method=\"POST\">\n");
      out.write("              <table border=\"0\">\n");
      out.write("                \n");
      out.write("                <tbody> \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Bug Title : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"bug_title\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Owner: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"bug_owner\" value=\"\" size=\"50\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Bug Description: </td>\n");
      out.write("                        <td><textarea name=\"bug_description\" rows=\"8\" cols=\"48\" >\n");
      out.write("                            </textarea></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Select Priority</td>\n");
      out.write("                        <td><select name=\"bug_priority\">\n");
      out.write("                                <option>Easy</option>\n");
      out.write("                                <option>Medium</option>\n");
      out.write("                                <option>Hard</option>\n");
      out.write("                                <option>");
      out.print(results);
      out.write("</option>\n");
      out.write("                            </select></td>\n");
      out.write("                    </tr>\n");
      out.write("                  \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            <a href=\"Buglog.jsp\">\n");
      out.write("            <input type=\"button\" value=\"Cancel\" />\n");
      out.write("            </a>\n");
      out.write("            \n");
      out.write("            <input type=\"hidden\" name=\"hidden\" value=\"");
      out.print( results);
      out.write("\" />\n");
      out.write("            <input type=\"reset\" value=\"Clear\" name=\"Clear\" />\n");
      out.write("            <input type=\"submit\" value=\"Sumbit\" name=\"Submit\"  />\n");
      out.write("          \n");
      out.write("            \n");
      out.write("    \n");
      out.write("        </form>   \n");
      out.write("    \n");
      out.write("        <script LANGUAGE = \"JavaScript\"> \n");
      out.write("               \n");
      out.write("                    function displayResults()\n");
      out.write("                    \n");
      out.write("                    {\n");
      out.write("                        if(document.myform.hidden.value == 1)\n");
      out.write("                        {\n");
      out.write("                        alert(\"data inserted\");  \n");
      out.write("                        location='Bug_Display.jsp';     \n");
      out.write("                         }\n");
      out.write("                    }\n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("                    </script> \n");
      out.write("    \n");
      out.write("   </html>\n");
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
