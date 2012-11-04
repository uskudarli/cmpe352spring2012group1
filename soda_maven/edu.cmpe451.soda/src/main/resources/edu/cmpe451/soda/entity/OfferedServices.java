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
import javax.persistence.Id;
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
@Table(name = "OfferedServices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfferedServices.findAll", query = "SELECT o FROM OfferedServices o"),
    @NamedQuery(name = "OfferedServices.findByOfferedServiceID", query = "SELECT o FROM OfferedServices o WHERE o.offeredServiceID = :offeredServiceID"),
    @NamedQuery(name = "OfferedServices.findByOfferedServiceOwnerID", query = "SELECT o FROM OfferedServices o WHERE o.offeredServiceOwnerID = :offeredServiceOwnerID"),
    @NamedQuery(name = "OfferedServices.findByServiceDescription", query = "SELECT o FROM OfferedServices o WHERE o.serviceDescription = :serviceDescription"),
    @NamedQuery(name = "OfferedServices.findByTags", query = "SELECT o FROM OfferedServices o WHERE o.tags = :tags"),
    @NamedQuery(name = "OfferedServices.findByBeginDate", query = "SELECT o FROM OfferedServices o WHERE o.beginDate = :beginDate"),
    @NamedQuery(name = "OfferedServices.findByEndDate", query = "SELECT o FROM OfferedServices o WHERE o.endDate = :endDate")})
public class OfferedServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OfferedServiceID")
    private Integer offeredServiceID;
    @Basic(optional = false)
    @Column(name = "OfferedServiceOwnerID")
    private int offeredServiceOwnerID;
    @Basic(optional = false)
    @Column(name = "ServiceDescription")
    private String serviceDescription;
    @Basic(optional = false)
    @Column(name = "Tags")
    private String tags;
    @Basic(optional = false)
    @Column(name = "BeginDate")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Basic(optional = false)
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public OfferedServices() {
    }

    public OfferedServices(Integer offeredServiceID) {
        this.offeredServiceID = offeredServiceID;
    }

    public OfferedServices(Integer offeredServiceID, int offeredServiceOwnerID, String serviceDescription, String tags, Date beginDate, Date endDate) {
        this.offeredServiceID = offeredServiceID;
        this.offeredServiceOwnerID = offeredServiceOwnerID;
        this.serviceDescription = serviceDescription;
        this.tags = tags;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Integer getOfferedServiceID() {
        return offeredServiceID;
    }

    public void setOfferedServiceID(Integer offeredServiceID) {
        this.offeredServiceID = offeredServiceID;
    }

    public int getOfferedServiceOwnerID() {
        return offeredServiceOwnerID;
    }

    public void setOfferedServiceOwnerID(int offeredServiceOwnerID) {
        this.offeredServiceOwnerID = offeredServiceOwnerID;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offeredServiceID != null ? offeredServiceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfferedServices)) {
            return false;
        }
        OfferedServices other = (OfferedServices) object;
        if ((this.offeredServiceID == null && other.offeredServiceID != null) || (this.offeredServiceID != null && !this.offeredServiceID.equals(other.offeredServiceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmpe451.soda.entity.OfferedServices[ offeredServiceID=" + offeredServiceID + " ]";
    }
    
}
