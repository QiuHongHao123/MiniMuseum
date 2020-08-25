/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author 31588
 */
@Entity
@Table(name = "MINICAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Minicar.findAll", query = "SELECT m FROM Minicar m"),
    @NamedQuery(name = "Minicar.findById", query = "SELECT m FROM Minicar m WHERE m.id = :id"),
    @NamedQuery(name = "Minicar.findByCarname", query = "SELECT m FROM Minicar m WHERE m.carname = :carname"),
    @NamedQuery(name = "Minicar.findBySeries", query = "SELECT m FROM Minicar m WHERE m.series = :series"),
    @NamedQuery(name = "Minicar.findBySize", query = "SELECT m FROM Minicar m WHERE m.size = :size"),
    @NamedQuery(name = "Minicar.findByImgUrl", query = "SELECT m FROM Minicar m WHERE m.imgUrl = :imgUrl")})
public class Minicar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "CARNAME")
    private String carname;
    @Size(max = 100)
    @Column(name = "SERIES")
    private String series;
    @Size(max = 100)
    @Column(name = "SIZE")
    private String size;
    @Size(max = 100)
    @Column(name = "IMG_URL")
    private String imgUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carid")
    private Collection<entities.Collection> collectionCollection;

    public Minicar() {
    }

    public Minicar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @XmlTransient
    public Collection<entities.Collection> getCollectionCollection() {
        return collectionCollection;
    }

    public void setCollectionCollection(Collection<entities.Collection> collectionCollection) {
        this.collectionCollection = collectionCollection;
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
        if (!(object instanceof Minicar)) {
            return false;
        }
        Minicar other = (Minicar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Minicar[ id=" + id + " ]";
    }
    
}
