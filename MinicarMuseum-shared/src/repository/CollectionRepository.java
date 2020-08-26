/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Collection;
import entities.Minicar;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 31588
 */
@Remote
public interface CollectionRepository {
    public List<Collection> getCollectionsByPersonId(int personId) throws Exception;
    public List<Collection> getCollectionsWithSeries(int personId,String series) throws Exception;
    public void addCollection(Collection collection) throws Exception;
    public void removeCollection(int collectionId) throws Exception;
    public void editCollection(Collection collection) throws Exception;
    
}
