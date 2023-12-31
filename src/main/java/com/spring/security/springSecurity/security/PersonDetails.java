package com.spring.security.springSecurity.security;


import com.spring.security.springSecurity.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

//Класс обертка для класса Person
public class PersonDetails implements UserDetails {

private final Person person;

public PersonDetails(Person person) {
        this.person = person;
        }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;//РОЛИ
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
