package com.esk.desafio.dio.EskPeopleApi.services;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import com.esk.desafio.dio.EskPeopleApi.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> findAll() {
        return peopleRepository.findAll();
    }
}
