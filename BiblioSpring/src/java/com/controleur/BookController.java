/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controleur;

import com.modele.Book;
import com.services.BookService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String BooksList(ModelMap model) {
        List<Book> liste = this.bookService.getAll();
        model.addAttribute("titre", "Page de livre");
        model.addAttribute("liste", liste);
        return "listeLivre";
    }
    
}
