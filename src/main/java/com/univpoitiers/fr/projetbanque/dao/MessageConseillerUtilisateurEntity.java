/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 *
 * @author Justine ENOND
 */
@Entity
public class MessageConseillerUtilisateurEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String message; 
    
    @Column
    private String logExp;
    
    @Column 
    private String logDest; 
    
    @Column
    private final Date date_envoi; 
    
    @ManyToOne
    @JoinColumn(name="user_fk")
    private UtilisateurEntity user; 
    
    @ManyToOne
    @JoinColumn(name="conseiller_fk")
    private ConseillerEntity conseiller; 
    
    public MessageConseillerUtilisateurEntity(String msg, String logExp, String logDest){
        this.message = msg;
        this.logExp = logExp;
        this.logDest = logDest; 
        this.date_envoi = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLogExp() {
        return logExp;
    }

    public void setLogExp(String logExp) {
        this.logExp = logExp;
    }

    public String getLogDest() {
        return logDest;
    }

    public void setLogDest(String logDest) {
        this.logDest = logDest;
    }

    public Date getDateenvoi(){
        return this.date_envoi;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageConseillerUtilisateurEntity)) {
            return false;
        }
        MessageConseillerUtilisateurEntity other = (MessageConseillerUtilisateurEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.MessageConseillerUtilisateur[ id=" + id + " ]";
    }
    
}
