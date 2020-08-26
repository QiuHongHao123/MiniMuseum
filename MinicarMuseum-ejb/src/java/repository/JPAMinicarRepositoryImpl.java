/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Minicar;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 31588
 */
public class JPAMinicarRepositoryImpl implements MinicarRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Minicar searchMinicarById(int id) throws Exception {
        Minicar minicar = entityManager.find(Minicar.class,id);
        return minicar;
    }

    @Override
    public void addMinicar(Minicar minicar) throws Exception {
        entityManager.persist(minicar);
    }

    @Override
    public List<Minicar> getAllMinicars() throws Exception {
        return entityManager.createNamedQuery("Minicar.findAll",Minicar.class).getResultList();
    }

    @Override
    public List<Minicar> getMinicarsBySeries(String series) throws Exception {
         List<Minicar> minicars= entityManager.createNamedQuery("Minicar.findBySeries",Minicar.class).setParameter(series, series).getResultList();
        return minicars;
    }

    @Override
    public void removeMinicar(int minicarId) throws Exception {
        Minicar minicar=searchMinicarById(minicarId);
        if(minicar!=null){
        entityManager.remove(minicar);
        }
    }

    @Override
    public void editMinicar(Minicar minicar) throws Exception {
        try{
            entityManager.merge(minicar);
        }
        catch(Exception e){}
    }
    
}
