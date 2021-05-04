/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Justine ENOND
 */
public class CompteDAOImpl implements CompteDAO {

    @PersistenceContext(unitName="ProjetBanquePU")
    private EntityManager em; 
    
        public EntityManager getEm(){
        return em; 
    }
    
    public void setEm(EntityManager em){
        this.em = em; 
    }
    
    
    @Override
    public void save(CompteEntity c) {
        c = em.merge(c);
        em.persist(c);
    }

    @Override
    public void update(CompteEntity c) {
        em.merge(c);
    }

    @Override
    public void delete(CompteEntity c) {
        c = em.merge(c);
        em.remove(c);
    }

    @Override
    public CompteEntity find(long id) {
        return em.find(CompteEntity.class,id);
    }

    @Override
    public List<CompteEntity> findAll() {
        Query q = em.createQuery("SELECT c FROM CompteEntity c");
        return q.getResultList();
    }
    
}
