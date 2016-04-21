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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Liang
 */
@WebServlet(name = "RegServlet", urlPatterns = {"/RegServlet"})
public class RegServlet extends HttpServlet {
        private static final long serialVersionUID = 5280356329609002908L;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
      
        String password = request.getParameter("password");

        String email = request.getParameter("email");
        
        UserDo userDo = new UserDo();
        if(username != null && !username.isEmpty()){
            if(userDo.userIsExist(username)){
                
                User user = new User();  
                
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                
                userDo.saveUser(user);
                request.setAttribute("info", "Registration succeed！<br>");
            }else{
                request.setAttribute("info", "Username already in the system");
            }
        }
        
        request.getRequestDispatcher("message.jsp").forward(request, response);
    }

}
