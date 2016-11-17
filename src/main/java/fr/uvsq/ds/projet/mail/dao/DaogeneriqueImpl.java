/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.dao;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author yarbanga
 */
@Stateless
@LocalBean
public class DaogeneriqueImpl implements DaoGeneriqueInterface{
    @PersistenceContext(unitName="pumailbox")
    EntityManager em ; 
    
    @Override
    public <T> T create(T t) {
        
        em.persist(t);
        em.flush();
        em.refresh(t);
        return t; 
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public <T> void remove(T t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T update(T t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T findById(Class<T> t, Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> List<T> findAll(Class<T> t) {
        
        String q = t.getSimpleName()+".findAll";
        
        TypedQuery<T>  query = em.createNamedQuery(q,t);
        
        return query.getResultList(); 
    }

}
