/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IM.DO;

import com.IM.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Liang
 */
public class UserDo {
    public void saveUser(User user){
        
        Connection conn = ConnectDB.getConnection();
        
        String sql = "insert into tb_user(username,password,email) values(?,?,?)";
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            
            ConnectDB.closeConnection(conn);
        }
    }
    /**
     * 
     * @param username 
     * @param password 
     * @return 
     */
    public User login(String username, String password){
        User user = null;
        
        Connection conn = ConnectDB.getConnection();
        
        String sql = "select * from tb_user where username = ? and password = ?";
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                user = new User();
                
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
            
            rs.close();
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            
            ConnectDB.closeConnection(conn);
        }
        return user;
    }
    /**
     * if the user exists 
     * @param username 
     * @return
     */
    public boolean userIsExist(String username){
        
        Connection conn = ConnectDB.getConnection();
        
        String sql = "select * from tb_user where username = ?";
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            if(!rs.next()){
                
                return true;
            }
            
            rs.close();
            
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            
            ConnectDB.closeConnection(conn);
        }
        return false;
    }
}

