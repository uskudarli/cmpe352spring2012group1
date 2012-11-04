/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmpe451.soda.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aurora
 */
@Entity
@Table(name = "offered_services", catalog = "database1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfferedServices.findAll", query = "SELECT o FROM OfferedServices o"),
    @NamedQuery(name = "OfferedServices.findById", query = "SELECT o FROM OfferedServices o WHERE o.id = :id"),
    @NamedQuery(name = "OfferedServices.findByUserId", query = "SELECT o FROM OfferedServices o WHERE o.userId = :userId"),
    @NamedQuery(name = "OfferedServices.findByTitle", query = "SELECT o FROM OfferedServices o WHERE o.title = :title"),
    @NamedQuery(name = "OfferedServices.findByTag", query = "SELECT o FROM OfferedServices o WHERE o.tag = :tag"),
    @NamedQuery(name = "OfferedServices.findByBeginDate", query = "SELECT o FROM OfferedServices o WHERE o.beginDate = :beginDate"),
    @NamedQuery(name = "OfferedServices.findByEndDate", query = "SELECT o FROM OfferedServices o WHERE o.endDate = :endDate"),
    @NamedQuery(name = "OfferedServices.findByEnabled", query = "SELECT o FROM OfferedServices o WHERE o.enabled = :enabled")})
public class OfferedServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "desc")
    private String desc;
    @Basic(optional = false)
    @Column(name = "tag")
    private String tag;
    @Basic(optional = false)
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;

    public OfferedServices() {
    }

    public OfferedServices(Integer id) {
        this.id = id;
    }

    public OfferedServices(Integer id, int userId, String title, String desc, String tag, Date beginDate, Date endDate, boolean enabled) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.desc = desc;
        this.tag = tag;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfferedServices)) {
            return false;
        }
        OfferedServices other = (OfferedServices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmpe451.soda.entity.OfferedServices[ id=" + id + " ]";
    }
    
}
