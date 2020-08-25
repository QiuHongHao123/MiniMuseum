/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 31588
 */
public class JPAPersonyRepositoryImpl implements PersonRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPerson(Person person) throws Exception {
        entityManager.persist(person);
        
    }

    @Override
    public Person searchPersonById(int id) throws Exception {
       Person person = entityManager.find(Person.class, id);
       return person;
    }

    @Override
    public Person searchPersonByEmailAndPassword(String email, String password) throws Exception {
       Person person=(Person)entityManager.createNamedQuery("Person.findByEmailAndPassword").setParameter(email, email).setParameter(password, password).getSingleResult();
       return person;
    }
}
