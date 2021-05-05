/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

import com.univpoitiers.fr.projetbanque.dao.OperationCompteEntity;
import java.util.List;

/**
 *
 * @author Justine ENOND
 */
public interface OperationCompteService {
    // Methode pour ajouter une operation à un compte
    public Boolean addOperationCompte(OperationCompteEntity oc);
    
    // Méthode qui renvoi une operation a un compte s'il existe (renvoi null sinon
    public OperationCompteEntity getOperationCompte(OperationCompteEntity oc);
    
    // Methode qui renvoi une operation de compte selon son login
    public OperationCompteEntity findOperationCompteID(Long id);
    
    
    public List<OperationCompteEntity> getOperationsCompte();
    
    // Méthode pour supprimer une operation d'un compte
    public Boolean removeOperationCompte(OperationCompteEntity oc);
}
