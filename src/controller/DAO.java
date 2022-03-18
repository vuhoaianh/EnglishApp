/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DAO {
    Connection conn;
    
    public DAO()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Ket noi database (Netbean vs SQLServer)
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=engvocabulary;"
                    + "username=sa;password=123456");  
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}