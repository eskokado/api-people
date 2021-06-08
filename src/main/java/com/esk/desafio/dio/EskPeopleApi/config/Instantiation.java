package com.esk.desafio.dio.EskPeopleApi.config;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import com.esk.desafio.dio.EskPeopleApi.domain.Post;
import com.esk.desafio.dio.EskPeopleApi.dto.AuthorDto;
import com.esk.desafio.dio.EskPeopleApi.dto.CommentDto;
import com.esk.desafio.dio.EskPeopleApi.repositories.PeopleRepository;
import com.esk.desafio.dio.EskPeopleApi.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        peopleRepository.deleteAll();
        postRepository.deleteAll();

        People joao = new People(null, "Joao Daniel", "joaodaniel@email.com");
        People maria = new People(null, "Maria Silva", "mariasilva@email.com");
        People paulo = new People(null, "Paulo Souza", "paulosouza@email.com");

        peopleRepository.saveAll(Arrays.asList(joao, maria, paulo));

        Post post1 = new Post(null, sdf.parse("01/05/2021"), "Postando nas nuvens", "Novas dicas das nuvens", new AuthorDto(joao));
        Post post2 = new Post(null, sdf.parse("02/05/2021"), "Novo SOLID", "Boas arquiteturas", new AuthorDto(joao));

        CommentDto c1 = new CommentDto("Tem um site de curso gratuito", sdf.parse("02/05/2021"), new AuthorDto(paulo));
        CommentDto c2 = new CommentDto("Aproveite", sdf.parse("02/05/2021"), new AuthorDto(maria));
        CommentDto c3 = new CommentDto("Vou aproveitar", sdf.parse("02/05/2021"), new AuthorDto(paulo));

        post1.setComments(Arrays.asList(c1, c2));
        post2.setComments(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        joao.getPosts().addAll(Arrays.asList(post1, post2));
        peopleRepository.save(joao);
    }
}
