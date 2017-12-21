/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.modele.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Joel
 */
public class BookDao extends SqlDAO<Book>{

    //private EntityManagerFactory entityFactory;
    
    @Override
    public boolean create(Book x) {
        String q = "INSERT INTO book (AUTHOR, TITLE, NB_PAGES, EDITION, LANGUAGE,"
                + " YEAR, DESCRIPTION, KEYWORDS, ISBN) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement(q);
            stm.setString(1, x.getAuthor());
            stm.setString(2, x.getTitle());
            stm.setInt(3, x.getNbPages());
            stm.setString(4, x.getEdition());
            stm.setString(5, x.getLanguage());
            stm.setInt(6, x.getYear());
            stm.setString(7, x.getDescription());
            stm.setString(8, x.getKeywords());
            stm.setString(9, x.getIsbn());
            return stm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(Book x) {
        String q = "DELETE FROM book WHERE ISBN = ?";
        
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement(q);
            stm.setString(1, x.getIsbn());
            return stm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    @Override
    public boolean update(Book x) {
        System.out.println("UPDAAAAAATE");
        
        String q = "UPDATE book SET AUTHOR = ?, TITLE = ?, NB_PAGES = ?, "
                 + "EDITION = ?, LANGUAGE = ?, YEAR = ?, DESCRIPTION = ?, "
                 + "KEYWORDS = ? WHERE ISBN = ?";
        
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement(q);
            stm.setString(1, x.getAuthor());
            stm.setString(2, x.getTitle());
            stm.setInt(3, x.getNbPages());
            stm.setString(4, x.getEdition());
            stm.setString(5, x.getLanguage());
            stm.setInt(6, x.getYear());
            stm.setString(7, x.getDescription());
            stm.setString(8, x.getKeywords());
            stm.setString(9, x.getIsbn());
            return stm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }

    @Override
    public Book findById(String x) {
               Book b = null;
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM book WHERE ISBN=?");
            stm.setString(1, x);
            ResultSet res = stm.executeQuery();
            if (res.next()){
                b = new Book();
                b.setIsbn(res.getString("ISBN"));
                b.setAuthor(res.getString("AUTHOR"));
                b.setTitle(res.getString("TITLE"));
                b.setNbPages(res.getInt("NB_PAGES"));
                b.setEdition(res.getString("EDITION"));
                b.setLanguage(res.getString("LANGUAGE"));
                b.setYear(res.getInt("YEAR"));
                b.setDescription(res.getString("DESCRIPTION"));
                b.setKeywords(res.getString("KEYWORDS"));
            }
            else {
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    @Override
    public Book findById(int x) {
        return findById(""+x);
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
            stm.close();
            res.close();
            
        } catch (SQLException e) {
            
        }
        return liste;

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
    }
/*
    public void setEntityFactory(EntityManagerFactory entityFactory) {
        this.entityFactory = entityFactory;
        System.out.println(entityFactory);
    }*/
    
}
