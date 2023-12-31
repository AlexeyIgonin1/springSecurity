package com.spring.security.springSecurity.services;

import com.spring.security.springSecurity.models.Person;
import com.spring.security.springSecurity.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


    @Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void registration(Person person){
        peopleRepository.save(person);
    }
}
