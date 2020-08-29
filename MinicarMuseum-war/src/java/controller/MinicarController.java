/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.MinicarModel;
import entities.Minicar;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import mbeans.MinicarManagedBean;

/**
 *
 * @author 31588
 */
@Named("minicarController")
@RequestScoped
public class MinicarController {
    @ManagedProperty(value ="#{minicarManagedBean}")
    MinicarManagedBean minicarManagedBean;
     
    private ArrayList<MinicarModel> minicarList;
    private MinicarModel minicar;

    public MinicarController(){
         ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        minicarManagedBean = (MinicarManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "minicarManagedBean"); 
        
        updateMinicars();
    }

    public ArrayList<MinicarModel> getMinicarList() {
        return minicarList;
    }

    public void setMinicarList(ArrayList<MinicarModel> minicarList) {
        this.minicarList = minicarList;
    }

    public MinicarModel getMinicar() {
        return minicar;
    }

    public void setMinicar(MinicarModel minicar) {
        this.minicar = minicar;
    }
    
    public void  updateMinicars() {
        if (minicarList != null && minicarList.size() > 0)
        {
            
        }else {
            List<Minicar> minicarEntities = minicarManagedBean.getAllMinicars();
            for(Minicar minicar : minicarEntities) {
                MinicarModel minicarModel = new MinicarModel();
                //convert Minicar entity to MincarModel
                minicarModel.setId(minicar.getId());
                minicarModel.setCarname(minicar.getCarname());
                minicarModel.setSeries(minicar.getSeries());
                minicarModel.setImgUrl(minicar.getImgUrl());
                minicarModel.setSize(minicar.getSize());
                
                minicarList.add(minicarModel);
            }
        }
    }
    
    public void addMinicar(MinicarModel minicarModel) {
        Minicar minicarEntity = convertModelToEntity(minicarModel);
        minicarManagedBean.addMinicar(minicarEntity);
    }
    
    public void updateMinicar(MinicarModel minicarModel) {
        Minicar minicarEntity = convertModelToEntity(minicarModel);
        minicarManagedBean.editMinicar(minicarEntity);
    }
    
    public void removeMinicar(int carId) {
        minicarManagedBean.removeMinicar(carId);
    }
    
    public MinicarModel getMinicarInfo(int carId) {
        Minicar minicarEntity = minicarManagedBean.searchMinicarById(carId);
        minicar.setId(carId);
        minicar.setCarname(minicarEntity.getCarname());
        minicar.setSeries(minicarEntity.getSeries());
        minicar.setImgUrl(minicarEntity.getImgUrl());
        minicar.setSize(minicarEntity.getSize());
        return minicar;
    }
    
    public Minicar convertModelToEntity(MinicarModel minicarModel) {
        Minicar minicarEntity = new Minicar();

        minicarEntity.setId(minicarModel.getId());
        minicarEntity.setCarname(minicarModel.getCarname());
        minicarEntity.setSeries(minicarModel.getSeries());
        minicarEntity.setImgUrl(minicarModel.getImgUrl());
        minicarEntity.setSize(minicarModel.getSize());
        
        return minicarEntity;
    }
}
    
