/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controleur;

import com.modele.Account;
import com.modele.Book;
import com.services.AccountService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Charles & Joel
 */
@Controller
public class AccountController {
    
    AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/")
    public String loginForm(HttpSession session, ModelMap model) {
        if(session.getAttribute("connecte") == null)
            return "login";
        else
            return "redirect:/books";
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/", params={"email","password"})
    public View login(HttpSession session,@RequestParam("email") String email,@RequestParam("password") String password, ModelMap model ) { 
        if(!"".equals(email.trim()) && !"".equals(password.trim())){
            Account a = accountService.getAccountByEmail(email);
            if (a != null && a.getPassword().equals(password)) {
                session.setAttribute("connecte", a.getEmail());
                return new RedirectView("/books", true, false, false);
            }
        }
        return new RedirectView("/", true, false, false);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/account/create")
    public ModelAndView AccountCreateForm(ModelMap model) {
        return new ModelAndView("ajouterCompte","account", new Account());
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/account/create")
    public View AccountCreate(@Validated @ModelAttribute("account")Account account, BindingResult result, ModelMap model) {
        String action = "/";
        if (result.hasErrors() || account == null){
            action += "account/create";
            return new RedirectView(action, true, false, false);     
        }
        if(!(this.accountService.add(account)))
            action += "account/create";

        return new RedirectView(action, true, false, false);     
    }
      
    @RequestMapping(method = RequestMethod.GET, value="/logout")
    public View logout(HttpSession session, ModelMap model) {
        if(session.getAttribute("connecte") != null){
            session.invalidate();
        }
        return new RedirectView("/", true, false, false);     
    }
    
    
    
    
}
