/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univpoitiers.fr.projetbanque.controllers;

import com.univpoitiers.fr.projetbanque.dao.CompteEntity;
import com.univpoitiers.fr.projetbanque.dao.ConseillerEntity;
import com.univpoitiers.fr.projetbanque.dao.OperationCompteEntity;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurEntity;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurParticulier;
import com.univpoitiers.fr.projetbanque.dao.UtilisateurProfessionel;
import com.univpoitiers.fr.projetbanque.dao.typeCompte;
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
        return "sign";
    }
    
    @RequestMapping(value="createcompte", method=RequestMethod.GET)
    String initCreateCompte()
    {
        return "createcompte";
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
    
    @RequestMapping(value="createcompte", method=RequestMethod.POST)
    ModelAndView createCompte(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        
        UtilisateurEntity u = (UtilisateurEntity)session.getAttribute("utilisateur");
            if(u!=null){
                ModelAndView mv = new ModelAndView("createcompte");
                 CompteEntity cpt = new CompteEntity(0.f, typeCompte.PEL);
                return mv;
            }
            return null; 
        
        
        
        
       
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
    
    @RequestMapping(value="transferts", method=RequestMethod.GET)
    String initTransfert()
    {
        return "accueilbanque";
    }
    
    @RequestMapping (value="transferts", method=RequestMethod.POST)
    protected ModelAndView handleTransferts(HttpServletRequest request, HttpServletResponse response) throws Exception {
            HttpSession session = request.getSession(true);
            
            
            UtilisateurEntity u = (UtilisateurEntity)session.getAttribute("utilisateur");
            if(u!=null){
                ModelAndView mv = new ModelAndView("transfertintercompte");
                
                String listeComptesSelect = uService.printSelectComptes(u.getLogin());
                
                mv.addObject("listes_comptes_cred",listeComptesSelect);
                mv.addObject("listes_comptes_deb", listeComptesSelect);
                mv.addObject("loginName", u.getLogin());
                return mv;
            }
            return null;        
    }
    
    @RequestMapping(value="opetransferts", method=RequestMethod.GET)
    String initOpeTransfert()
    {
        return "transferts";
    }
    
    @RequestMapping (value="opetransferts", method=RequestMethod.POST)
    protected ModelAndView handleOperationTransferts(HttpServletRequest request, HttpServletResponse response) throws Exception {
            HttpSession session = request.getSession(true);
            
            Long id_compte_deb = Long.parseLong(request.getParameter("id_compte_deb"));
            Long id_compte_cred =Long.parseLong(request.getParameter("id_compte_cred")) ;
            Float somme = Float.parseFloat(request.getParameter("somme"));
            String name_ope = request.getParameter("nom_ope");
            
            ModelAndView mv = new ModelAndView("transfertintercompte");
            
            
            UtilisateurEntity u = (UtilisateurEntity)session.getAttribute("utilisateur");
            if(u!=null){
                String listeComptesSelect = uService.printSelectComptes(u.getLogin());
                mv.addObject("listes_comptes_cred",listeComptesSelect);
                mv.addObject("listes_comptes_deb", listeComptesSelect);
                mv.addObject("loginName", u.getLogin());
                
                if(id_compte_cred != null && id_compte_deb !=null && somme !=null && name_ope !=null){
                    OperationCompteEntity op = new OperationCompteEntity(name_ope, cptService.findCompteId(id_compte_deb).getType().toString(), cptService.findCompteId(id_compte_cred).getType().toString(), somme);
                    opeService.addOperationCompte(op);
                    
                    cptService.findCompteId(id_compte_deb).addOperation(op);
                    cptService.findCompteId(id_compte_deb).retrieveMoney(somme);
                    cptService.updateCompte(cptService.findCompteId(id_compte_deb));
                    
                    cptService.findCompteId(id_compte_cred).addOperation(op);
                    cptService.findCompteId(id_compte_cred).gainMoney(somme);
                    cptService.updateCompte(cptService.findCompteId(id_compte_cred));
                    
                    return mv; 
                }else{
                    mv.addObject("submitMessage", "Merci de remplir tout les champs du formulaire ");
                    return mv;
                }
                
                
                
                
            }
            return null;        
    }
    
    @RequestMapping(value="opesconseiller", method=RequestMethod.GET)
    String initOpesConseiller()
    {
        return "affichagecomptesconseiller";
    }
    
    @RequestMapping (value="opesconseiller", method=RequestMethod.POST)
    protected ModelAndView handleOpesConseiller(HttpServletRequest request, HttpServletResponse response) throws Exception {
            String id_compte = request.getParameter("id_compte");
            HttpSession session = request.getSession(true);
            
            
            ConseillerEntity c = (ConseillerEntity)session.getAttribute("conseiller");
            if(c!=null){
                ModelAndView mv = new ModelAndView("transfertconseiller");
                CompteEntity cpt = cptService.findCompteId(Long.parseLong(id_compte));
                
                mv.addObject("typeCompte",cpt.getType().toString());
                mv.addObject("loginUtilisateur",cpt.getUtilisateur().getLogin());
                mv.addObject("nomUtilisateur",cpt.getUtilisateur().getNom());
                mv.addObject("prenomUtilisateur",cpt.getUtilisateur().getPrenom());
                mv.addObject("loginName", c.getLogin());
                return mv;
            }
            return null;        
    }
    
    @RequestMapping(value="transfertConseiller", method=RequestMethod.GET)
    String transfertConseiller()
    {
        return "transfertConseiller";
    }
    
    @RequestMapping (value="transfertConseiller", method=RequestMethod.POST)
    protected ModelAndView handleTransfertConseiller(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nom_operation = request.getParameter("nom_operation");
        String somme = request.getParameter("somme");
        String id_compte = request.getParameter("id_compte");
        HttpSession session = request.getSession(true);
            
        ConseillerEntity c = (ConseillerEntity)session.getAttribute("conseiller");
            if(c!=null){
                ModelAndView mv = new ModelAndView("transfertconseiller");
                CompteEntity cpt = cptService.findCompteId(Long.parseLong(id_compte));
                
                if(nom_operation != null && somme != null){
                    OperationCompteEntity op = new OperationCompteEntity(nom_operation, cpt.getType().toString(), "Banque", -(Float.parseFloat(somme)));
                    
                    opeService.addOperationCompte(op);
                    
                    cpt.addOperation(op);
                    cpt.retrieveMoney(Float.parseFloat(somme));
                    cptService.updateCompte(cpt);
                    
                    mv.addObject("id_compte",id_compte);
                    mv.addObject("typeCompte",cpt.getType().toString());
                    mv.addObject("loginUtilisateur",cpt.getUtilisateur().getLogin());
                    mv.addObject("nomUtilisateur",cpt.getUtilisateur().getNom());
                    mv.addObject("prenomUtilisateur",cpt.getUtilisateur().getPrenom());
                    mv.addObject("loginName", c.getLogin());
                    return mv;
                }else{
                    mv.addObject("id_compte",id_compte);
                    mv.addObject("typeCompte",cpt.getType().toString());
                    mv.addObject("loginUtilisateur",cpt.getUtilisateur().getLogin());
                    mv.addObject("nomUtilisateur",cpt.getUtilisateur().getNom());
                    mv.addObject("prenomUtilisateur",cpt.getUtilisateur().getPrenom());
                    mv.addObject("loginName", c.getLogin());
                    mv.addObject("submitMessage", "Merci de compléter tout les champs");
                    return mv; 
                }
                
                
                
            }
            return null;        
    }
    
    
}
