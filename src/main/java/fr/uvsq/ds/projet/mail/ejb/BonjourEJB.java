/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.ejb;

import javax.ejb.Stateless;
// javax.ejb.LocalBean;

/**
 *
 * @author yarbanga
 */
@Stateless(mappedName="bonjour")
public class BonjourEJB implements Bonjour{

    @Override
    public String bonjour() {
       return "Hello World !!!!";
    }

}
