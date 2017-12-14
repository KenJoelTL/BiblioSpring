/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.SqlDAO;
import java.util.List;

/**
 *
 * @author Joel
 */
public abstract class Service<T> {
    protected SqlDAO<T> dao;

    public void setDao(SqlDAO<T> dao) {
        this.dao = dao;
    }
    
    public abstract boolean add(T x);
    public abstract boolean remove(T x);
    public abstract boolean update(T x);
    public abstract List<T> getAll();
}
