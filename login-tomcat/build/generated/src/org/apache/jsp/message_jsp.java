package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.IM.User;

public final class message_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<head>\n");
      out.write("\t\t<title>Message</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"images/styles.css\">\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("\t\t<div align=\"center\">\n");
      out.write("\t\t  \t<div class=\"div1\">\n");
      out.write("\t\t  \t\t<div class=\"top\">Message</div>\n");
      out.write("\t\t  \t\t<div class=\"bottom\">\n");
      out.write("\t\t\t\t\t<div class=\"div2\">\n");
      out.write("\t\t\t\t  \t\t<ul>\n");
      out.write("\t\t\t\t  \t\t\t\n");
      out.write("\t\t\t\t  \t\t\t\n");
      out.write("\t\t\t\t  \t\t\t\n");
      out.write("\t\t\t\t  \t\t\t<li><a href=\"logout.jsp\">Exit</a></li>\n");
      out.write("                                                        <li></li>\n");
      out.write("\t\t\t\t  \t\t</ul>\n");
      out.write("\t\t\t\t  \t</div>\n");
      out.write("\t\t\t\t  \t <div class=\"div3\"> \n");
      out.write("\t\t\t\t\t    ");
 
					    	
							String info = (String)request.getAttribute("info");
					    	
							if(info != null){
								out.println(info);
							}
					    	
							User user = (User)session.getAttribute("user");
					    	
							if(user != null){
						
      out.write("\n");
      out.write("\t\t\t\t\t\t<table align=\"center\" width=\"350\" border=\"1\" height=\"200\" bordercolor=\"#E8F4CC\">\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t    \t\t<td align=\"center\" colspan=\"2\">\n");
      out.write("\t\t\t\t\t    \t\t\t<span style=\"font-weight: bold;font-size: 18px;\">");
      out.print(user.getUsername() );
      out.write("</span>\n");
      out.write("\t\t\t\t\t    \t\t\tLogin succeed！\n");
      out.write("                                                                <a href=\"FakeStory.jsp\"> Check Story </a>\n");
      out.write("\t\t\t\t\t    \t\t</td>\n");
      out.write("\t\t\t\t\t    \t</tr>\n");
      out.write("\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t    \t<tr>\n");
      out.write("\t\t\t\t\t    \t\t<td align=\"right\">Email：</td>\n");
      out.write("\t\t\t\t\t    \t\t<td>");
      out.print(user.getEmail());
      out.write("</td>\n");
      out.write("\t\t\t\t\t    \t</tr>\n");
      out.write("                                                 \n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("                                                \n");
      out.write("                                               \n");
      out.write("\n");
      out.write("                                                \n");
      out.write("\t\t\t\t\t\t");
								
							}else{
								out.println("<br>Haven't login ！");
							}
						
      out.write("\n");
      out.write("\t\t\t\t  \t </div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t  \t</div>\n");
      out.write("\t  </div>\n");
      out.write("\t</body>\n");
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
