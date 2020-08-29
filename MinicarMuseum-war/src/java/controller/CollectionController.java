/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.CollectionModel;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
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

    public CollectionModel getCollectionModel() {
        return collectionModel;
    }

    public void setCollectionModel(CollectionModel collectionModel) {
        this.collectionModel = collectionModel;
    }
    public CollectionController(){
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        collectionManagedBean = (CollectionManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "collectionManagedBean");
    }
    
}
