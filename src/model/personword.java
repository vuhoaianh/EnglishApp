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
public class personword {
    private int idperson;
    private int idword;

    public personword() {
    }

    public personword(int idperson, int idword) {
        this.idperson = idperson;
        this.idword = idword;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public int getIdword() {
        return idword;
    }

    public void setIdword(int idword) {
        this.idword = idword;
    }
    
}