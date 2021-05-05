/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.dao;

import java.util.List;

/**
 *
 * @author Justine ENOND
 */
public interface MessagesDAO {
    
    public void save(MessageConseillerUtilisateurEntity msg);
    public void update(MessageConseillerUtilisateurEntity msg);
    public void delete(MessageConseillerUtilisateurEntity msg);
    public MessageConseillerUtilisateurEntity find(long id);
    public List<MessageConseillerUtilisateurEntity> findAll();
}
