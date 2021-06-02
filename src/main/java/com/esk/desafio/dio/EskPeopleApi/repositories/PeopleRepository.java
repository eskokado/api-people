package com.esk.desafio.dio.EskPeopleApi.repositories;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends MongoRepository<People, String> {
}
