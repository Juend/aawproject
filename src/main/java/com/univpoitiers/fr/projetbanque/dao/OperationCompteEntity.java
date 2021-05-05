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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Justine ENOND
 */
@Entity
public class OperationCompteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column 
    private String type_operation; 
    
    @Column 
    private String actionnaire;
    
    @Column 
    private String beneficiaire;
    
    @Column 
    private float somme;
    
    @Column
    private Date dateOp; 

    @ManyToOne
    @JoinColumn(name="compte_fk")
    private CompteEntity compte;

   

    public OperationCompteEntity(String type_operation, String actionnaire, String beneficiaire, float somme) {
        this.type_operation = type_operation;
        this.actionnaire = actionnaire;
        this.beneficiaire = beneficiaire;
        this.somme = somme;
        this.dateOp = new Date();
    }
    
    public OperationCompteEntity(String type_operation, String actionnaire, String beneficiaire, float somme, Date dateOp) {
        this.type_operation = type_operation;
        this.actionnaire = actionnaire;
        this.beneficiaire = beneficiaire;
        this.somme = somme;
        this.dateOp = dateOp;
    }
    
    public String getType_operation() {
        return type_operation;
    }

    public void setType_operation(String type_operation) {
        this.type_operation = type_operation;
    }

    public String getActionnaire() {
        return actionnaire;
    }

    public void setActionnaire(String actionnaire) {
        this.actionnaire = actionnaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public float getSomme() {
        return somme;
    }

    public void setSomme(float somme) {
        this.somme = somme;
    }
    
    public Date getDateOp(){
        return this.dateOp;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public CompteEntity getCompte() {
        return compte;
    }

    public void setCompte(CompteEntity compte) {
        this.compte = compte;
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
        if (!(object instanceof OperationCompteEntity)) {
            return false;
        }
        OperationCompteEntity other = (OperationCompteEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.OperationCompteEntity[ id=" + id + " ]";
    }
    
}
