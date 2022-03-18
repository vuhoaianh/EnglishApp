/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.person;

/**
 *
 * @author Admin
 */
public class registerCtl {
    private registerCtl(){}; 
    private person a = new person();
    private static registerCtl instance; // single controller
    public static registerCtl getinstance()
    {
        if(instance == null)
            instance = new registerCtl();
        return instance;
    }
    
    public person getPerson() 
    {
        return a;
    }
    public boolean checkUsername(String username)// Kiem tra ten nguoi dung
    {
        String sql = "Select * from person";
        try 
        {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(username.equals(rs.getString("uusername")))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getLastID() // Lay ID cua nguoi dung truoc ==> Tao ID nguoi dung moi 
    {
        int lastID = 0;
        String sql = "Select MAX(idperson) as [idperson] from person";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                lastID = rs.getInt("idperson");
            }
        } catch (Exception e) {
        }
        return lastID;
    }
    
    public void setAcount(String username, String password) // Set username, password cho tai khoan moi
    {
        a.setUusername(username);
        a.setUpassword(password);
    }
    
    public void setInfo(String name, String gender, String address, String telephone, String email)// set cac thuoc tinh khac
    {
        a.setUname(name);
        a.setUgender(gender);
        a.setUaddress(address);
        a.setUtelephone(telephone);
        a.setUemail(email);
    }
    public void addPerson() // them nguoi dung vao co so du lieu
    {
            String sql = "INSERT INTO PERSON "
                    + "VALUES(?, ?, ?, ?, ?, ?, ? ,?)";
            try
            {
                DAO d = new DAO();
                PreparedStatement ps = d.conn.prepareStatement(sql);
                ps.setInt(1, this.getLastID() + 1);
                ps.setString(2, a.getUusername());
                ps.setString(3, a.getUpassword());
                ps.setString(4, a.getUname());
                ps.setString(5, a.getUgender());
                ps.setString(6, a.getUaddress());
                ps.setString(7, a.getUtelephone());
                ps.setString(8, a.getUemail());
                ps.executeUpdate();
            }catch (Exception e) {
                e.printStackTrace();
        }     
    }
}
