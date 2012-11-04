/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmpe451.soda.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author aurora
 */
@Embeddable
public class TownPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CityID")
    private int cityID;
    @Basic(optional = false)
    @Column(name = "TownID")
    private int townID;

    public TownPK() {
    }

    public TownPK(int cityID, int townID) {
        this.cityID = cityID;
        this.townID = townID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getTownID() {
        return townID;
    }

    public void setTownID(int townID) {
        this.townID = townID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cityID;
        hash += (int) townID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TownPK)) {
            return false;
        }
        TownPK other = (TownPK) object;
        if (this.cityID != other.cityID) {
            return false;
        }
        if (this.townID != other.townID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmpe451.soda.entity.TownPK[ cityID=" + cityID + ", townID=" + townID + " ]";
    }
    
}
