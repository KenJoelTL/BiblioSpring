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
public class BookService extends Service<Book>{

    @Override
    public boolean add(Book x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Book x) {
        return dao.delete(x);
    }

    @Override
    public boolean update(Book x) {
        return dao.update(x);
    }

    @Override
    public List<Book> getAll() {
        return dao.findAll();
    }

}
