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
    
    @RequestMapping(value="sign", method=RequestMethod.GET)
    String initSign()
    {
        return "sign";
    }

    
}
