package com.spring.security.springSecurity.config;

import com.spring.security.springSecurity.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Главный класс настройки security
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;
    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

//Настройка форма аутентификации
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Кнфигурируем сам Spring
        //конфигурируем авторизацию
        http.csrf().disable()//откл. защиту от межсайтовой подделки запросов
                .authorizeRequests()
                .antMatchers("/auth/login","/auth/registration", "/error").permitAll()//пускать неавторизованного пользователя
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/hello", true)
                .failureUrl("/auth/login?error");
    }

    //Настройка аутентификации
    protected void configure(AuthenticationManagerBuilder aut) throws Exception {
        aut.userDetailsService(personDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
