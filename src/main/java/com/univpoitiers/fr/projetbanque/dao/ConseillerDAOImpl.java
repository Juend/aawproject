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
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Justine ENOND
 */
public class ConseillerDAOImpl implements ConseillerDAO {

    @PersistenceContext(unitName="ProjetBanquePU")
    private EntityManager em; 
    
    public EntityManager getEm(){
        return em; 
    }
    
    public void setEm(EntityManager em){
        this.em = em; 
    }
    
    @Override
    public void save(ConseillerEntity c) {
       c = em.merge(c);
       em.persist(c);
    }

    @Override
    public void update(ConseillerEntity c) {
        em.merge(c);
    }

    @Override
    public void delete(ConseillerEntity c) {
        c = em.merge(c);
        em.remove(c);
    }

    @Override
    public ConseillerEntity find(long id) {
        return em.find(ConseillerEntity.class,id);
    }

    @Override
    public List<ConseillerEntity> findAll() {
       Query q = em.createQuery("SELECT c FROM ConseillerEntity c");
        return q.getResultList(); 
    }

    @Override
    public List<ConseillerEntity> findByLogin(String nom) {
        Query q = em.createQuery("SELECT c FROM ConseillerEntity c WHERE c.nom = ?")
                .setParameter(1, nom);
        return q.getResultList();}
    
}
