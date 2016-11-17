/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author yarbanga
 */
@Local
public interface DaoGeneriqueInterface {

    public <T> T create(T t); 
    public <T> void remove(T t); 
    public <T> T update (T t); 
    public <T> T findById(Class<T> t, Object id);
    public <T> List<T> findAll(Class<T> t);
}
