/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.word;

/**
 *
 * @author Admin
 */
public class listCtl {
    public boolean checkIDperson(int idperson)// Kiem tra xem nguoi dung co tu vung nao chua?
    {
        String sql = "select distinct idperson from personword";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(idperson == rs.getInt("idperson"))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<word> getPersonWordList(int idperson) // Danh sach tu vung cua nguoi dung
    {
        ArrayList<word> personWordList = new ArrayList<>();
        String sql = "select word.idword, en, vn, idtopic from word\n" +
                "inner join personword on word.idword = personword.idword\n" +
                 "where idperson = '" + idperson + "'";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                 word a = new word();
                 a.setIdtopic(rs.getInt("idword"));
                 a.setEn(rs.getString("en"));
                 a.setVn(rs.getString("vn"));
                 a.setIdtopic(rs.getInt("idtopic"));
                 personWordList.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personWordList;
    }
    
    
    
    public void removeWord(String en) // Xoa tu vung khoi danh sach tu vung cua user
    {
        String sql = "DELETE FROM PERSONWORD WHERE IDWORD = '" + new topicCtl().getIDword(en) + "'"
                + " AND IDPERSON = '" + topicCtl.idperson +"'";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
