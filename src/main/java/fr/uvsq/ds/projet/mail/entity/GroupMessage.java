/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yarbanga
 */
@Entity
@Table(name = "GROUPMESSAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupMessage.findAll", query = "SELECT g FROM GroupMessage g"),
    @NamedQuery(name = "GroupMessage.findByIdusermessage", query = "SELECT g FROM GroupMessage g WHERE g.idusermessage = :idusermessage"),
    @NamedQuery(name = "GroupMessage.findByBody", query = "SELECT g FROM GroupMessage g WHERE g.body = :body"),
    @NamedQuery(name = "GroupMessage.findByCreateddate", query = "SELECT g FROM GroupMessage g WHERE g.createddate = :createddate"),
    @NamedQuery(name = "GroupMessage.findBySubject", query = "SELECT g FROM GroupMessage g WHERE g.subject = :subject")})
public class GroupMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSERMESSAGE")
    private Integer idusermessage;
    @Size(max = 255)
    @Column(name = "BODY")
    private String body;
    @Column(name = "CREATEDDATE")
    @Temporal(TemporalType.DATE)
    private Date createddate;
    @Size(max = 255)
    @Column(name = "SUBJECT")
    private String subject;
    @JoinTable(name = "NB_GM", joinColumns = {
        @JoinColumn(name = "GMFK", referencedColumnName = "IDUSERMESSAGE")}, inverseJoinColumns = {
        @JoinColumn(name = "NBFK", referencedColumnName = "NEWSBOXNAME")})
    @ManyToMany
    private ArrayList<NewsBox> newsBoxArrayList;
    @JoinColumn(name = "NEWSBOXNAME", referencedColumnName = "NEWSBOXNAME")
    @ManyToOne
    private NewsBox newsboxname;
    @JoinColumn(name = "SENDERNAME", referencedColumnName = "MAILBOXNAME")
    @ManyToOne
    private MailBox sendername;

    public GroupMessage() {
    }

    public GroupMessage(Integer idusermessage) {
        this.idusermessage = idusermessage;
    }

    public Integer getIdusermessage() {
        return idusermessage;
    }

    public void setIdusermessage(Integer idusermessage) {
        this.idusermessage = idusermessage;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @XmlTransient
    public ArrayList<NewsBox> getNewsBoxArrayList() {
        return newsBoxArrayList;
    }

    public void setNewsBoxArrayList(ArrayList<NewsBox> newsBoxArrayList) {
        this.newsBoxArrayList = newsBoxArrayList;
    }

    public NewsBox getNewsboxname() {
        return newsboxname;
    }

    public void setNewsboxname(NewsBox newsboxname) {
        this.newsboxname = newsboxname;
    }

    public MailBox getSendername() {
        return sendername;
    }

    public void setSendername(MailBox sendername) {
        this.sendername = sendername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusermessage != null ? idusermessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMessage)) {
            return false;
        }
        GroupMessage other = (GroupMessage) object;
        if ((this.idusermessage == null && other.idusermessage != null) || (this.idusermessage != null && !this.idusermessage.equals(other.idusermessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.ds.projet.mail.entity.GroupMessage[ idusermessage=" + idusermessage + " ]";
    }
    
}
