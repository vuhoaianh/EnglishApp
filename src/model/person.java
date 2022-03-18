/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class person {
    private int idperson;
    private String uusername;
    private String upassword;
    private String uname;
    private String ugender;
    private String uaddress;
    private String utelephone;
    private String uemail;
 
    public person() {
    }

    public person(String uusername, String upassword, String uname, String ugender, String uaddress, String utelephone, String uemail) {
        this.idperson = idperson;
        this.uusername = uusername;
        this.upassword = upassword;
        this.uname = uname;
        this.ugender = ugender;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
    }

    public String getUusername() {
        return uusername;
    }

    public void setUusername(String uusername) {
        this.uusername = uusername;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUgender() {
        return ugender;
    }

    public void setUgender(String ugender) {
        this.ugender = ugender;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUtelephone() {
        return utelephone;
    }

    public void setUtelephone(String utelephone) {
        this.utelephone = utelephone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }
}