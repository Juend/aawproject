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
public interface ConseillerDAO {
    public void save(ConseillerEntity c);
    public void update(ConseillerEntity c);
    public void delete(ConseillerEntity c);
    public ConseillerEntity find(long id);
    public List<ConseillerEntity> findAll();
    public List<ConseillerEntity> findByLogin(String nom);
}
