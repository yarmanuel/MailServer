/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.ejb;

import javax.ejb.Remote;

/**
 *
 * @author yarbanga
 */
@Remote
public interface Ibox<T> {
    
    public String create(T t);
            
    public String bonjour(); 
    
    public T read();
}
