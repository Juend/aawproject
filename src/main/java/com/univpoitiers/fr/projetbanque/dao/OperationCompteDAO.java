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
public interface OperationCompteDAO {
    
    public void save(OperationCompteEntity oc);
    public void update(OperationCompteEntity oc);
    public void delete(OperationCompteEntity oc);
    public OperationCompteEntity find(long id);
    public List<OperationCompteEntity> findAll();
    
}
