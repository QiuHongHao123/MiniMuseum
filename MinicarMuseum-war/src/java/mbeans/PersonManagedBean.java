/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import entities.Person;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import repository.PersonRepository;

/**
 *
 * @author 31588
 */
@ManagedBean(name = "personManagedBean")
@SessionScoped
public class PersonManagedBean implements Serializable {

    @EJB
    PersonRepository personRepository;
    /**
     * Creates a new instance of PersonManagedBean
     */
    public PersonManagedBean() {
    }
    public void addPerson(Person person){
        try{
            personRepository.addPerson(person);
        }
        catch(Exception ex){
             Logger.getLogger(PersonManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public Person searchPersonById(int id){
         try{
            return personRepository.searchPersonById(id);
        }
        catch(Exception ex){
             Logger.getLogger(PersonManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    public Person searchPersonByEmailAndPassword(String email,String password){
         try{
            return personRepository.searchPersonByEmailAndPassword(email, password);
        }
        catch(Exception ex){
             Logger.getLogger(PersonManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
}
