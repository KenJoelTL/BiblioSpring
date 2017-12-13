/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.modele.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author usager
 */
public class BookDao extends SqlDAO<Book>{

    private EntityManagerFactory entityFactory;
    
    @Override
    public boolean create(Book x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Book x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Book x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book findById(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book findById(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> findAll() {
        EntityManager em = entityFactory.createEntityManager();
        Query q = em.createNamedQuery("Book.findAll");
        
        for (Object object : q.getResultList()) {
            System.out.println("\n"+object);
        }
        
        return q.getResultList();
    }

    public void setEntityFactory(EntityManagerFactory entityFactory) {
        this.entityFactory = entityFactory;
        System.out.println(entityFactory);
    }
    
}
