/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

import com.univpoitiers.fr.projetbanque.dao.ConseillerEntity;
import java.util.List;

/**
 *
 * @author Justine ENOND
 */
public interface ConseillerService {
    // Methode pour ajouter un conseiller
    public void addConseiller(ConseillerEntity c);
    
    // Méthode qui renvoi un conseiller s'il existe (renvoi null sinon
    public ConseillerEntity getConseiller(ConseillerEntity c);
    
    // Methode qui renvoi un conseiller selon son login
    public ConseillerEntity findConseillerLogin(String login);
    
    
    public List<ConseillerEntity> getConseillers();
    
    // Méthode pour supprimer un conseiller
    public void removeConseiller(ConseillerEntity c);
    
    public String printComptes(String login);
}
