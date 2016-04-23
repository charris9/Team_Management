/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IM.DO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Liang
 */
public class ConnectDB {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://teaminstantmanagement.cu2o8kpzcooo.us-west-2.rds.amazonaws.com:3306/TeamInstantManagement?zeroDateTimeBehavior=convertToNull";
            
            conn = DriverManager.getConnection(url, "TeamIM", "BUCS673SPR");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 
     * @param conn 
     */
    public static void closeConnection(Connection conn){
        
        if(conn != null){
            try {
                conn.close();   
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
