/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class word {
    private int idword;
    private String en;
    private String vn;
    private int idtopic;

    public word() {
    }

    public word(int idword, String en, String vn, int idtopic) {
        this.idword = idword;
        this.en = en;
        this.vn = vn;
        this.idtopic = idtopic;
    }

    public int getIdword() {
        return idword;
    }

    public void setIdword(int idword) {
        this.idword = idword;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public int getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(int idtopic) {
        this.idtopic = idtopic;
    }
}
