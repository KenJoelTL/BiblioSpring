/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.BookDao;
import com.modele.Book;
import java.util.List;

/**
 *
 * @author Moumene
 */
public class BookService {
    
    private BookDao dao;

    public void setDao(BookDao dao) {
        this.dao = dao;
    }
    
    public boolean add(Book b){
        return dao.create(b);
    }
    
    public boolean remove(Book b){
        return dao.delete(b);
    }
    
    public boolean update(Book b){
        return dao.update(b);
    }      
    
    public List<Book> getBookListe() {             
        return dao.findAll();
    }
}
