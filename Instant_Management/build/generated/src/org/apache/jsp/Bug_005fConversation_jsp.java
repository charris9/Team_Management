package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public final class Bug_005fConversation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public  class Bug
{
    String URL="jdbc:mysql://localhost:3306/Testing";
    String USERNAME="root";
    String PASSWORD ="password";
    
    // intialization of all variables
    Connection connection = null;
    PreparedStatement insertBug = null;
    PreparedStatement selectBug = null;
    PreparedStatement selectBugTitle = null;
    ResultSet resultSet = null;
    String resultString ="";
    
    PreparedStatement UpdateBugTitle=null;
    PreparedStatement UpdateBugDescription=null;
    PreparedStatement UpdateBugPriority=null;
    PreparedStatement UpdateBugStatus=null;
    // might add date modified to here and DB

    PreparedStatement insertBugConvo = null;
    PreparedStatement selectBugConvo = null;
    PreparedStatement selectBugConvo_Bug_ID = null;
public Bug()
{
    try
        {
        // used to create a connection to the Database
        connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
        /*
        all prepared statements are defined here
        Criteria to add new prepared statement:
        1) Create unique variable at the top of the bug class
        2) Create a connect.prepareStatement(what the variable will do)
        3) Create method that uses the new variable
        */

//SQl Statements------------------------BUG LOG---------------------------------
        insertBug=connection.prepareStatement("INSERT INTO Buglog(Bug_Title,Bug_Owner,Bug_Description,Bug_Priority,Bug_Date_Added,Bug_Status)"
        + "VALUES (?,?,?,?,?,?)");

        selectBug = connection.prepareCall("SELECT Bug_ID, Bug_title,Bug_Owner,Bug_Description, Bug_Priority, Bug_Date_Added, Bug_Status From Buglog");
                    
        selectBugTitle = connection.prepareCall("SELECT Bug_title From Buglog"); //Might want to add From BugLog 

            //---------------------------BUG LOG Updates--------------------------


        UpdateBugTitle = connection.prepareStatement("UPDATE Buglog SET Bug_Title = ? " + "WHERE Bug_ID = ? ");
        UpdateBugDescription = connection.prepareStatement("UPDATE Buglog SET Bug_Description = ? " + "WHERE Bug_ID = ?");
        UpdateBugPriority = connection.prepareStatement("UPDATE Buglog SET Bug_Priority = ? " + "WHERE Bug_ID = ?");
        UpdateBugStatus = connection.prepareStatement("UPDATE Buglog SET Bug_Status = ? " + "WHERE Bug_ID = ?");



//SQl Statements------------------------BUG's Conversations---------------------------------
        
        insertBugConvo = connection.prepareStatement("INSERT INTO Bug_Conversation(Bug_ID, Bug_Conversation_Comment, Bug_Conversation_Owner, Bug_Conversation_Time_Added)" + "VALUES (?,?,?,?)");

       selectBugConvo = connection.prepareCall("SELECT Bug_Conversation_ID, Bug_ID,Bug_Conversation_Comment,Bug_Conversation_Owner, Bug_Conversation_Time_Added FROM Bug_Conversation");

        selectBugConvo_Bug_ID = connection.prepareCall("SELECT Bug_ID From Bug_Conversation");

}
              
    catch(SQLException e)
        {
        e.printStackTrace();
        }
}

    // Methods to Communcate to Database
    // This methond takes the data a user has entered and pushes it to the Database

//--------------------------------------BUG Log Methods-------------------------
public int setBugs(String addBug_Title, String addBug_Owner,String addBug_Description, String addBug_Priority, Timestamp addBug_Date_Added, String addBug_Status)
{
    int result=0;
    try 
    {
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
            // This method retrives all the infromation associate with a specific Bug
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

// This Method retrieves the Bug Tilte from the Database
public String getBugTitle()
{
    try
    {
        resultSet = selectBugTitle.executeQuery();
        resultString=resultSet.getString("Bug_title From Buglog");
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return resultString;
}


//---------------------------------SQL BUG Update Methods--------------------------------
public int UpdateBugTitle(String UpdateBug_Title, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugTitle.setString(1, UpdateBug_Title);
        UpdateBugTitle.setString(2, Bug_ID);
       
        result = UpdateBugTitle.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}



public int UpdateBugDescription(String UpdateBug_Description, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugDescription.setString(1, UpdateBug_Description);
        UpdateBugDescription.setString(2, Bug_ID);
       
        result = UpdateBugDescription.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public int UpdateBugPriority(String UpdateBug_Priority, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugPriority.setString(1, UpdateBug_Priority);
        UpdateBugPriority.setString(2, Bug_ID);
       
        result = UpdateBugPriority.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public int UpdateBugStatus(String UpdateBug_Status, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugStatus.setString(1, UpdateBug_Status);
        UpdateBugStatus.setString(2, Bug_ID);
       
        result = UpdateBugStatus.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}





















//--------------------------------BUG Conversation Methods--------------------------------
public int setBugConvo(int addBug_ID, String addBugConvo_Comment,String addBugConvo_Owner, Timestamp addBug_Date_Added)
{
    int result=0;
    try 
    {
        insertBugConvo.setInt(1, addBug_ID);
        insertBugConvo.setString(2, addBugConvo_Comment);
        insertBugConvo.setString(3, addBugConvo_Owner);
        insertBugConvo.setTimestamp(4, addBug_Date_Added);
        
        result = insertBugConvo.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}

public ResultSet getBugConvo()
{
    try
        {
            resultSet = selectBugConvo.executeQuery();
        }
    catch(SQLException e)
        {
            e.printStackTrace();
        }
    return resultSet;
}



// This Method retrieves the Bug Converstion from the Bug_Conversation in the Database
public String getBugConvo_Bug_ID()
{
    try
    {
        resultSet = selectBugConvo_Bug_ID.executeQuery();
        resultString=resultSet.getString("Bug_ID FROM Bug_Conversation");
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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        ");

            String bugid = request.getParameter("search_bug_id").toString();
            String Bug_Name=null;
            String Bug_Description=null;
            Bug bug = new Bug();
            ResultSet bugtitleretrieve=bug.getBug();
            
            while(bugtitleretrieve.next())
            {
                if(bugtitleretrieve.getString("Bug_ID").toString().trim().equals(bugid.trim()))
                {
                    Bug_Name = bugtitleretrieve.getString("Bug_Title");
                    Bug_Description = bugtitleretrieve.getString("Bug_Description");
                }
            }
        
      out.write("\r\n");
      out.write("        <title>Bug Conversation</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    \r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            int results=0; 
            ResultSet bugsconvo=bug.getBugConvo();
            String bugconvo_comment=new String();
            String bugconvo_owner = new String(); 
            if(request.getParameter("add")!=null)
            {
                Integer addbug_id= 0;
                Date date =new Date();
                Timestamp bugconvo_timestamp = new Timestamp(date.getTime());
                if(request.getParameter("comment").trim() != null)
                {   
                    bugconvo_comment = request.getParameter("comment");
                }
                if(request.getParameter("owner").trim() != null)
                {
                    bugconvo_owner = request.getParameter("owner");
                }
                
                addbug_id=Integer.parseInt(bugid);
                
                if(bugconvo_comment.equals(bugconvo_owner))// will need to change this parameter
                {
                    
                }
                else
                {
                results=bug.setBugConvo(addbug_id, bugconvo_comment, bugconvo_owner, bugconvo_timestamp);
                }
            }
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <h1>");
      out.print(Bug_Name );
      out.write("'s Conversation</h1>\r\n");
      out.write("        <h2>Description</h2>\r\n");
      out.write("        <h2>");
      out.print(Bug_Description );
      out.write("</h2>\r\n");
      out.write("        <form name=\"Reload\" action=\"Bug_Conversation\">\r\n");
      out.write("            ");
 
                while(bugsconvo.next())     
                {// if bug tilte matches the search bug title retrieve all information
                    if (bugsconvo.getString("Bug_ID").toString().trim().equals(bugid.trim()))
                    {
            
      out.write("\r\n");
      out.write("                        <table border=\"0\">\r\n");
      out.write("                            <tbody>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>");
      out.print( bugsconvo.getString("Bug_Conversation_Comment") );
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print( bugsconvo.getString("Bug_Conversation_Owner") );
      out.write("</td>\r\n");
      out.write("                                    <td>");
      out.print( bugsconvo.getString("Bug_Conversation_Time_Added") );
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("            ");

                    }
                }//}
            
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        <form name=\"add_comment\" action=\"Bug_Conversation.jsp\" method=\"POST\">\r\n");
      out.write("            <input type=\"text\" name=\"comment\"/>\r\n");
      out.write("            <input type=\"text\" name=\"owner\" />\r\n");
      out.write("            <input type=\"hidden\" name=\"hidden\" value=\"");
      out.print( results);
      out.write("\" />\r\n");
      out.write("            <input type=\"hidden\" name=\"search_bug_id\" value=");
      out.print( bugid);
      out.write(" />\r\n");
      out.write("            <input type=\"submit\" value=\"SEND\" name=\"add\" />\r\n");
      out.write("            \r\n");
      out.write("            ");

                if(request.getParameter("add")!=null)
                { 
            
      out.write("\r\n");
      out.write("                <script type=\"text/javascript\">\r\n");
      out.write("                    document.forms[\"add_comment\"].submit();\r\n");
      out.write("                </script> \r\n");
      out.write("            ");
    
                }
            
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("        \r\n");
      out.write("        <a href=\"Buglog_ViewDB.jsp\">\r\n");
      out.write("            <input type=\"button\" value=\"Back\"/>\r\n");
      out.write("        </a>\r\n");
      out.write("    </body>\r\n");
      out.write("     \r\n");
      out.write("</html>\r\n");
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
