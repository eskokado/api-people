package com.esk.desafio.dio.EskPeopleApi.repositories;

import com.esk.desafio.dio.EskPeopleApi.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
