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
@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO{

    @PersistenceContext(unitName="ProjetBanquePU")
    private EntityManager em; 
    
    public EntityManager getEm(){
        return em; 
    }
    
    public void setEm(EntityManager em){
        this.em = em; 
    }
    
    @Transactional
    @Override
    public void save(UtilisateurEntity u) {
        u = em.merge(u);
        em.persist(u);
    }

    @Transactional
    @Override
    public void update(UtilisateurEntity u) {
        em.merge(u);
    }

    @Transactional
    @Override
    public void delete(UtilisateurEntity u) {
        u = em.merge(u);
        em.remove(u);
    }

    @Transactional
    @Override
    public UtilisateurEntity find(long id) {
        return em.find(UtilisateurEntity.class,id);
    }

    @Transactional
    @Override
    public List<UtilisateurEntity> findAll() {
        Query q = em.createQuery("SELECT u FROM UtilisateurEntity u");
        return q.getResultList();
    }

    @Transactional
    @Override
    public List<UtilisateurEntity> findByLogin(String login) {
        Query q = em.createQuery("SELECT u FROM UtilisateurEntity u WHERE u.login = ?")
                .setParameter(1, login);
        return q.getResultList();
    }
    
}
