package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.sql.*;
import java.util.*;

public final class Bug_005fEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 public  class User
{
    String URL2="jdbc:mysql://localhost:3306/Testing";
    String USERNAME2="root";
    String PASSWORD2 ="password";
    
    // intialization of all variables
    Connection connection2 = null;
    PreparedStatement insertUser = null;
    PreparedStatement selectUser = null;
    PreparedStatement selectUserName = null;
    PreparedStatement UpdateUserName = null;
    ResultSet resultSet = null;
    String resultString ="";

public User()
{
    try
        {
        // used to create a connection to the Database
        connection2= DriverManager.getConnection(URL2, USERNAME2, PASSWORD2);
        /*
        all prepared statements are defined here
        Criteria to add new prepared statement:
        1) Create unique variable at the top of the bug class
        2) Create a connect.prepareStatement(what the variable will do)
        3) Create method that uses the new variable
        */

//SQl Statements------------------------User---------------------------------
        insertUser=connection2.prepareStatement("INSERT INTO User(User_Name)"
        + "VALUES (?)"); 

        selectUser = connection2.prepareCall("SELECT User_ID, User_Name From User");
        UpdateUserName = connection2.prepareStatement("UPDATE User SET User_Name = ? " + "WHERE User_ID = ? ");
        



    }
              
    catch(SQLException e)
        {
        e.printStackTrace();
        }
}

    // Methods to Communcate to Database
    // This methond takes the data a user has entered and pushes it to the Database

//--------------------------------------BUG Log Methods-------------------------
public int setUser(String addUser)
{
    int result=0;
    try 
    {
        insertUser.setString(2, addUser);
        
        result = insertUser.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}
            // This method retrives all the infromation associate with a specific Bug
public ResultSet getUser()
{
    try
        {
            resultSet = selectUser.executeQuery();
        }
    catch(SQLException e)
        {
            e.printStackTrace();
        }
    return resultSet;
}

// This Method retrieves the Bug Tilte from the Database
public String getUserName()
{
    try
    {
        resultSet = selectUserName.executeQuery();
        resultString=resultSet.getString("User_Name From User");
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    
    return resultString;
}


//---------------------------------SQL BUG Update Methods--------------------------------
public int UpdateUserName(String updateUserName, String user_ID)
{
    int result=0;
    try 
    {
        UpdateUserName.setString(1, updateUserName);
        UpdateUserName.setString(2, user_ID);
       
        result = UpdateUserName.executeUpdate();
    }   

    catch(SQLException e)
    {
        e.printStackTrace();
    }
   
    return result;
}





}

 public  class Bug
{
    String URL="jdbc:mysql://localhost:3306/Testing";
    String USERNAME="root";
    String PASSWORD ="password";
    User user = new User();
    
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
    PreparedStatement UpdateBugOwner=null;
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
        UpdateBugOwner  = connection.prepareStatement("UPDATE Buglog SET Bug_Owner = ? " + "WHERE Bug_ID = ?");


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

public int UpdateBugOwner(String UpdateBug_Owner, String Bug_ID)
{
    int result=0;
    try 
    {
        UpdateBugOwner.setString(1, UpdateBug_Owner);
        UpdateBugOwner.setString(2, Bug_ID);
       
        result = UpdateBugOwner.executeUpdate();
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

public User get()
{
user = new User();
return user;
}


}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Bug_DBconfig.jsp");
    _jspx_dependants.add("/User_DBconfig.jsp");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write('\n');
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
      out.write("        <title>Bug Editing</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");

        String bugid = "1";//request.getParameter("search_bug_ID").toString();
        String Bug_Title=null;
        String Bug_Description=null;
        String Bug_Owner=null;
        String Bug_Priority=null;
        String Bug_Status = null;
        String Bug_DateAdded =null;
        String Priority1=null;
        String Priority2=null;
        String Priority3=null;
        String Status1=null;
        String Status2=null;
        String Header=null;
        String UserName=null;
        
        
        Bug bug = new Bug();
        ResultSet bugretrieve=bug.getBug();
        ResultSet Userretrieve=bug.user.getUser();
            
            
        while(bugretrieve.next())
        {
            if(bugretrieve.getString("Bug_ID").toString().trim().equals(bugid.trim()))
            {
                Bug_Title = bugretrieve.getString("Bug_Title");
                Bug_Description = bugretrieve.getString("Bug_Description");
                Bug_Owner= bugretrieve.getString("Bug_Owner");
                Bug_Priority=bugretrieve.getString("Bug_Priority");
                Bug_Status = bugretrieve.getString("Bug_Status");
                Bug_DateAdded = bugretrieve.getString("Bug_Date_Added");
            }
        }   
    
      out.write("\n");
      out.write("    \n");
      out.write("    <form name=\"Bug_Update\" action=\"Bug_Edit.jsp\" method=\"POST\">\n");
      out.write("    ");
//if sumbit button equals true then show updated bug esle shoe orignal bug
        if  (request.getParameter("Update_Values")==null) 
        {
            Header = Bug_Title;
        }
        else
        {
            Header = new String("UPDATING");
        }
    
      out.write("\n");
      out.write("       \n");
      out.write("    <h1>");
      out.print(Header);
      out.write("</h1>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tbody>\n");
      out.write("            <tr>\n");
      out.write("                <td>Bug Title: </td>\n");
      out.write("                <td><input type=\"text\" name=\"UpdateBugTitle\" value=\"");
      out.print(Bug_Title );
      out.write("\" /></td>\n");
      out.write("            </tr>\n");
      out.write("                    \n");
      out.write("            <tr>\n");
      out.write("                <td>Owner: </td>\n");
      out.write("                <td>\n");
      out.write("                    ");
      out.print(Bug_Owner );
      out.write("\n");
      out.write("                    <select name=\"UpdateBugOwner\">\n");
      out.write("                        <option>");
      out.print(Bug_Owner );
      out.write("</option>    \n");
      out.write("                        ");

                            while (Userretrieve.next()) 
                            {
                                if(!Bug_Owner.equals(Userretrieve.getString("User_Name")))
                                {   
                                    UserName= Userretrieve.getString("User_Name"); 
                        
      out.write(" \n");
      out.write("                                    <option>");
      out.print(UserName );
      out.write("</option>\n");
      out.write("                        ");
      }
                            }
                        
      out.write(" \n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        \n");
      out.write("            <tr>\n");
      out.write("                <td>Description: </td>\n");
      out.write("                <td><input type=\"text\" name=\"UpdateBugDescription\" value=\"");
      out.print(Bug_Description);
      out.write("\" /></td>\n");
      out.write("            </tr>\n");
      out.write("                    \n");
      out.write("            <tr>\n");
      out.write("                <td>Priority:</td>\n");
      out.write("                <td>");
      out.print(Bug_Priority);
      out.write("\n");
      out.write("                ");
//<input type="hidden" name="origpriority" value="<%=Bug_Priority" />
      out.write("\n");
      out.write("                <select name=\"UpdateBugPriority\">\n");
      out.write("                    ");

                        if(Bug_Priority.equals("Easy"))
                        {
                            Priority1="Easy";
                            Priority2="Medium";
                            Priority3="Hard";
                        }
                        if(Bug_Priority.equals("Medium"))
                        {
                            Priority1="Medium";
                            Priority2="Easy"; 
                            Priority3="Hard";
                        }
                        if(Bug_Priority.equals("Hard"))
                        { 
                            Priority1="Hard";
                            Priority2="Easy";
                            Priority3="Medium";
                        }
                    
      out.write("\n");
      out.write("                    <option>");
      out.print(Priority1);
      out.write(" </option>\n");
      out.write("                    <option>");
      out.print(Priority2);
      out.write("</option> \n");
      out.write("                    <option>");
      out.print(Priority3);
      out.write("</option> \n");
      out.write("                </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        \n");
      out.write("            <tr>\n");
      out.write("                <td>Current Status:</td>\n");
      out.write("                <td>");
      out.print(Bug_Status );
      out.write("\n");
      out.write("                <select name=\"UpdateBugStatus\">\n");
      out.write("                    ");

                        if(Bug_Status.equals("INCOMPLETE"))
                        {   
                            Status1="INCOMPLETE";
                            Status2="COMPLETE";
                        }
                        if(Bug_Status.equals("COMPLETE"))
                        {
                            Status1="COMPLETE";
                            Status2="INCOMPLETE"; 
                        }
                        /*if(Bug_Priority.equals("Hard"))
                        {
                            Status1="Easy";
                            Status2="Medium";
                        }*/
                    
      out.write("\n");
      out.write("                    <option>");
      out.print(Status1);
      out.write("</option>\n");
      out.write("                    <option>");
      out.print(Status2);
      out.write("</option>\n");
      out.write("                </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Date Created:</td>\n");
      out.write("                <td>");
      out.print( Bug_DateAdded );
      out.write("</td>\n");
      out.write("                        \n");
      out.write("            </tr>\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(bugid );
      out.write("\" name=\"search_bug_ID\" />                \n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(Bug_Title );
      out.write("\" name=\"DB_Bugtitle\" />\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(Bug_Owner );
      out.write("\" name=\"DB_Bugowner\" />\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(Bug_Description);
      out.write("\" name=\"DB_Bugdescription\" />\n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(Bug_Priority );
      out.write("\" name=\"DB_Bugpriority\" />                \n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print(Bug_Status );
      out.write("\" name=\"DB_Bugstatus\" />   \n");
      out.write("        \n");
      out.write("    <input type=\"submit\" value=\"Save\" name=\"Update_Values\" />\n");
      out.write("    \n");
      out.write("    <a href=\"Buglog_ViewDB.jsp\">\n");
      out.write("    <input type=\"button\" value=\"Finished\" name=\"Finish\" />\n");
      out.write("    </a>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 //refresh page
            if(request.getParameter("Update_Values")!=null)
            { 
        
      out.write(" \n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    document.forms[\"Bug_Update\"].submit();\n");
      out.write("                </script> \n");
      out.write("        ");
    
            }
        
      out.write("\n");
      out.write("    </form>\n");
      out.write("        ");
//
        if  (request.getParameter("Update_Values")!=null) 
        {
            
            if(!request.getParameter("UpdateBugTitle").equals("Bug_Title"))
            {
                bug.UpdateBugTitle(request.getParameter("UpdateBugTitle"), bugid);
            }
            
            
            if(!request.getParameter("UpdateBugOwner").equals(Bug_Owner))
            {
                bug.UpdateBugOwner(request.getParameter("UpdateBugOwner"), bugid);
            }
            
            if(!request.getParameter("UpdateBugDescription").equals(Bug_Description))
            {
                bug.UpdateBugDescription(request.getParameter("UpdateBugDescription"), bugid);
            }
            
            
            
            if(!request.getParameter("UpdateBugPriority").equals(Bug_Priority))
            {
                bug.UpdateBugPriority(request.getParameter("UpdateBugPriority"), bugid);
            }
            
            if(!request.getParameter("UpdateBugStatus").equals(Bug_Status))
            {
                bug.UpdateBugStatus(request.getParameter("UpdateBugStatus"), bugid);
            }
            
            
            
        }
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <body>\n");
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
