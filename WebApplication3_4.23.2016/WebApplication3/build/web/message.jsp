<%-- 
    Document   : message
    Created on : Apr 13, 2016, 3:51:14 AM
    Author     : Liang
--%>

<%@page import="com.IM.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Message</title>
		<link rel="stylesheet" type="text/css" href="images/styles.css">
	</head>

	<body>
		<div align="center">
		  	<div class="div1">
		  		<div class="top">Message</div>
		  		<div class="bottom">
					<div class="div2">
				  		<ul>
				  			
				  			
				  			
				  			<li><a href="logout.jsp">Exit</a></li>
                                                        <li></li>
				  		</ul>
				  	</div>
				  	 <div class="div3"> 
					    <% 
					    	
							String info = (String)request.getAttribute("info");
					    	
							if(info != null){
								out.println(info);
							}
					    	
							User user = (User)session.getAttribute("user");
					    	
							if(user != null){
						%>
						<table align="center" width="350" border="1" height="200" bordercolor="#E8F4CC">
							<tr>
					    		<td align="center" colspan="2">
					    			<span style="font-weight: bold;font-size: 18px;"><%=user.getUsername() %></span>
					    			Login succeed！
                                                                <a href="Story_Interface.jsp"> Check Story </a>
					    		</td>
					    	</tr>
					    	
					    	<tr>
					    		<td align="right">Email：</td>
					    		<td><%=user.getEmail()%></td>
					    	</tr>
                                                 
						</table>
                                                
                                               

                                                
						<%								
							}else{
								out.println("<br>Haven't login ！");
							}
						%>
				  	 </div>
				</div>
		  	</div>
	  </div>
	</body>
</html>
