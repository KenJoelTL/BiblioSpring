/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.AccountDao;
import com.modele.Account;
import java.util.List;

/**
 *
 * @author usager
 */
public class AccountService extends Service<Account>{

    @Override
    public boolean add(Account x) {
        return dao.create(x);
    }

    @Override
    public boolean remove(Account x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Account x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Account getAccountByEmail(String email) {
        return ((AccountDao)dao).findByCourriel(email);
    }
    
    
    
}
