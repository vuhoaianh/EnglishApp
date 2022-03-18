/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hoaianh_Kyros
 */
public class forgotPasswordCtl {
    public static String username;
    public static ArrayList<String> lockUsernamList = new ArrayList<>();
    public boolean checkUsername(String str)// Kiêm tra tên người dùng
    {
        String sql = "SELECT UUSERNAME FROM PERSON";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(str.equalsIgnoreCase(rs.getString("UUSERNAME")))
                    return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    
    public void resetPassword(String str, String newPassword)// Thay đổi mật khẩu
    {
        String sql = "UPDATE PERSON SET UPASSWORD = '"  + newPassword + "'" + 
                " WHERE UUSERNAME = '" + str + "'";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

