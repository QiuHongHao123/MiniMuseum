/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 31588
 */
@RequestScoped
@Named(value="personModel")
public class PersonModel implements Serializable{
    private int personModelId;
   
    private String name;
   
    private String password;
    
    private String email;
   
    private Integer age;
  
    private String gender;
    
    private Collection<entities.Collection> collectionCollection;

    public PersonModel(String name, String password, String email, Integer age, String gender, Collection<entities.Collection> collectionCollection) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.collectionCollection = collectionCollection;
    }
    
    public int getPersonModelId() {
        return personModelId;
    }

    public void setPersonModelId(int personModelId) {
        this.personModelId = personModelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Collection<entities.Collection> getCollectionCollection() {
        return collectionCollection;
    }

    public void setCollectionCollection(Collection<entities.Collection> collectionCollection) {
        this.collectionCollection = collectionCollection;
    }
    
}
