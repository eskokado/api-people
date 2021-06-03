package com.esk.desafio.dio.EskPeopleApi.services;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import com.esk.desafio.dio.EskPeopleApi.services.exceptions.ObjectNotFoundException;
import com.esk.desafio.dio.EskPeopleApi.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    public People findById(String id) {
        Optional<People> obj = peopleRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
