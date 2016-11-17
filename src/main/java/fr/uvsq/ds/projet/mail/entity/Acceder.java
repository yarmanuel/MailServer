/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yarbanga
 */
@Entity
@Table(name = "ACCEDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceder.findAll", query = "SELECT a FROM Acceder a"),
    @NamedQuery(name = "Acceder.findByDroitecriture", query = "SELECT a FROM Acceder a WHERE a.droitecriture = :droitecriture"),
    @NamedQuery(name = "Acceder.findByNewsboxname", query = "SELECT a FROM Acceder a WHERE a.accederPK.newsboxname = :newsboxname"),
    @NamedQuery(name = "Acceder.findByLogin", query = "SELECT a FROM Acceder a WHERE a.accederPK.login = :login")})
public class Acceder implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccederPK accederPK;
    @Column(name = "DROITECRITURE")
    private Integer droitecriture;
    @JoinColumn(name = "NEWSBOXNAME", referencedColumnName = "NEWSBOXNAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private NewsBox newsBox;
    @JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MailUser mailUser;

    public Acceder() {
    }

    public Acceder(AccederPK accederPK) {
        this.accederPK = accederPK;
    }

    public Acceder(String newsboxname, String login) {
        this.accederPK = new AccederPK(newsboxname, login);
    }

    public AccederPK getAccederPK() {
        return accederPK;
    }

    public void setAccederPK(AccederPK accederPK) {
        this.accederPK = accederPK;
    }

    public Integer getDroitecriture() {
        return droitecriture;
    }

    public void setDroitecriture(Integer droitecriture) {
        this.droitecriture = droitecriture;
    }

    public NewsBox getNewsBox() {
        return newsBox;
    }

    public void setNewsBox(NewsBox newsBox) {
        this.newsBox = newsBox;
    }

    public MailUser getMailUser() {
        return mailUser;
    }

    public void setMailUser(MailUser mailUser) {
        this.mailUser = mailUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accederPK != null ? accederPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceder)) {
            return false;
        }
        Acceder other = (Acceder) object;
        if ((this.accederPK == null && other.accederPK != null) || (this.accederPK != null && !this.accederPK.equals(other.accederPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.ds.projet.mail.entity.Acceder[ accederPK=" + accederPK + " ]";
    }
    
}
