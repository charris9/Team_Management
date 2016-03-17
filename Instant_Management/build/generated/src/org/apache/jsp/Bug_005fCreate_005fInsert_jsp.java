package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.sql.*;
import java.util.Date;

public final class Bug_005fCreate_005fInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
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
 Class.forName("com.mysql.jdbc.Driver");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">\n");
      out.write("        <title>Inserting</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <body onload=\"displayResults()\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

            int results=0;
            Bug addBug = new Bug();
            String UserName=null;
            ResultSet Userretrieve=addBug.user.getUser();
            
            if(request.getParameter("Submit")!=null)
            {
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
            
            
            } 
        
      out.write("\n");
      out.write("     \n");
      out.write("        <div class=\"main-window\">\n");
      out.write("        <h1>Insert Data into a DB</h1>\n");
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
      out.write("                        <select name=\"bug_owner\">\n");
      out.write("                                  <option></option>\n");
      out.write("                                ");

                                    while (Userretrieve.next()) 
                                    {
                                        
                                        {
                                            UserName= Userretrieve.getString("User_Name"); 
                                
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
