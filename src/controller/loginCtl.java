/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import model.person;

/**
 *
 * @author Admin
 */
public class loginCtl {
    public boolean checkAccount(String username, String password) // Kiem tra tai khoan va mat khau dung?
    {
        DAO d = new DAO();
        String sql = "Select Uusername, Upassword from person";
        try 
        {
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(username.equals(rs.getString("Uusername")) && password.equals(rs.getString("Upassword")))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } 
    
    public int getIDPerson(String username, String password) // Lay Id cua nguoi dung
    {
        int IDperson = 0;
        String sql = "Select * from person";
        try 
        {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
               if(username.equals(rs.getString("Uusername")) && password.equals(rs.getString("Upassword")))
               {
                   IDperson = rs.getInt("idperson");
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDperson;
    }
}
