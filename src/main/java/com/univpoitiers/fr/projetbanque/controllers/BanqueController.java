/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.controllers;

import com.univpoitiers.fr.projetbanque.dao.ConseillerEntity;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurEntity;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurParticulier;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurProfessionel;
import com.univpoitiers.fr.projetbanque.service.ConseillerService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Justine ENOND
 */
import com.univpoitiers.fr.projetbanque.service.UtilisateurService;
import java.util.ArrayList;

@Controller
public class BanqueController {

    @Autowired
    UtilisateurService uService;
    
    @Autowired
    ConseillerService cService; 
    
    
    @RequestMapping(value="sign", method=RequestMethod.GET)
    String initSign()
    {
        return "sign";
    }

    @RequestMapping(value="connect", method=RequestMethod.GET)
    String initConnect()
    {
        return "sign";
    }
    
    @RequestMapping(value="signIn", method=RequestMethod.GET)
    String initSignIn()
    {
        return "sign";
    }
    
    @RequestMapping(value="accueilbanque", method=RequestMethod.GET)
    String initAcceuilbanque()
    {
        return "accueilbanque";
    }
    
    @RequestMapping(value="accueilconseiller", method=RequestMethod.GET)
    String initAcceuilconseiller()
    {
        return "accueilconseiller";
    }
    
    @RequestMapping(value="disconnect", method=RequestMethod.GET)
    String initDisconnect()
    {
        return "disconnect";
    }
    
    @RequestMapping(value="signIn", method=RequestMethod.POST)
    ModelAndView signIn(HttpServletRequest request)
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String type_Compte = request.getParameter("Radio_nouveau_compte") ;
        
        ModelAndView mv = new ModelAndView("sign");
        
        if(type_Compte.equals("Utilisateur")){
            UtilisateurEntity u = uService.findUserLogin(login);
            if(u!=null){
                mv.addObject("signInMessage","Login déjà utilisé !");
            }else{
                UtilisateurEntity u_;
               String type_Utilisateur = request.getParameter("Radio_type_utilisateur") ;
                if(type_Compte.equals("Particulier")){
                    u_ = new UtilisateurParticulier(nom,prenom,login,password);
                }else if(type_Compte.equals("Professionnel")){
                   u_ = new UtilisateurProfessionel(nom,prenom,login,password);
                }else{
                   u_ = new UtilisateurEntity(nom, prenom, login, password);
                } 
                uService.addUser(u_);
            }
        }else if (type_Compte.equals("Conseiller")){
            ConseillerEntity c = cService.findConseillerLogin(login);
            if(c!=null)
                mv.addObject("signInMessage","Login déjà utilisé !");
            else{
                ConseillerEntity c_ = new ConseillerEntity(nom, prenom, login, password);
                cService.addConseiller(c_);
            } 
        }else{
            mv.addObject("connectMessage", "Erreur : Ajouter un type de Compte");
        } 
        return mv;
        
    }
    
    @RequestMapping(value="connect", method=RequestMethod.POST)
    ModelAndView connect(HttpServletRequest request)
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        String type_Compte = request.getParameter("Radio_compte") ;
        
        if(type_Compte.equals("Utilisateur")){
            UtilisateurEntity u = uService.findUserLogin(login);
            if(u!=null){
                if(u.getPassword().equals(password)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("utilisateur",u);
                    ModelAndView mv = new ModelAndView("accueilbanque");
                    return mv;
                }
                else {
                    ModelAndView mv = new ModelAndView("sign");
                    mv.addObject("connectMessage", "Erreur login / Password");
                    return mv;
                }
            }
            else{
                ModelAndView mv = new ModelAndView("sign");
                mv.addObject("connectMessage", "Erreur login / Password");
                return mv;
            }   
        }else if (type_Compte.equals("Conseiller")){
            ConseillerEntity c = cService.findConseillerLogin(login);
            if(c!=null){
                if(c.getPassword().equals(password)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("conseiller",c);
                    ModelAndView mv = new ModelAndView("accueilconseiller");
                    return mv;
                }
                else {
                    ModelAndView mv = new ModelAndView("sign");
                    mv.addObject("connectMessage", "Erreur login / Password");
                    return mv;
                }
            }
            else{
                ModelAndView mv = new ModelAndView("sign");
                mv.addObject("connectMessage", "Erreur login / Password");
                return mv;
            }
        }else{
            ModelAndView mv = new ModelAndView("sign");
            mv.addObject("connectMessage", "Erreur : Ajouter un type de Compte");
            return mv;
        } 
    }
    
    @RequestMapping(value="disconnect", method=RequestMethod.POST)
    ModelAndView disconnect(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        session.invalidate();
        
        ModelAndView mv = new ModelAndView("sign");
        return mv;
    }
    
}
