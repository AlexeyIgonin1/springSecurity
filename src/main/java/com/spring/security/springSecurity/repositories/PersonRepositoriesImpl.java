package com.spring.security.springSecurity.repositories;

import com.spring.security.springSecurity.models.Person;
import com.spring.security.springSecurity.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


//@Repository
public class PersonRepositoriesImpl implements PersonRepositories{

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    @Transactional
//    public void savePersonDetail(Person person) {
//        entityManager.persist(person);
//    }
//
//    @Override
//    @Transactional
//    public List<Person> getAllPerson() {
//
//        return entityManager.createQuery("SELECT e from Person e", Person.class).getResultList();
//    }
}
