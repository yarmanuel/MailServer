/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.ds.projet.mail.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yarbanga
 */
@Entity
@Table(name = "USERMESSAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMessage.findAll", query = "SELECT u FROM UserMessage u"),
    @NamedQuery(name = "UserMessage.findByIdusermessage", query = "SELECT u FROM UserMessage u WHERE u.idusermessage = :idusermessage"),
    @NamedQuery(name = "UserMessage.findByBody", query = "SELECT u FROM UserMessage u WHERE u.body = :body"),
    @NamedQuery(name = "UserMessage.findByCreateddate", query = "SELECT u FROM UserMessage u WHERE u.createddate = :createddate"),
    @NamedQuery(name = "UserMessage.findBySubject", query = "SELECT u FROM UserMessage u WHERE u.subject = :subject")})
public class UserMessage implements Serializable {
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
    @JoinColumn(name = "SENDERNAME", referencedColumnName = "MAILBOXNAME")
    @ManyToOne
    private MailBox sendername;
    @JoinColumn(name = "RECEIVERNAME", referencedColumnName = "MAILBOXNAME")
    @ManyToOne
    private MailBox receivername;

    public UserMessage() {
    }

    public UserMessage(Integer idusermessage) {
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

    public MailBox getSendername() {
        return sendername;
    }

    public void setSendername(MailBox sendername) {
        this.sendername = sendername;
    }

    public MailBox getReceivername() {
        return receivername;
    }

    public void setReceivername(MailBox receivername) {
        this.receivername = receivername;
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
        if (!(object instanceof UserMessage)) {
            return false;
        }
        UserMessage other = (UserMessage) object;
        if ((this.idusermessage == null && other.idusermessage != null) || (this.idusermessage != null && !this.idusermessage.equals(other.idusermessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.ds.projet.mail.entity.UserMessage[ idusermessage=" + idusermessage + " ]";
    }
    
}
