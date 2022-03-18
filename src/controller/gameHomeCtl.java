/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author hoaianh_Kyros
 */
public class gameHomeCtl { 
    public int  getWordQuanlity() // Dem so luong tu vung ca nhan cua user
    {
        int quanlity = 0;
        String sql = "SELECT COUNT(IDPERSON) as [QUANLITY] FROM PERSONWORD\n" +
                "WHERE IDPERSON = " + topicCtl.idperson;
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                quanlity = rs.getInt("QUANLITY");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quanlity;
    }
}
