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
public class ConnectController {

    @Autowired
    private UtilisateurService uService;
    
    @RequestMapping(value="index", method = RequestMethod.GET)
    public String initIndex(){
	return "index";
    }
    @RequestMapping(value="wall*", method = RequestMethod.GET)
    public ModelAndView initWall(HttpServletRequest request){
	HttpSession session = request.getSession(false);
        if (session!=null)
        {
            Utilisateur u = (Utilisateur)session.getAttribute("user");
            String login = u.getLogin();
            ModelAndView mv = new ModelAndView("wall");
            String bienvenu = "Bienvenu "+login;
            mv.addObject("helloMessage",bienvenu);
            return mv;
        }
        else
        {
            ModelAndView mv = new ModelAndView("index");
            mv.addObject("infoMessage1","<div class=\"alert alert-danger\" role=\"alert\"> Session problem !</div>");
            return mv;       
        }
    }
    
    @RequestMapping(value="wall", method = RequestMethod.POST)
    public ModelAndView handleWall(HttpServletRequest request,HttpServletResponse response) 
    throws Exception 
    { 
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        if (!login.equals("") && !pass.equals(""))
        {
            HttpSession session = request.getSession(true);
            if (session!=null)
            {
                UtilisateurEntity u = uService.getUser(new UtilisateurEntity(login,pass));
                if (u!=null)
                {
                    session.setAttribute("user",u);
                    ModelAndView mv = new ModelAndView("wall");
                    String bienvenu = "Bienvenu "+login;
                   
                    mv.addObject("helloMessage",bienvenu);
                    return mv;
                }
                else
                {
                    ModelAndView mv = new ModelAndView("index");
                    mv.addObject("infoMessage", "<div class=\"alert alert-primary\" role=\"alert\"> Erreur login / password</div>");
                    return mv;
                }
            }
            else
            {
                ModelAndView mv = new ModelAndView("index");
                mv.addObject("infoMessage1","<div class=\"alert alert-danger\" role=\"alert\"> Session problem !</div>");
                return mv;  
            }
        }
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("infoMessage","<div class=\"alert alert-primary\" role=\"alert\"> champs incomplets !</div>");
        return mv;        
    }
    
    
}
