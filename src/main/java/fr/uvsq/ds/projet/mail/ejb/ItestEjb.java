/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.ejb;

import fr.uvsq.ds.projet.mail.dao.DaogeneriqueImpl;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author yarbanga
 */
@Stateless(mappedName="itest")
public class ItestEjb  implements Itest{
    
    @EJB
    private DaogeneriqueImpl dao; 

    @Override
    public <T> T create(T t) {
        
        dao.create(t);
        return null;
       
        
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
    public <T> Collection findAll(Class<T> t) {
        
               ArrayList l = new ArrayList();
               l.add(dao.findAll(t).get(0)); 
               return l;
               
      
                  
        
                
           
    }

}
