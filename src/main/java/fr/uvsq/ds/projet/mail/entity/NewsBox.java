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
@Table(name = "NEWSBOX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewsBox.findAll", query = "SELECT n FROM NewsBox n"),
    @NamedQuery(name = "NewsBox.findByNewsboxname", query = "SELECT n FROM NewsBox n WHERE n.newsboxname = :newsboxname")})
public class NewsBox implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NEWSBOXNAME")
    private String newsboxname;
    @ManyToMany(mappedBy = "newsBoxArrayList")
    private ArrayList<GroupMessage> groupMessageArrayList;
    @OneToMany(mappedBy = "newsboxname")
    private ArrayList<GroupMessage> groupMessageArrayList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsBox")
    private ArrayList<Acceder> accederArrayList;

    public NewsBox() {
    }

    public NewsBox(String newsboxname) {
        this.newsboxname = newsboxname;
    }

    public String getNewsboxname() {
        return newsboxname;
    }

    public void setNewsboxname(String newsboxname) {
        this.newsboxname = newsboxname;
    }

    @XmlTransient
    public ArrayList<GroupMessage> getGroupMessageArrayList() {
        return groupMessageArrayList;
    }

    public void setGroupMessageArrayList(ArrayList<GroupMessage> groupMessageArrayList) {
        this.groupMessageArrayList = groupMessageArrayList;
    }

    @XmlTransient
    public ArrayList<GroupMessage> getGroupMessageArrayList1() {
        return groupMessageArrayList1;
    }

    public void setGroupMessageArrayList1(ArrayList<GroupMessage> groupMessageArrayList1) {
        this.groupMessageArrayList1 = groupMessageArrayList1;
    }

    @XmlTransient
    public ArrayList<Acceder> getAccederArrayList() {
        return accederArrayList;
    }

    public void setAccederArrayList(ArrayList<Acceder> accederArrayList) {
        this.accederArrayList = accederArrayList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsboxname != null ? newsboxname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewsBox)) {
            return false;
        }
        NewsBox other = (NewsBox) object;
        if ((this.newsboxname == null && other.newsboxname != null) || (this.newsboxname != null && !this.newsboxname.equals(other.newsboxname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.uvsq.ds.projet.mail.entity.NewsBox[ newsboxname=" + newsboxname + " ]";
    }
    
}
