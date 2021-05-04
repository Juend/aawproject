/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.dao;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Justine ENOND
 */
@Entity
@DiscriminatorValue("UtilisateurProfessionel")
public class UtilisateurProfessionel extends UtilisateurEntity{

    public UtilisateurProfessionel(){
        super();
    }
    public UtilisateurProfessionel(String nom, String prenom, String login, String password) {
        super(nom,prenom,login,password);
    }
    
}