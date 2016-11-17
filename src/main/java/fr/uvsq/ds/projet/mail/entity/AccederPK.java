/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author yarbanga
 */
@Embeddable
public class AccederPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NEWSBOXNAME")
    private String newsboxname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LOGIN")
    private String login;

    public AccederPK() {
    }

    public AccederPK(String newsboxname, String login) {
        this.newsboxname = newsboxname;
        this.login = login;
    }

    public String getNewsboxname() {
        return newsboxname;
    }

    public void setNewsboxname(String newsboxname) {
        this.newsboxname = newsboxname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsboxname != null ? newsboxname.hashCode() : 0);
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccederPK)) {
            return false;
        }
        AccederPK other = (AccederPK) object;
        if ((this.newsboxname == null && other.newsboxname != null) || (this.newsboxname != null && !this.newsboxname.equals(other.newsboxname))) {
            return false;
        }
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.ds.projet.mail.entity.AccederPK[ newsboxname=" + newsboxname + ", login=" + login + " ]";
    }
    
}
