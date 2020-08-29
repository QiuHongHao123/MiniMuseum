/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.MinicarModel;
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
     private MinicarModel minicarModel;

    public MinicarModel getMinicarModel() {
        return minicarModel;
    }

    public void setMinicarModel(MinicarModel minicarModel) {
        this.minicarModel = minicarModel;
    }
    public MinicarController(){
         ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        minicarManagedBean = (MinicarManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "minicarManagedBean");
    }
}
    
