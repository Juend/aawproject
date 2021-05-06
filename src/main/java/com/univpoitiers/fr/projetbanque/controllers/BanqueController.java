/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.controllers;

import com.univpoitiers.fr.projetbanque.dao.CompteEntity;
import com.univpoitiers.fr.projetbanque.dao.ConseillerEntity;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurEntity;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurParticulier;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurProfessionel;
import com.univpoitiers.fr.projetbanque.service.CompteService;
import com.univpoitiers.fr.projetbanque.service.ConseillerService;
import com.univpoitiers.fr.projetbanque.service.OperationCompteService;
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
    
    @Autowired
    CompteService cptService; 
    
    @Autowired
    OperationCompteService opeService;
    
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
                if(type_Utilisateur.equals("Particulier")){
                    u_ = new UtilisateurParticulier(nom,prenom,login,password);
                }else if(type_Utilisateur.equals("Professionnel")){
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
                    mv.addObject("loginName", login);
                    String identite = u.getNom() + " " + u.getPrenom();
                    mv.addObject("utilisateurname", identite);
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
                    mv.addObject("loginName", login);
                    String identite = c.getNom() + " " + c.getPrenom();
                    mv.addObject("conseillername", identite);
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
    
    @RequestMapping(value="affichagecomptes", method=RequestMethod.GET)
    String initAffichageComptesU()
    {
        return "accueilbanque";
    }
    
    @RequestMapping (value="affichagecomptes", method=RequestMethod.POST)
    protected ModelAndView handleAffichageComptes(HttpServletRequest request, HttpServletResponse response) throws Exception {
            HttpSession session = request.getSession(true);
            
            UtilisateurEntity u = (UtilisateurEntity)session.getAttribute("utilisateur");
            if(u!=null){
                ModelAndView mv = new ModelAndView("displaycomptes");
                String listescomptes = uService.printComptes(u.getLogin());
                mv.addObject("loginName", u.getLogin());
                mv.addObject("listescomptes", listescomptes);
                return mv;
            }
            return null;         
    }
    
    @RequestMapping(value="affichagecomptesconseiller", method=RequestMethod.GET)
    String initAffichageComptesC()
    {
        return "accueilconseiller";
    }
    
    @RequestMapping (value="affichagecomptesconseiller", method=RequestMethod.POST)
    protected ModelAndView handleAffichageComptesConseiller(HttpServletRequest request, HttpServletResponse response) throws Exception {
            HttpSession session = request.getSession(true);
            
            ConseillerEntity c = (ConseillerEntity)session.getAttribute("conseiller");
            if(c!=null){
                ModelAndView mv = new ModelAndView("displaycomptesconseiller");
                String listescomptes = uService.printComptes(c.getLogin());
                mv.addObject("loginName", c.getLogin());
                mv.addObject("listescomptes", listescomptes);
                return mv;
            }
            return null;         
    }
    
    
    @RequestMapping(value="afficheope", method=RequestMethod.GET)
    String initAffichageOperations()
    {
        return "affichagecomptes";
    }
    
    @RequestMapping (value="afficheope", method=RequestMethod.POST)
    protected ModelAndView handleAffichageOperations(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String id_compte = request.getParameter("id_compte");
            HttpSession session = request.getSession(true);
            
            
            UtilisateurEntity u = (UtilisateurEntity)session.getAttribute("utilisateur");
            if(u!=null){
                ModelAndView mv = new ModelAndView("displayop");
                CompteEntity c = cptService.findCompteId(Long.parseLong(id_compte));
                String listeoperations = cptService.printOperations(Long.parseLong(id_compte));
                
                mv.addObject("typeCompte",c.getType().toString());
                mv.addObject("loginName", u.getLogin());
                mv.addObject("operations", listeoperations);
                return mv;
            }
            return null;        
    }
    
}
