/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

import com.univpoitiers.fr.projetbanque.dao.CompteDAO;
import com.univpoitiers.fr.projetbanque.dao.CompteEntity;
import com.univpoitiers.fr.projetbanque.dao.OperationCompteEntity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Justine ENOND
 */
@Service("CompteService")
public class CompteServiceImpl implements CompteService {

    @Resource
    CompteDAO dao; 
    
    @Override
    public Boolean addCompte(CompteEntity c) {
       if(dao.find(c.getId())== null){
            dao.save(c);
            return true; 
        }
        return false; 
    }
    
    @Override
    public Boolean updateCompte(CompteEntity c) {
        if(dao.find(c.getId())!= null){
            dao.update(c);
            return true; 
        }
        return false;
    }

    @Override
    public CompteEntity getCompte(CompteEntity c) {
        List<CompteEntity> comptes = dao.findAll();
        for (int i=0;i<comptes.size();i++)
       {
           if (comptes.get(i).equals(c))
               return comptes.get(i);
       }
       return null;
    }

    @Override
    public CompteEntity findCompteId(Long id) {
        if(dao.find(id) != null)
           return dao.find(id);
       return null;
    }

    @Override
    public List<CompteEntity> getComptes() {
        return dao.findAll();
    }

    @Override
    public Boolean removeCompte(CompteEntity c) {
        if(dao.find(c.getId())!= null){
            dao.delete(c);
            return true; 
        }
        return false; 
    }

    @Override
    public String printOperations(Long id) {
        String result = "";
        CompteEntity c = dao.find(id);
										
        float montant;
        String color; 
        String operande;
        List<OperationCompteEntity> operations = c.getOperations();
        for(int j=0;j<operations.size();j++){
            OperationCompteEntity op = operations.get(j);                                                                                
            montant = op.getSomme();
            if(montant>0.0){
                color ="success";
                operande="+";
            }else{
                color ="danger";
                operande="-";
            }
            result += "<tr>";
            result += "<th scope=\"row\">" + op.getDateOp().toString() +"</th>";
            result +="<td>"+op.getType_operation()+"</td>" ;
            result +="<td>"+op.getActionnaire()+"</td>" ;
            result +="<td>"+op.getBeneficiaire()+"</td>" ;
            result += "<td class =\"table-"+color+"\">" +operande+op.getSomme()+"€</td>";
             result += "</tr>";
        }
                
        return result;
    }


    
}
