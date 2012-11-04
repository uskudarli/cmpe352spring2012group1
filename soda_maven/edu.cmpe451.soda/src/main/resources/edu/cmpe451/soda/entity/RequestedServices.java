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
@Table(name = "RequestedServices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestedServices.findAll", query = "SELECT r FROM RequestedServices r"),
    @NamedQuery(name = "RequestedServices.findByRequestedServiceID", query = "SELECT r FROM RequestedServices r WHERE r.requestedServiceID = :requestedServiceID"),
    @NamedQuery(name = "RequestedServices.findByRequesterID", query = "SELECT r FROM RequestedServices r WHERE r.requesterID = :requesterID"),
    @NamedQuery(name = "RequestedServices.findByDescription", query = "SELECT r FROM RequestedServices r WHERE r.description = :description"),
    @NamedQuery(name = "RequestedServices.findByTags", query = "SELECT r FROM RequestedServices r WHERE r.tags = :tags"),
    @NamedQuery(name = "RequestedServices.findByBeginDate", query = "SELECT r FROM RequestedServices r WHERE r.beginDate = :beginDate"),
    @NamedQuery(name = "RequestedServices.findByEndDate", query = "SELECT r FROM RequestedServices r WHERE r.endDate = :endDate")})
public class RequestedServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RequestedServiceID")
    private Integer requestedServiceID;
    @Basic(optional = false)
    @Column(name = "RequesterID")
    private int requesterID;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
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

    public RequestedServices() {
    }

    public RequestedServices(Integer requestedServiceID) {
        this.requestedServiceID = requestedServiceID;
    }

    public RequestedServices(Integer requestedServiceID, int requesterID, String description, String tags, Date beginDate, Date endDate) {
        this.requestedServiceID = requestedServiceID;
        this.requesterID = requesterID;
        this.description = description;
        this.tags = tags;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Integer getRequestedServiceID() {
        return requestedServiceID;
    }

    public void setRequestedServiceID(Integer requestedServiceID) {
        this.requestedServiceID = requestedServiceID;
    }

    public int getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(int requesterID) {
        this.requesterID = requesterID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (requestedServiceID != null ? requestedServiceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestedServices)) {
            return false;
        }
        RequestedServices other = (RequestedServices) object;
        if ((this.requestedServiceID == null && other.requestedServiceID != null) || (this.requestedServiceID != null && !this.requestedServiceID.equals(other.requestedServiceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmpe451.soda.entity.RequestedServices[ requestedServiceID=" + requestedServiceID + " ]";
    }
    
}
