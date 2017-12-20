/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.modele.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author usager
 */
public class BookDao extends SqlDAO<Book>{

    //private EntityManagerFactory entityFactory;
    
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
        /*EntityManager em = entityFactory.createEntityManager();
        Query q = em.createNamedQuery("Book.findAll");
        
        for (Object object : q.getResultList()) {
            System.out.println("\n"+object);
        }
        
        return q.getResultList();*/
        
        String q = "Select * from book";
        List<Book> liste = new LinkedList<>();
        try {
            Statement stm = connexion.getInstance().createStatement();
            ResultSet res = stm.executeQuery(q);
            while (res.next()) {
                Book b = new Book();
                b.setIsbn(res.getString("ISBN"));
                b.setAuthor(res.getString("AUTHOR"));
                b.setTitle(res.getString("TITLE"));
                b.setNbPages(res.getInt("NB_PAGES"));
                b.setEdition(res.getString("EDITION"));
                b.setLanguage(res.getString("LANGUAGE"));
                b.setYear(res.getInt("YEAR"));
                b.setDescription(res.getString("DESCRIPTION"));
                b.setKeywords(res.getString("KEYWORDS"));
                liste.add(b);
            }
            
        } catch (SQLException e) {
            
        }
        
        /*
        
        List<Monnaie> liste = new LinkedList<>();
        Monnaie monnaie;
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM monnaie");
            ResultSet res = stm.executeQuery();
            while (res.next()){
                monnaie = new Monnaie();
                monnaie.setNom(res.getString("NOM"));
                monnaie.setValeur(res.getDouble("VALEUR"));
                liste.add(monnaie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConverterDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
        */
        return liste;
    }
/*
    public void setEntityFactory(EntityManagerFactory entityFactory) {
        this.entityFactory = entityFactory;
        System.out.println(entityFactory);
    }*/
    
}
