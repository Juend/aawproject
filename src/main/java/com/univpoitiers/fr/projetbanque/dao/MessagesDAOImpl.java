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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Justine ENOND
 */
@Repository
public class MessagesDAOImpl implements MessagesDAO {
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
    public void save(MessageConseillerUtilisateurEntity msg) {
       msg = em.merge(msg);
       em.persist(msg);
    }

    @Transactional
    @Override
    public void update(MessageConseillerUtilisateurEntity msg) {
        em.merge(msg);
    }

    @Transactional
    @Override
    public void delete(MessageConseillerUtilisateurEntity msg) {
        msg = em.merge(msg);
        em.remove(msg);
    }

    @Override
    public MessageConseillerUtilisateurEntity find(long id) {
        return em.find(MessageConseillerUtilisateurEntity.class,id);
    }

    @Override
    public List<MessageConseillerUtilisateurEntity> findAll() {
        Query q = em.createQuery("SELECT c FROM MessageConseillerUtilisateurEntity c");
        return q.getResultList();
    }
}
