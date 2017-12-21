/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controleur;

import com.modele.Book;
import com.services.BookService;
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
 * @author Joel
 */
@Controller
public class BookController {
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String BooksList(HttpSession session, ModelMap model) {
        if(session.getAttribute("connecte") != null){

            List<Book> liste = this.bookService.getAll();
            model.addAttribute("titre", "Page de livres");
            model.addAttribute("liste", liste);
            return "index";
        }
        return "redirect:/";
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/books/create")
    public ModelAndView BooksShowCreateForm(HttpSession session, ModelMap model) {
        if(session.getAttribute("connecte") != null){

        model.addAttribute("titre", "Ajout");
        return new ModelAndView("ajouterLivre","book", new Book());
        }
        return new ModelAndView(new RedirectView("/",true,false,false)); 
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/books/create")
    public View BooksCreate(HttpSession session,@Validated @ModelAttribute("book")Book book, BindingResult result, ModelMap model) {
        if(session.getAttribute("connecte") != null){

        String action = "/books";
        if (result.hasErrors() || book == null){
            action += "/create";
            return new RedirectView(action, true, false, false);     
        }
        if(!(this.bookService.add(book)))
            action += "/create";

        return new RedirectView(action, true, false, false); 
        }
       return  new RedirectView("/",true,false,false);    
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/books/update", params={"isbn"})
    public ModelAndView BooksShowUpdateForm(HttpSession session,@RequestParam("isbn") String isbn, ModelMap model) {
        if(session.getAttribute("connecte") != null){

            Book b = new Book();
            b.setIsbn(isbn);
            List<Book> liste = this.bookService.getAll();
            int index = liste.indexOf(b);
            if (index >= 0){
                b = liste.get(index);
                model.addAttribute("titre", "Modification");
                model.addAttribute("livre", b);
                return new ModelAndView("modifierLivre","book",b);
            }
            else{
                //return new ModelAndView("redirect:/books"); 
                return new ModelAndView(new RedirectView("/books",true,false,false));
            }
        
        }
        return new ModelAndView(new RedirectView("/",true,false,false));

    }
    
    @RequestMapping(method = RequestMethod.POST, value="/books/update")
    public View BooksUpdate(HttpSession session,@Validated @ModelAttribute("book")Book book, BindingResult result, ModelMap model) {
        if(session.getAttribute("connecte") != null){
            if (book != null) {
                if (result.hasErrors()) {
                    return new RedirectView("/books/update/?isbn="+book.getIsbn(),true,false,false);
                }
                if(!this.bookService.update(book))
                    return new RedirectView("/books/update/?isbn="+book.getIsbn(), true, false, false);     
            }
            return new RedirectView("/books", true, false, false);     
        }
        return new RedirectView("/", true, false, false);

    }
    
    @RequestMapping(method = RequestMethod.GET, value="/books/delete", params={"isbn"})
    public View BooksDelete(HttpSession session, @RequestParam("isbn") String isbn,ModelMap model) {
        if(session.getAttribute("connecte") != null){
            Book b = new Book();
            b.setIsbn(isbn);
            this.bookService.remove(b);
            return new RedirectView("/books", true, false, false);
        }
        return new RedirectView("/", true, false, false);
    }
    
    
}
