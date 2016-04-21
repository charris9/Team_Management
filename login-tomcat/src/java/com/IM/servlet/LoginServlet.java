/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IM.servlet;

import com.IM.DO.UserDo;
import com.IM.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Liang
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
	public class LoginServlet extends HttpServlet {
		private static final long serialVersionUID = -3009431503363456775L;
		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String username = request.getParameter("username");
			
			String password = request.getParameter("password");
                        
                        String value = request.getParameter("RememberMe");
                        boolean rememberMe = false;
                        if(value != null && value.equalsIgnoreCase("on")){
                            rememberMe = true;
                        }
                        if (rememberMe) {           //If checkbox value is true
                        Cookie cookieUsername = new Cookie("cookieLoginUser", username);
                        Cookie cookiePassword = new Cookie("cookieLoginPassword", password);
                        // Make the cookie one year last
                        cookieUsername.setMaxAge(60 * 60 * 24 * 3);
                        cookiePassword.setMaxAge(60 * 60 * 24 * 3);
                        response.addCookie(cookieUsername);
                        response.addCookie(cookiePassword);
                        }
			
			UserDo userDo = new UserDo();	
			
			User user = userDo.login(username, password);
			
			if(user != null){
				
				request.getSession().setAttribute("user", user);
				
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}else{
				
				request.setAttribute("info", "Username or password is wrong!");
				request.getRequestDispatcher("loginError.html").forward(request, response);
			}
                        
 
		}

	}
