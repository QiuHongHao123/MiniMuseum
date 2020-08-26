/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import entities.Minicar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import repository.MinicarRepository;

/**
 *
 * @author 31588
 */
@Named(value = "minicarManagedBean")
@Dependent
public class MinicarManagedBean {

    @EJB
    MinicarRepository minicarRepository;
    /**
     * Creates a new instance of MinicarManagedBean
     */
    public MinicarManagedBean() {
    }
    public List<Minicar> getAllMinicars(){
        try{
            List<Minicar> minicars=minicarRepository.getAllMinicars();
            return minicars;
        }
        catch (Exception ex) {
            Logger.getLogger(MinicarManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public Minicar searchMinicarById(int minicarId){
         try {
            return minicarRepository.searchMinicarById(minicarId);
        } catch (Exception ex) {
             Logger.getLogger(MinicarManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
     }
      public List<Minicar> getMinicarsBySeires(String series){
          try {
            return minicarRepository.getMinicarsBySeries(series);
        } catch (Exception ex) {
             Logger.getLogger(MinicarManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
          return null;
      }
    public void addMinicar(Minicar minicar) {
        try {
            minicarRepository.addMinicar(minicar);
        } catch (Exception ex) {
             Logger.getLogger(MinicarManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeMinicar(int minicarId){
        try {
            minicarRepository.removeMinicar(minicarId);
        } catch (Exception ex) {
             Logger.getLogger(MinicarManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void editMinicar(Minicar minicar) {
         try {
            minicarRepository.editMinicar(minicar);
        } catch (Exception ex) {
             Logger.getLogger(MinicarManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
