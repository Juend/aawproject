/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

import com.univpoitiers.fr.projetbanque.dao.UtilisateurEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Justine ENOND
 */
public interface UtilisateurService {
    // Methode pour ajouter un utilisateur
    public Boolean addUser(UtilisateurEntity u);
    
    // Méthode qui renvoi un utilisateur s'il existe (renvoi null sinon
    public UtilisateurEntity getUser(UtilisateurEntity u);
    
    // Methode qui renvoi un utilisateur selon son login
    public UtilisateurEntity findUserLogin(String login);
    
    
    public List<UtilisateurEntity> getUsers();
    
    // Méthode pour supprimer un utilisateur
    public Boolean removeUser(UtilisateurEntity u);
    
    //Méthode pour afficher les comptes d'un utilisateur
    public String printComptes(String login);
    
    //Méthode pour afficher les comptes d'un utilisateur
    public String printSelectComptes(String login);
}
