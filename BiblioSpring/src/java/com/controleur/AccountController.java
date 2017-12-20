/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controleur;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Joel
 */
@Controller
public class AccountController {
    
    @RequestMapping("/")
    public String login(ModelMap model) {
        /*List<String> liste = this.converterService.getMonnaiesListe();
        model.addAttribute("bienvenue", "Bienvenue au service de conversion de monnaies");
        model.addAttribute("monnaies", liste);*/
        return "login";
    }
    
}
