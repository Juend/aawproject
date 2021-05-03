/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
@DiscriminatorValue("UtilisateurParticulier")
public class UtilisateurParticulier extends UtilisateurEntity{

    public UtilisateurParticulier(){
        super();
    }
    public UtilisateurParticulier(String nom, String prenom, String login, String password) {
        super(nom,prenom,login,password);
    }
    
}
