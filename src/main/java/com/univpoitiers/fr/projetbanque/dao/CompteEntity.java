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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Justine ENOND
 */
@Entity
public class CompteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column 
    private float solde; 
    
    
    @Column 
    private typeCompte type; 
    
    @Column 
    private static  final float plafond = 1500.f; 
    
    @Column 
    private static final float taux = 0.5f;
    
    @ManyToOne
    @JoinColumn(name="user_fk")
    private UtilisateurEntity user;
    
    @ManyToOne
    @JoinColumn(name="conseiller_fk")
    private ConseillerEntity conseiller;

    
    
    @OneToMany(mappedBy="compte")
    private List<OperationCompteEntity> operations = new ArrayList<OperationCompteEntity>();

    

    public CompteEntity() {
        this.solde = 0.f;
        this.type = typeCompte.COURANT; 
    }
    
    public CompteEntity(float solde, typeCompte type) {
        this.solde = solde;
        this.type = type; 
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public typeCompte getType() {
        return type;
    }

    public void setType(typeCompte type) {
        this.type = type;
    }

    
    public Long getId() {
        return id;
    }

    public UtilisateurEntity getUtilisateur(){
        return this.user;
    }

    public void setUtilisateur(UtilisateurEntity u){
        this.user = u; 
    }
    
    
    public ConseillerEntity getConseiller() {
        return conseiller;
    }

    public void setConseiller(ConseillerEntity conseiller) {
        this.conseiller = conseiller;
    }
    
    public List<OperationCompteEntity> getOperations() {
        return operations;
    }


    public void addOperation(OperationCompteEntity operation){
        this.operations.add(operation);
    }
    
    public void setOperations(List<OperationCompteEntity> operations) {
        this.operations = operations;
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
        if (!(object instanceof CompteEntity)) {
            return false;
        }
        CompteEntity other = (CompteEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.CompteEntity[ id=" + id + " ]";
    }
    
}
