<%-- 
    Document   : reg
    Created on : Apr 12, 2016, 7:19:36 PM
    Author     : Liang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
  <head>
    <title>User Registration</title>
    	<link rel="stylesheet" type="text/css" href="images/styles.css">
        <script type="text/javascript">
	    	function reg(form){
	        	if(form.username.value === ""){
	        		alert("Username can't be void！");
	        		return false;
	        	}
	        	if(form.password.value === ""){
	        		alert("Username can't be void！");
	        		return false;
	        	}
	        	if(form.repassword.value === ""){
	        		alert("Please re-enter the password!");
	        		return false;
	        	}
	        	if(form.password.value !== form.repassword.value){
	        		alert("Passwords don't match!");
	        		return false;
	        	}

	        	if(form.email.value === ""){
	        		alert("Email can't be void！");
	        		return false;
	        	}
	    	}
	    	function change(){
				var photo = document.getElementById("photo");
				var photoImg = document.getElementById("photoImg");
				photoImg.src = photo.value;
	    	}
	    </script>
  </head>
  
  <body>
  	 <div align="center">
		  	<div class="div1">
		  		<div class="top">User Registration</div>
		  		<div class="bottom">
					<div class="div2">
				  		<ul>
				  			<li><a href="reg.jsp">Registration</a></li>
				  			<li><a href="login.jsp">Login</a></li>
				  			<li><a href="message.jsp">User Info</a></li>
				  			<li><a href="ExitServlet">Exit</a></li>
				  		</ul>
				  	</div>
				  	 <div class="div3"> 
					    <form action="RegServlet" method="post" onsubmit="return reg(this);">
						    <table align="center" width="450" border="0">
						    	<tr>
						    		<td align="right">Username：</td>
						    		<td>
						    			<input type="text" name="username">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td align="right">Password: </td>
						    		<td>
						    			<input type="password" name="password">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td align="right">Re-enter Password:</td>
						    		<td>
						    			<input type="password" name="repassword">
						    		</td>
						    	</tr>
						    	
						    	<tr>
						    		<td align="right">Email：</td>
						    		<td>
						    			<input type="text" name="email">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td colspan="2" align="center">
						    			<input type="submit" value="Enter">
						    			<input type="reset" value="Reset">
						    		</td>
						    	</tr>
						    </table>
					    </form>
				  	 </div>
				</div>
		  	</div>
	  </div>
  </body>
</html>

