package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class DBTest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


         public  class Bug
         {
             String URL="jdbc:mysql://localhost/Testing";
             String USERNAME="root";
             String PASSWORD ="password";
             
             Connection connection = null;
             PreparedStatement selectBug = null;
             ResultSet resultSet = null;
             
             public Bug()
             {
                 try
                 {
                    connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    selectBug = connection.prepareCall("SELECT Bug_title, Bug_Owner From BugLog");
                }
                 catch(SQLException e)
                 {
                     e.printStackTrace();
                 }
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
      out.write('\n');
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>TestDBPage</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Selecting Data From a DB</h1>\n");
      out.write("        ");
      out.write("\n");
      out.write("         \n");
      out.write("         ");

         Bug bug = new Bug();
         ResultSet bugs=bug.getBug();
      out.write("\n");
      out.write("         <table border=\"1\">\n");
      out.write("                     <tbody>\n");
      out.write("                         <tr>\n");
      out.write("                             <td>Title</td>\n");
      out.write("                             <td>Owner</td>\n");
      out.write("                         </tr>\n");
      out.write("                         \n");
      out.write("                         ");
 while (bugs.next()) { 
      out.write("\n");
      out.write("                         <tr>\n");
      out.write("                              <td>");
      out.print( bugs.getString("Bug_Title") );
      out.write("</td>\n");
      out.write("                             <td>");
      out.print( bugs.getString("Bug_Owner") );
      out.write("</td>\n");
      out.write("                         </tr>\n");
      out.write("                         ");
}
      out.write("\n");
      out.write("                     </tbody>\n");
      out.write("         </table>\n");
      out.write("\n");
      out.write("         \n");
      out.write("    </body>\n");
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
