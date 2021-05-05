/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

import com.univpoitiers.fr.projetbanque.dao.OperationCompteDAO;
import com.univpoitiers.fr.projetbanque.dao.OperationCompteEntity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Justine ENOND
 */
@Service("OperationCompteService")
public class OperationCompteServiceImpl implements OperationCompteService {
    @Resource
    OperationCompteDAO dao;

    @Override
    public Boolean addOperationCompte(OperationCompteEntity oc) {
        if(dao.find(oc.getId())== null){
            dao.save(oc);
            return true; 
        }
        return false;     
    }

    @Override
    public OperationCompteEntity getOperationCompte(OperationCompteEntity oc) {
        List<OperationCompteEntity> operationCompte = dao.findAll();
        for (int i=0;i<operationCompte.size();i++)
       {
           if (operationCompte.get(i).equals(oc))
               return operationCompte.get(i);
       }
       return null;
    }

    @Override
    public OperationCompteEntity findOperationCompteID(Long id) {
        if(dao.find(id)!= null)
           return dao.find(id);
       return null;
    }

    @Override
    public List<OperationCompteEntity> getOperationsCompte() {
        return dao.findAll();
    }

    @Override
    public Boolean removeOperationCompte(OperationCompteEntity oc) {
        if(dao.find(oc.getId())!= null){
            dao.delete(oc);
            return true; 
        }
        return false; 
    }
    
    
}
