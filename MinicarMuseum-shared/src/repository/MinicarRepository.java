/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Minicar;
import entities.Person;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 31588
 */
@Remote
public interface MinicarRepository {
    public Minicar searchMinicarById(int id)throws Exception;
    public void addMinicar(Minicar minicar)throws Exception;
    public List<Minicar> getAllMinicars() throws Exception;
    public List<Minicar> getMinicarsBySeries(String Series) throws Exception;
    
    public void removeMinicar(int minicarId) throws Exception;
    public void editMinicar(Minicar minicar) throws Exception;
   
}
