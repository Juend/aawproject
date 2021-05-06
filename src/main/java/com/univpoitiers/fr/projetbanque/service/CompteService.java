/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

import com.univpoitiers.fr.projetbanque.dao.CompteEntity;
import java.util.List;

/**
 *
 * @author Justine ENOND
 */
public interface CompteService {
    // Methode pour ajouter un compte
    public Boolean addCompte(CompteEntity c);
    
    // Methode pour mettre a jour un compte
    public Boolean updateCompte(CompteEntity c);
    
    // Méthode qui renvoi un compte s'il existe (renvoi null sinon
    public CompteEntity getCompte(CompteEntity c);
    
    // Methode qui renvoi un compte selon son id
    public CompteEntity findCompteId(Long id);
    
    
    public List<CompteEntity> getComptes();
    
    // Méthode pour supprimer un compte
    public Boolean removeCompte(CompteEntity c);
    
    //Méthode pour afficher les operations d'un compte
    public String printOperations(Long id);
    
    //Méthode pour afficher un select avec les types de comptes
    public String printSelectTypeCompte();
}
