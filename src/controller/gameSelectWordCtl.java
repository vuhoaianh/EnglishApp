/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hoaianh_Kyros
 */
public class gameSelectWordCtl {
    public ArrayList<String> getRandomWordList()// Chon 10 tu ngau nhien trong ds tu vung cua user de on tap
    {
        ArrayList <String> wordList = new ArrayList<>();
        String sql = "SELECT TOP 10 EN, VN FROM WORD\n" +
                "INNER JOIN PERSONWORD ON WORD.IDWORD = PERSONWORD.IDWORD\n" +
                "WHERE IDPERSON = '" + topicCtl.idperson + "'"   +
                     "\nORDER BY NEWID()";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                wordList.add(rs.getString("en"));
                wordList.add(rs.getString("vn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  wordList;
    }
    
    public boolean checkCorrectSelection(String a, String b)
    {
        String sql = "SELECT EN, VN FROM WORD\n" +
                "INNER JOIN PERSONWORD ON WORD.IDWORD = PERSONWORD.IDWORD\n" +
                "WHERE IDPERSON = '" + topicCtl.idperson + "'";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(a.equalsIgnoreCase(rs.getString("en")) && b.equalsIgnoreCase(rs.getString("vn"))
                    || (a.equalsIgnoreCase(rs.getString("vn")) && b.equalsIgnoreCase(rs.getString("en"))))
                    return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    
    public String getNamePerson()
    {
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT UNAME FROM PERSON WHERE IDPERSON = " + topicCtl.idperson);
            while(rs.next())
                return rs.getString("uname");
        } catch (Exception e) {
        }
        return null;
    }
}
