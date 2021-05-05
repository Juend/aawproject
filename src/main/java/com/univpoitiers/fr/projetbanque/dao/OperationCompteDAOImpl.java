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
public class OperationCompteDAOImpl implements OperationCompteDAO {
    
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
    public void save(OperationCompteEntity oc) {
        oc = em.merge(oc);
        em.persist(oc);
    }

    @Transactional
    @Override
    public void update(OperationCompteEntity oc) {
        em.merge(oc);
    }

    @Transactional
    @Override
    public void delete(OperationCompteEntity oc) {
        oc = em.merge(oc);
        em.remove(oc);
    }

    @Transactional(readOnly = true)
    @Override
    public OperationCompteEntity find(long id) {
        return em.find(OperationCompteEntity.class,id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<OperationCompteEntity> findAll() {
        Query q = em.createQuery("SELECT oc FROM OperationCompteEntity oc");
        return q.getResultList();
    }

}
