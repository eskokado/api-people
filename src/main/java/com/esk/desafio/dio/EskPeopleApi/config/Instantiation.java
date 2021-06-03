package com.esk.desafio.dio.EskPeopleApi.config;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import com.esk.desafio.dio.EskPeopleApi.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public void run(String... args) throws Exception {
        peopleRepository.deleteAll();

        People jose = new People(null, "Joao Daniel", "joaodaniel@email.com", "123456");
        People maria = new People(null, "Maria Silva", "mariasilva@email.com", "123456");
        People paulo = new People(null, "Paulo Souza", "paulosouza@email.com", "123456");

        peopleRepository.saveAll(Arrays.asList(jose, maria, paulo));
    }
}
