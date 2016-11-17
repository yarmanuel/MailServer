/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.ejb;

import java.util.Collection;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author yarbanga
 */
@Remote
public interface Itest {
    
    public <T> T create(T t); 
    public <T> void remove(T t); 
    public <T> T update (T t); 
    public <T> T findById(Class<T> t, Object id);
    public <T> Collection<T> findAll(Class<T> t);
}
