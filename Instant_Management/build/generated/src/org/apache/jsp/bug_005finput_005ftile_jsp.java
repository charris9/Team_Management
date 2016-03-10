package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class bug_005finput_005ftile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Bug Input</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 Date date = new Date(); 
      out.write("\n");
      out.write("            <div class=\"main-window\">\n");
      out.write("                <form name=\"bug_input\" action=\"bug_view_tile.jsp\" method=\"POST\">\n");
      out.write("                    <table border=\"1\">\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Bug Title: </td>\n");
      out.write("                                <td> <input type=\"text\" name=\"title\" value=\"\" size=\"35\" /> </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Bug Description: </td>\n");
      out.write("                                <td> <textarea name=\"description\" rows=\"4\" cols=\"35\">\n");
      out.write("                                    </textarea> </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Entered by: </td>\n");
      out.write("                                <td> <input type=\"text\" name=\"entered_by\" value=\"\" size=\"35\" /> </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Date Entered: </td>\n");
      out.write("                                <td> ");
 out.print(date); 
      out.write(" </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Priority: </td>\n");
      out.write("                                <td> <select name=\"priority\">\n");
      out.write("                                        <option> low </option>\n");
      out.write("                                        <option> medium </option>\n");
      out.write("                                        <option> high </option>\n");
      out.write("                                    </select> </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Difficulty: </td>\n");
      out.write("                                <td> <select name=\"difficulty\">\n");
      out.write("                                        <option> easy </option>\n");
      out.write("                                        <option> medium </option>\n");
      out.write("                                        <option> hard </option>\n");
      out.write("                                    </select> </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Responsible: </td>\n");
      out.write("                                <td> <select name=\"responsible\">\n");
      out.write("                                        <option> member 1 </option>\n");
      out.write("                                        <option> member 2 </option>\n");
      out.write("                                        <option> member 3 </option>\n");
      out.write("                                    </select> </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td> Resolved/Unresolved? </td>\n");
      out.write("                                <td> <select name=\"status\">\n");
      out.write("                                        <option> yes </option>\n");
      out.write("                                        <option> no </option>\n");
      out.write("                                    </select></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                            <input type=\"submit\" value=\"Submit\" name=\"submit\" class=\"button\" />\n");
      out.write("                            <input type=\"reset\" value=\"Clear Fields\" name=\"clear\" class=\"button\"/>\n");
      out.write("                </form>\n");
      out.write("                <form name=\"return\" action=\"user_story_tile.jsp\">\n");
      out.write("                        <input type=\"submit\" value=\"Cancel\" name=\"cancel\" class=\"button\"/>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
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
