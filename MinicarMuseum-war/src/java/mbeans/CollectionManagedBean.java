/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import entities.Collection;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import repository.CollectionRepository;

/**
 *
 * @author 31588
 */
@Named(value = "collectionManagedBean")
@RequestScoped
public class CollectionManagedBean implements Serializable{

    @EJB
    CollectionRepository collectionReository;
    /**
     * Creates a new instance of CollectionManagedBean
     */
    public CollectionManagedBean() {
    }
    public List<Collection> getCollectionsByPersonId(int personId){
        try{
            return collectionReository.getCollectionsByPersonId(personId);
        }
        catch(Exception ex){
            Logger.getLogger(CollectionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<Collection> getCollectionsWithSeries(int personId,String series){
        try{
            return collectionReository.getCollectionsWithSeries(personId, series);
        }
        catch(Exception ex){
            Logger.getLogger(CollectionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addCollection(Collection collection){
        try{
            collectionReository.addCollection(collection);
        }
        catch(Exception ex){
            Logger.getLogger(CollectionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeCollection(int collectionId){
        try{
            collectionReository.removeCollection(collectionId);
        }
        catch(Exception ex){
            Logger.getLogger(CollectionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editCollection(Collection collection){
        try{
            collectionReository.editCollection(collection);
        }
        catch(Exception ex){
            Logger.getLogger(CollectionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
