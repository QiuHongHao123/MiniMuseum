/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.CollectionModel;
import Model.MinicarModel;
import entities.Collection;
import entities.Minicar;
import entities.Person;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import mbeans.CollectionManagedBean;
import mbeans.PersonManagedBean;

/**
 *
 * @author 31588
 */
@Named("collectionController")
@RequestScoped
public class CollectionController {
    @ManagedProperty(value = "#{collectionManagedBean}")
    CollectionManagedBean collectionManagedBean;
    
    private CollectionModel collectionModel;
    private List<CollectionModel> collectionList;

    public CollectionModel getCollectionModel() {
        return collectionModel;
    }

    public void setCollectionModel(CollectionModel collectionModel) {
        this.collectionModel = collectionModel;
    }

    public List<CollectionModel> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<CollectionModel> collectionList) {
        this.collectionList = collectionList;
    }
    
    public CollectionController(){
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        collectionManagedBean = (CollectionManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "collectionManagedBean");
        
        updateCollections();
    }
    
    public void  updateCollections() {
        if (collectionList != null && collectionList.size() > 0)
        {
            
        }else {
            List<Collection> collectionEntities = collectionManagedBean.getAllCollections();
            for(Collection collectionEntity : collectionEntities) {
                CollectionModel collection = new CollectionModel();
                //convert Collection entity to CollectionModel
                collectionEntity.setCarid(collection.getCarid());
                collectionEntity.setEstablishdate(collection.getEstablishdate());
                collectionEntity.setId(collection.getId());
                collectionEntity.setPersonid(collection.getPersonid());
                
                collectionList.add(collection);
            }
        }
    }
    
    public void addCollection(MinicarModel minicarModel) {
        Collection collection = new Collection();
        
        Minicar minicarEntity = new Minicar();
        minicarEntity.setId(minicarModel.getId());
        minicarEntity.setCarname(minicarModel.getCarname());
        minicarEntity.setSeries(minicarModel.getSeries());
        minicarEntity.setSize(minicarModel.getSize());
        minicarEntity.setImgUrl(minicarModel.getImgUrl());
        
        collection.setCarid(minicarEntity);
        
        Date date = new Date();
        collection.setEstablishdate(date);
        
        ExternalContext exContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession)exContext.getSession(true);
        Person person = (Person)session.getAttribute("user");
        collection.setPersonid(person);
        
        collectionManagedBean.addCollection(collection);
    }
    
    public void removeCollection(int collectionId) throws IOException {
        collectionManagedBean.removeCollection(collectionId);
        updateCollections();
        
        ExternalContext exContext = FacesContext.getCurrentInstance().getExternalContext();
        exContext.redirect("collection.html");
    }
}
