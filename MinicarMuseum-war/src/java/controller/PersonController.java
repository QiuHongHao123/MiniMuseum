/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.PersonModel;
import entities.Person;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import mbeans.PersonManagedBean;

/**
 *
 * @author 31588
 */
@Named("personController")
@RequestScoped
public class PersonController {
    @ManagedProperty(value ="#{personManagedBean}")
    PersonManagedBean personManagedBean;
    private PersonModel personModel;

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }
    
    public PersonController(){
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        personManagedBean = (PersonManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "personManagedBean");
    }
    public void register(PersonModel personModel){
        try{
            Person  person = new Person();
            person.setName(personModel.getName());
            person.setAge(personModel.getAge());
            person.setEmail(personModel.getEmail());
            person.setPassword(personModel.getPassword());
            person.setGender(personModel.getGender());
            personManagedBean.addPerson(person);
        }
        catch(Exception ex){
        }    
    }
    
    
}
