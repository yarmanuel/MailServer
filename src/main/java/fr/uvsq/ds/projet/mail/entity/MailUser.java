/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yarbanga
 */
@Entity
@Table(name = "MAILUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MailUser.findAll", query = "SELECT m FROM MailUser m"),
    @NamedQuery(name = "MailUser.findByLogin", query = "SELECT m FROM MailUser m WHERE m.login = :login"),
    @NamedQuery(name = "MailUser.findByFirstname", query = "SELECT m FROM MailUser m WHERE m.firstname = :firstname"),
    @NamedQuery(name = "MailUser.findByLastname", query = "SELECT m FROM MailUser m WHERE m.lastname = :lastname"),
    @NamedQuery(name = "MailUser.findByPass", query = "SELECT m FROM MailUser m WHERE m.pass = :pass")})
public class MailUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 255)
    @Column(name = "PASS")
    private String pass;
    @ManyToMany(mappedBy = "mailUserArrayList")
    private ArrayList<MailBox> mailBoxArrayList;

    public MailUser() {
    }

    public MailUser(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   
    public ArrayList<MailBox> getMailBoxArrayList() {
        return mailBoxArrayList;
    }

    public void setMailBoxArrayList(ArrayList<MailBox> mailBoxArrayList) {
        this.mailBoxArrayList = mailBoxArrayList;
    }


   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MailUser)) {
            return false;
        }
        MailUser other = (MailUser) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.ds.projet.mail.entity.MailUser[ login=" + login + " ]";
    }
    
}
