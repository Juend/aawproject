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
public interface UtilisateurDAO {
    public void save(UtilisateurEntity u);
    public void update(UtilisateurEntity u);
    public void delete(UtilisateurEntity u);
    public UtilisateurEntity find(long id);
    public List<UtilisateurEntity> findAll();
    public List<UtilisateurEntity> findByLogin(String login);
}
