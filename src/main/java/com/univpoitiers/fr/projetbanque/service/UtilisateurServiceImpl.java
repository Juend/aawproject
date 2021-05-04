/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.service;

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
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    
    @Resource
    UtilisateurDAO dao;
    
    @Override
    public void addUser(UtilisateurEntity u)
    {
        dao.save(u);
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
    public void removeUser(UtilisateurEntity u)
    {
        dao.delete(u);
    }

    @Override
    public List<UtilisateurEntity> getUsers() {
        return dao.findAll();
    }
}
