/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import entities.Minicar;
import entities.Person;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 31588
 */
@RequestScoped
@Named(value="collectionModel")
public class CollectionModel implements Serializable{
    private int id;
    
    private Date establishdate;
    
    private Minicar carid;
    
    private Person personid;

    public CollectionModel(){}
    public CollectionModel(Date establishdate){
        this.establishdate=establishdate;
    }
    public CollectionModel(Date establishdate,Minicar carid){
        this.establishdate=establishdate;
        this.carid=carid;
    }
    public CollectionModel(Date establishdate,Person personid){
        this.establishdate=establishdate;
        this.personid=personid;
    }
    public CollectionModel(Date establishdate,Person personid,Minicar carid){
        this.establishdate=establishdate;
        this.personid=personid;
        this.carid=carid;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEstablishdate() {
        return establishdate;
    }

    public void setEstablishdate(Date establishdate) {
        this.establishdate = establishdate;
    }

    public Minicar getCarid() {
        return carid;
    }

    public void setCarid(Minicar carid) {
        this.carid = carid;
    }

    public Person getPersonid() {
        return personid;
    }

    public void setPersonid(Person personid) {
        this.personid = personid;
    }
    
}
