package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>User Registration</title>\n");
      out.write("    \t<link rel=\"stylesheet\" type=\"text/css\" href=\"images/styles.css\">\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\t    \tfunction reg(form){\n");
      out.write("\t        \tif(form.username.value === \"\"){\n");
      out.write("\t        \t\talert(\"Username can't be void！\");\n");
      out.write("\t        \t\treturn false;\n");
      out.write("\t        \t}\n");
      out.write("\t        \tif(form.password.value === \"\"){\n");
      out.write("\t        \t\talert(\"Username can't be void！\");\n");
      out.write("\t        \t\treturn false;\n");
      out.write("\t        \t}\n");
      out.write("\t        \tif(form.repassword.value === \"\"){\n");
      out.write("\t        \t\talert(\"Please re-enter the password!\");\n");
      out.write("\t        \t\treturn false;\n");
      out.write("\t        \t}\n");
      out.write("\t        \tif(form.password.value !== form.repassword.value){\n");
      out.write("\t        \t\talert(\"Passwords don't match!\");\n");
      out.write("\t        \t\treturn false;\n");
      out.write("\t        \t}\n");
      out.write("\n");
      out.write("\t        \tif(form.email.value === \"\"){\n");
      out.write("\t        \t\talert(\"Email can't be void！\");\n");
      out.write("\t        \t\treturn false;\n");
      out.write("\t        \t}\n");
      out.write("\t    \t}\n");
      out.write("\t    \tfunction change(){\n");
      out.write("\t\t\t\tvar photo = document.getElementById(\"photo\");\n");
      out.write("\t\t\t\tvar photoImg = document.getElementById(\"photoImg\");\n");
      out.write("\t\t\t\tphotoImg.src = photo.value;\n");
      out.write("\t    \t}\n");
      out.write("\t    </script>\n");
      out.write("  </head>\n");
      out.write("  \n");
      out.write("  <body>\n");
      out.write("  \t <div align=\"center\">\n");
      out.write("\t\t  \t<div class=\"div1\">\n");
      out.write("\t\t  \t\t<div class=\"top\">User Registration</div>\n");
      out.write("\t\t  \t\t<div class=\"bottom\">\n");
      out.write("\t\t\t\t\t<div class=\"div2\">\n");
      out.write("\t\t\t\t  \t\t<ul>\n");
      out.write("\t\t\t\t  \t\t\t<li><a href=\"reg.jsp\">Registration</a></li>\n");
      out.write("\t\t\t\t  \t\t\t<li><a href=\"login.jsp\">Login</a></li>\n");
      out.write("\t\t\t\t  \t\t\t<li><a href=\"message.jsp\">User Info</a></li>\n");
      out.write("\t\t\t\t  \t\t\t<li><a href=\"ExitServlet\">Exit</a></li>\n");
      out.write("\t\t\t\t  \t\t</ul>\n");
      out.write("\t\t\t\t  \t</div>\n");
      out.write("\t\t\t\t  \t <div class=\"div3\"> \n");
      out.write("\t\t\t\t\t    <form action=\"RegServlet\" method=\"post\" onsubmit=\"return reg(this);\">\n");
      out.write("\t\t\t\t\t\t    <table align=\"center\" width=\"450\" border=\"0\">\n");
      out.write("\t\t\t\t\t\t    \t<tr>\n");
      out.write("\t\t\t\t\t\t    \t\t<td align=\"right\">Username：</td>\n");
      out.write("\t\t\t\t\t\t    \t\t<td>\n");
      out.write("\t\t\t\t\t\t    \t\t\t<input type=\"text\" name=\"username\">\n");
      out.write("\t\t\t\t\t\t    \t\t</td>\n");
      out.write("\t\t\t\t\t\t    \t</tr>\n");
      out.write("\t\t\t\t\t\t    \t<tr>\n");
      out.write("\t\t\t\t\t\t    \t\t<td align=\"right\">Password: </td>\n");
      out.write("\t\t\t\t\t\t    \t\t<td>\n");
      out.write("\t\t\t\t\t\t    \t\t\t<input type=\"password\" name=\"password\">\n");
      out.write("\t\t\t\t\t\t    \t\t</td>\n");
      out.write("\t\t\t\t\t\t    \t</tr>\n");
      out.write("\t\t\t\t\t\t    \t<tr>\n");
      out.write("\t\t\t\t\t\t    \t\t<td align=\"right\">Re-enter Password:</td>\n");
      out.write("\t\t\t\t\t\t    \t\t<td>\n");
      out.write("\t\t\t\t\t\t    \t\t\t<input type=\"password\" name=\"repassword\">\n");
      out.write("\t\t\t\t\t\t    \t\t</td>\n");
      out.write("\t\t\t\t\t\t    \t</tr>\n");
      out.write("\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t    \t<tr>\n");
      out.write("\t\t\t\t\t\t    \t\t<td align=\"right\">Email：</td>\n");
      out.write("\t\t\t\t\t\t    \t\t<td>\n");
      out.write("\t\t\t\t\t\t    \t\t\t<input type=\"text\" name=\"email\">\n");
      out.write("\t\t\t\t\t\t    \t\t</td>\n");
      out.write("\t\t\t\t\t\t    \t</tr>\n");
      out.write("\t\t\t\t\t\t    \t<tr>\n");
      out.write("\t\t\t\t\t\t    \t\t<td colspan=\"2\" align=\"center\">\n");
      out.write("\t\t\t\t\t\t    \t\t\t<input type=\"submit\" value=\"Enter\">\n");
      out.write("\t\t\t\t\t\t    \t\t\t<input type=\"reset\" value=\"Reset\">\n");
      out.write("\t\t\t\t\t\t    \t\t</td>\n");
      out.write("\t\t\t\t\t\t    \t</tr>\n");
      out.write("\t\t\t\t\t\t    </table>\n");
      out.write("\t\t\t\t\t    </form>\n");
      out.write("\t\t\t\t  \t </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t  \t</div>\n");
      out.write("\t  </div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
