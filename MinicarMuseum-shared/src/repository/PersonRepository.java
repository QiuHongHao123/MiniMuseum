/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Person;
import javax.ejb.Remote;

/**
 *
 * @author 31588
 */
@Remote
public interface PersonRepository {
    public void addPerson(Person person) throws Exception;
    public Person searchPersonById(int id) throws Exception;
    public Person searchPersonByEmailAndPassword(String email,String password)throws Exception;
}
