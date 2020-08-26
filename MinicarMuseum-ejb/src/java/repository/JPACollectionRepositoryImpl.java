/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 31588
 */
public class JPACollectionRepositoryImpl implements CollectionRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Collection> getCollectionsByPersonId(int personId) throws Exception {
        return entityManager.createNamedQuery("Collection.getCollectionsByPersonId",Collection.class).setParameter(personId, personId).getResultList();
    }

    @Override
    public List<Collection> getCollectionsWithSeries(int personId, String series) throws Exception {
        return entityManager.createNamedQuery("Collection.getCollectionsWithSeries",Collection.class).setParameter(personId, personId).
                                                                                                    setParameter(series, series).getResultList();
    }

    @Override
    public void addCollection(Collection collection) throws Exception {
        entityManager.persist(collection);
    }

    @Override
    public void removeCollection(int collectionId) throws Exception {
        Collection toRemove=entityManager.find(Collection.class, collectionId);
        if(toRemove!=null){
            entityManager.remove(toRemove);
        }
    }

    @Override
    public void editCollection(Collection collection) throws Exception {
        try{
            entityManager.merge(collection);
        }
        catch(Exception ex){}
    }
    
    
    
}
