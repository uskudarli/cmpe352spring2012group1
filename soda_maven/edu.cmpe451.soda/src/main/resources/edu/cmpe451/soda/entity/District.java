/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmpe451.soda.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aurora
 */
@Entity
@Table(name = "District")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d"),
    @NamedQuery(name = "District.findByCityID", query = "SELECT d FROM District d WHERE d.districtPK.cityID = :cityID"),
    @NamedQuery(name = "District.findByTownID", query = "SELECT d FROM District d WHERE d.districtPK.townID = :townID"),
    @NamedQuery(name = "District.findByDistrictID", query = "SELECT d FROM District d WHERE d.districtPK.districtID = :districtID"),
    @NamedQuery(name = "District.findByDistrictName", query = "SELECT d FROM District d WHERE d.districtName = :districtName")})
public class District implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DistrictPK districtPK;
    @Basic(optional = false)
    @Column(name = "DistrictName")
    private String districtName;

    public District() {
    }

    public District(DistrictPK districtPK) {
        this.districtPK = districtPK;
    }

    public District(DistrictPK districtPK, String districtName) {
        this.districtPK = districtPK;
        this.districtName = districtName;
    }

    public District(int cityID, int townID, int districtID) {
        this.districtPK = new DistrictPK(cityID, townID, districtID);
    }

    public DistrictPK getDistrictPK() {
        return districtPK;
    }

    public void setDistrictPK(DistrictPK districtPK) {
        this.districtPK = districtPK;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtPK != null ? districtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.districtPK == null && other.districtPK != null) || (this.districtPK != null && !this.districtPK.equals(other.districtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmpe451.soda.entity.District[ districtPK=" + districtPK + " ]";
    }
    
}
