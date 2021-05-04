/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Justine ENOND
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeUtilisateur",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Utilisateur")
public class UtilisateurEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column 
    private String nom;
    
    @Column 
    private String prenom;
    
    @Column 
    private String login;
    
    @Column
    private String password;
    
    @Column
    private List<MessageConseillerUtilisateurEntity> messages= new ArrayList<MessageConseillerUtilisateurEntity>(); 
    
    
    @OneToMany(mappedBy="user")
    private List<CompteEntity> comptes = new ArrayList<CompteEntity>();

    public UtilisateurEntity(String nom, String prenom, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

    public UtilisateurEntity(String login, String password) {
        this.nom = " ";
        this.prenom = " ";
        this.login = login;
        this.password = password;
    }
    
    public UtilisateurEntity() {
        this.nom = " ";
        this.prenom = " ";
        this.login = " ";
        this.password = " ";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Long getId() {
        return id;
    }

    public List<CompteEntity> getComptes(){
        return this.comptes;
    }

    public void setComptes(List<CompteEntity> comptes)
    {
        this.comptes = comptes;
    }
    
    public void addCompte(CompteEntity compte)
    {
        this.comptes.add(compte);
    }
    
    public void addMessage(MessageConseillerUtilisateurEntity m){
        this.messages.add(m);
    }
    
    public List<MessageConseillerUtilisateurEntity> getMessages(){
        return this.messages; 
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
        if (!(object instanceof UtilisateurEntity)) {
            return false;
        }
        UtilisateurEntity other = (UtilisateurEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.UtilisateurEntity[ id=" + id + " ]";
    }
    
}
