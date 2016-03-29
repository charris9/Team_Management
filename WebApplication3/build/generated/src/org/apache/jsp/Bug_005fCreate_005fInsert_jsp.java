package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.Date;

public final class Bug_005fCreate_005fInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write('\n');
//@include file ="Bug_DBconfig.jsp"
      out.write('\n');
//@page import="com.mysql.jdbc.Driver"
      out.write('\n');
//@page import="com.mysql.jdbc.log.*"
      out.write("\n");
      out.write("\n");
      out.write("\n");
//@ page import="test.*"
      out.write('\n');
Class.forName("com.mysql.jdbc.Driver");
      out.write('\n');
//Class.forName("com.mysql.jdbc.log.LogFactory.getLogger");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Inserting</title>\n");
      out.write("    </head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">\n");
      out.write("    \n");
      out.write("    <body >\n");
      out.write("    <div class=\"main-window\">\n");
      out.write("    <h1>Insert Data into a DB</h1>  \n");
      out.write("    \n");
      out.write("    ");
//<link rel="stylesheet" href="style.css" type="text/css">
        //onload="displayResults()"
        int results=0; 
       // Bug addBug = null;
        //addBug=new Bug();
        
        String URL="jdbc:mysql://teamim.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement";//jdbc:mysql://localhost:3306/Testing";

        String USERNAME="TeamIM";//"root";//TeamIM
        String PASSWORD ="BUCS673SPR";//password";//BUCS673SPR
    //User user = new User();
    
        ResultSet rs = null;
        Connection conn=null;
    
        //Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //String jdbcUrl = "jdbc:mysql://teamim.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement" + "?user=" + USERNAME + "&password=" + PASSWORD;
      //logger.trace("Getting remote connection with connection string from environment variables.");
      
      //Connection con = DriverManager.getConnection(jdbcUrl);
      //Connection con = DriverManager.getConnection(jdbcUrl);
      //logger.info("Remote connection successful.");
        //Statement stmt = connection.createStatement();
         //String sql = "SELECT * From Buglog";
        //rs  = stmt.executeQuery(sql);
        //ResultSet Userretrieve = new Bug().getBug();
        String UserName=null;
            //Class.forName("com.mysql.jdbc.Driver
         
                    
                    
           /*
            if(request.getParameter("Submit")!=null)
            {
            //ResultSet testuser = addBug.getBug();//.getUser();
              
            String bug_title= new String();
            String bug_owner = new String();
            String bug_description= new String();
            String bug_priority = new String();
            String bug_status = new String();
            
           
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
            if(request.getParameter("bug_status") != null)
            {
                bug_priority = request.getParameter("bug_status");
            }
           
            Date date =new Date();
            Timestamp bug_timestamp = new Timestamp(date.getTime());
            
            bug_status="INCOMPLETE";
            //Bug addBug = new Bug();
            //ResultSet Userretrieve=addBug.user.getUser();
            
            
            results=addBug.setBugs(bug_title, bug_owner, bug_description, bug_priority, bug_timestamp, bug_status);
            
            
            } */
        
      out.write("\n");
      out.write("     \n");
      out.write("        \n");
      out.write("        <form name= \"myform\" action=\"Bug_Create_Insert.jsp\" method=\"POST\">\n");
      out.write("        \n");
      out.write(" \n");
      out.write("              <table border=\"0\">\n");
      out.write("                \n");
      out.write("                <tbody> \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Bug Title : </td>\n");
      out.write("                        <td><input type=\"text\" name=\"bug_title\" value=\"\" size=\"50\"  /></td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Owner: </td>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <td>\n");
      out.write("                        \n");
      out.write("                            <select name=\"bug_owner\">\n");
      out.write("                                  <option></option>\n");
      out.write("                                  <option>Casey</option>\n");
      out.write("                                ");

                                    
                                   // while (Userretrieve.isClosed()) 
                                    {
                                        
                                        {
                                            UserName= "addBug.getBugTitle()";// Userretrieve.; 
                                
      out.write(" \n");
      out.write("                                            <option>");
      out.print(UserName );
      out.write("</option>\n");
      out.write("                                ");
      }
                                    }
                                
      out.write(" \n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Bug Description: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"bug_description\" value = \"\" size=\"50\"   /></td>\n");
      out.write("                    </tr>\n");
      out.write("                \n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td>Select Priority</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"bug_priority\">\n");
      out.write("                                <option></option>\n");
      out.write("                                <option>Easy</option>\n");
      out.write("                                <option>Medium</option>\n");
      out.write("                                <option>Hard</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                  \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <a href=\"Buglog.jsp\">\n");
      out.write("                <input type=\"button\" value=\"Cancel\" />\n");
      out.write("            </a>\n");
      out.write("            \n");
      out.write("            <input type=\"hidden\" name=\"hidden\" value=\"");
      out.print( results);
      out.write("\" />\n");
      out.write("            <input type=\"reset\" value=\"Clear\" name=\"Clear\" />\n");
      out.write("            <input type=\"submit\" value=\"Sumbit\" name=\"Submit\"  />\n");
      out.write("          </div>  \n");
      out.write("           \n");
      out.write("    \n");
      out.write("        </form>   \n");
      out.write("           \n");
      out.write("            \n");
      out.write("        <script LANGUAGE = \"JavaScript\"> \n");
      out.write("               \n");
      out.write("                    function displayResults()\n");
      out.write("                    \n");
      out.write("                    {\n");
      out.write("                        if(document.myform.hidden.value == 1)\n");
      out.write("                        {\n");
      out.write("                        //location='Bug_Display.jsp';     \n");
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
