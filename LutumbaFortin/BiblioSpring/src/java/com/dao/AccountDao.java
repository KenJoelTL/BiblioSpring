/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.modele.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joel
 */
public class AccountDao extends SqlDAO<Account>{

    @Override
    public boolean create(Account x) {
        String q = "INSERT INTO account (EMAIL, NAME, LAST_NAME, PASSWORD) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement(q);
            stm.setString(1, x.getEmail());
            stm.setString(2, x.getName());
            stm.setString(3, x.getLastName());
            stm.setString(4, x.getPassword());
            return stm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean delete(Account x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Account x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account findById(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account findById(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Account findByCourriel(String x) {
        Account a = null;
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM account WHERE EMAIL=?");
            stm.setString(1, x);
            ResultSet res = stm.executeQuery();
            if (res.next()){
                a = new Account();
                a.setEmail(res.getString("EMAIL"));
                a.setLastName(res.getString("LAST_NAME"));
                a.setName(res.getString("NAME"));
                a.setPassword(res.getString("PASSWORD"));
                a.setIdAccount(res.getInt("ID_ACCOUNT"));
            }
            else {
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    } 
    
    @Override
    public List<Account> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
