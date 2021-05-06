/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

import com.univpoitiers.fr.projetbanque.dao.CompteEntity;
import com.univpoitiers.fr.projetbanque.dao.ConseillerDAO;
import com.univpoitiers.fr.projetbanque.dao.ConseillerEntity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Justine ENOND
 */
@Service("ConseillerService")
public class ConseillerServiceImpl implements ConseillerService {

    @Resource
    ConseillerDAO dao; 
    
    @Override
    public void addConseiller(ConseillerEntity c) {
        dao.save(c);
    }

    @Override
    public ConseillerEntity getConseiller(ConseillerEntity c) {
        List<ConseillerEntity> conseillers = dao.findAll();
        for (int i=0;i<conseillers.size();i++)
       {
           if (conseillers.get(i).equals(c))
               return conseillers.get(i);
       }
       return null;}

    @Override
    public ConseillerEntity findConseillerLogin(String login) {
        if(!dao.findByLogin(login).isEmpty())
           return dao.findByLogin(login).get(0);
        return null;}

    @Override
    public List<ConseillerEntity> getConseillers() {
       return dao.findAll();
    }

    @Override
    public void removeConseiller(ConseillerEntity c) {
        dao.delete(c);
    }

    @Override
    public String printComptes(String login) {
        String result = "";
        ConseillerEntity c = dao.findByLogin(login).get(0);
										
        float solde;
        String color; 
        List<CompteEntity> comptes = c.getComptes();
        for(int j=0;j<comptes.size();j++){
                                                                                            
            solde = comptes.get(j).getSolde();
            if(solde>0.0){
                color ="success";
            }else{
                color ="danger";
            }
            result += "<li class=\"list-group-item d-flex justify-content-between align-items-center\">";
            result ="Compte ";
            result += comptes.get(j).getType().toString();
            result += " de " + comptes.get(j).getUtilisateur().getLogin();
            result +="<span class=\"badge badge-"+color +"badge-pill\">"+ comptes.get(j).getSolde() +"€</span>" ;
            result += "<form action=\"opesconseiller\" method=\"post\">"; 
            result += "<input name=\"id_compte\" type=\"hidden\" value=\" "+comptes.get(j).getId().toString() + "\">";
            result +="<button type=\"submit\" class=\"btn btn-light\">Realiser une operation sur ce compte </button></form></li>";
        }
                
        return result;}
    
}
