/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Justine ENOND
 */
public class Utilisateur {
    private String login;
    private String pass;
    
    public Utilisateur(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPass() {
        return this.pass;
    }

   
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 61 * hash + (this.pass != null ? this.pass.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.login != other.login && (this.login == null || !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Utilisateur{" + "login=" + login + ", pass=" + pass  + '}';
    }
}
