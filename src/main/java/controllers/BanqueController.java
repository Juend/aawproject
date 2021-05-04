/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UtilisateurEntity;
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
import service.UtilisateurService;
import model.Utilisateur;
import java.util.ArrayList;

@Controller
public class BanqueController {

    @Autowired
    UtilisateurService uService;
    
    
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
    
    
    @RequestMapping(value="index", method=RequestMethod.GET)
    String initIndex()
    {
        return "index";
    }
    
    @RequestMapping(value="wall", method=RequestMethod.GET)
    String initWall()
    {
        return "wall";
    }
    
    @RequestMapping(value="acceuil", method=RequestMethod.GET)
    String initAcceuil()
    {
        return "acceuil";
    }
    
    @RequestMapping(value="disconnect", method=RequestMethod.GET)
    String initDisconnect()
    {
        return "disconnect";
    }
    
    @RequestMapping(value="connect", method=RequestMethod.POST)
    ModelAndView connect(HttpServletRequest request)
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
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
    }
    
}
