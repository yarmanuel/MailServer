/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "MAILBOX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MailBox.findAll", query = "SELECT m FROM MailBox m"),
    @NamedQuery(name = "MailBox.findByMailboxname", query = "SELECT m FROM MailBox m WHERE m.mailboxname = :mailboxname")})
public class MailBox implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MAILBOXNAME")
    private String mailboxname;
    @JoinTable(name = "MU_MB", joinColumns = {
        @JoinColumn(name = "MBFK", referencedColumnName = "MAILBOXNAME")}, inverseJoinColumns = {
        @JoinColumn(name = "MUFK", referencedColumnName = "LOGIN")})
    @ManyToMany
    private ArrayList<MailUser> mailUserArrayList;
    @OneToMany(mappedBy = "sendername")
    private ArrayList<GroupMessage> groupMessageArrayList;
    @OneToMany(mappedBy = "sendername")
    private ArrayList<UserMessage> userMessageArrayList;
    @OneToMany(mappedBy = "receivername")
    private ArrayList<UserMessage> userMessageArrayList1;
    @JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN")
    @ManyToOne
    private MailUser login;

    public MailBox() {
    }

    public MailBox(String mailboxname) {
        this.mailboxname = mailboxname;
    }

    public String getMailboxname() {
        return mailboxname;
    }

    public void setMailboxname(String mailboxname) {
        this.mailboxname = mailboxname;
    }

    @XmlTransient
    public ArrayList<MailUser> getMailUserArrayList() {
        return mailUserArrayList;
    }

    public void setMailUserArrayList(ArrayList<MailUser> mailUserArrayList) {
        this.mailUserArrayList = mailUserArrayList;
    }

    @XmlTransient
    public ArrayList<GroupMessage> getGroupMessageArrayList() {
        return groupMessageArrayList;
    }

    public void setGroupMessageArrayList(ArrayList<GroupMessage> groupMessageArrayList) {
        this.groupMessageArrayList = groupMessageArrayList;
    }

    @XmlTransient
    public ArrayList<UserMessage> getUserMessageArrayList() {
        return userMessageArrayList;
    }

    public void setUserMessageArrayList(ArrayList<UserMessage> userMessageArrayList) {
        this.userMessageArrayList = userMessageArrayList;
    }

    @XmlTransient
    public ArrayList<UserMessage> getUserMessageArrayList1() {
        return userMessageArrayList1;
    }

    public void setUserMessageArrayList1(ArrayList<UserMessage> userMessageArrayList1) {
        this.userMessageArrayList1 = userMessageArrayList1;
    }

    public MailUser getLogin() {
        return login;
    }

    public void setLogin(MailUser login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailboxname != null ? mailboxname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MailBox)) {
            return false;
        }
        MailBox other = (MailBox) object;
        if ((this.mailboxname == null && other.mailboxname != null) || (this.mailboxname != null && !this.mailboxname.equals(other.mailboxname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.ds.projet.mail.entity.MailBox[ mailboxname=" + mailboxname + " ]";
    }
    
}
