/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

import com.univpoitiers.fr.projetbanque.dao.CompteEntity;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurDAO;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Justine ENOND
 */
@Service("UtilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {
    
    @Resource
    UtilisateurDAO dao;
    
    @Override
    public Boolean addUser(UtilisateurEntity u)
    {
        if(dao.find(u.getId())== null){
            dao.save(u);
            return true; 
        }
        return false; 
        
    }
    
    @Override
    public Boolean updateUser(UtilisateurEntity u){
       if(dao.find(u.getId())!= null){
            dao.update(u);
            return true; 
        }
        return false; 
    }
    
    @Override
    public UtilisateurEntity getUser(UtilisateurEntity u)
    {
       List<UtilisateurEntity> utilisateurs = dao.findAll();
        for (int i=0;i<utilisateurs.size();i++)
       {
           if (utilisateurs.get(i).equals(u))
               return utilisateurs.get(i);
       }
       return null;
    }
    
    @Override
    public UtilisateurEntity findUserLogin(String login)
    {
       if(!dao.findByLogin(login).isEmpty())
           return dao.findByLogin(login).get(0);
       return null;
    }
    
    @Override
    public Boolean removeUser(UtilisateurEntity u)
    {
        if(dao.find(u.getId())!= null){
            dao.delete(u);
            return true; 
        }
        return false; 
        
    }

    @Override
    public List<UtilisateurEntity> getUsers() {
        return dao.findAll();
    }
    
    @Override
    public String printComptes(String login)
    {
        String result = "";
        UtilisateurEntity u = dao.findByLogin(login).get(0);
										
        float solde;
        String color; 
        String operande; 
        List<CompteEntity> comptes = u.getComptes();
        for(int j=0;j<comptes.size();j++){
                                                                                            
            solde = comptes.get(j).getSolde();
            if(solde>0.0){
                color ="success";
                operande ="+";
            }else{
                color ="danger";
                operande ="-";
            }
            result += "<li class=\"list-group-item d-flex justify-content-between align-items-center\">";
            result += comptes.get(j).getType().toString();
            result +="<span class=\"badge badge-"+color +"badge-pill\">"+ operande+comptes.get(j).getSolde() +"€</span>" ;
            result += "<form action=\"afficheope\" method=\"post\">"; 
            result += "<input name=\"id_compte\" type=\"hidden\" value=\" "+comptes.get(j).getId().toString() + "\">";
            result +="<button type=\"submit\" class=\"btn btn-light\">Voir les operations de ce compte </button></form></li>";
        }
                
        return result;
    }

    @Override
    public String printSelectComptes(String login) {
        String result = "";
        UtilisateurEntity u = dao.findByLogin(login).get(0);
	
        List<CompteEntity> comptes = u.getComptes();
        for(int j=0;j<comptes.size();j++){
            CompteEntity cpt = comptes.get(j);
            result ="<option value=\""+cpt.getId()+"\"> Compte "+ cpt.getType()+" : "+cpt.getSolde()+"€</option>";
        }
                
        return result;
    }
    
}
