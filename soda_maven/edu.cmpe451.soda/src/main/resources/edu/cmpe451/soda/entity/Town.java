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
@Table(name = "Town")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Town.findAll", query = "SELECT t FROM Town t"),
    @NamedQuery(name = "Town.findByCityID", query = "SELECT t FROM Town t WHERE t.townPK.cityID = :cityID"),
    @NamedQuery(name = "Town.findByTownID", query = "SELECT t FROM Town t WHERE t.townPK.townID = :townID"),
    @NamedQuery(name = "Town.findByTownName", query = "SELECT t FROM Town t WHERE t.townName = :townName")})
public class Town implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TownPK townPK;
    @Basic(optional = false)
    @Column(name = "TownName")
    private String townName;

    public Town() {
    }

    public Town(TownPK townPK) {
        this.townPK = townPK;
    }

    public Town(TownPK townPK, String townName) {
        this.townPK = townPK;
        this.townName = townName;
    }

    public Town(int cityID, int townID) {
        this.townPK = new TownPK(cityID, townID);
    }

    public TownPK getTownPK() {
        return townPK;
    }

    public void setTownPK(TownPK townPK) {
        this.townPK = townPK;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (townPK != null ? townPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Town)) {
            return false;
        }
        Town other = (Town) object;
        if ((this.townPK == null && other.townPK != null) || (this.townPK != null && !this.townPK.equals(other.townPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmpe451.soda.entity.Town[ townPK=" + townPK + " ]";
    }
    
}
