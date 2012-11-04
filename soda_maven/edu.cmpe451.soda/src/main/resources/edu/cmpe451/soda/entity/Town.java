/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmpe451.soda.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aurora
 */
@Entity
@Table(name = "town", catalog = "database1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Town.findAll", query = "SELECT t FROM Town t"),
    @NamedQuery(name = "Town.findById", query = "SELECT t FROM Town t WHERE t.id = :id"),
    @NamedQuery(name = "Town.findByCityId", query = "SELECT t FROM Town t WHERE t.cityId = :cityId"),
    @NamedQuery(name = "Town.findByName", query = "SELECT t FROM Town t WHERE t.name = :name")})
public class Town implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "city_id")
    private int cityId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Town() {
    }

    public Town(Integer id) {
        this.id = id;
    }

    public Town(Integer id, int cityId, String name) {
        this.id = id;
        this.cityId = cityId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Town)) {
            return false;
        }
        Town other = (Town) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cmpe451.soda.entity.Town[ id=" + id + " ]";
    }
    
}
