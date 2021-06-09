package com.esk.desafio.dio.EskPeopleApi.services;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import com.esk.desafio.dio.EskPeopleApi.domain.Post;
import com.esk.desafio.dio.EskPeopleApi.dto.PeopleDto;
import com.esk.desafio.dio.EskPeopleApi.dto.PostDto;
import com.esk.desafio.dio.EskPeopleApi.repositories.PeopleRepository;
import com.esk.desafio.dio.EskPeopleApi.repositories.PostRepository;
import com.esk.desafio.dio.EskPeopleApi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Post insert(Post obj) {
        return postRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        postRepository.deleteById(id);
    }

    public Post update(Post obj) {
        Post objNew = findById(obj.getId());
        updateData(objNew, obj);
        return postRepository.save(objNew);
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> findByBody(String text) {
        return postRepository.findByBody(text);
    }

    private void updateData(Post objNew, Post obj) {
        objNew.setAuthor(obj.getAuthor());
        objNew.setId(obj.getId());
        objNew.setTitle(obj.getTitle());
        objNew.setDate(obj.getDate());
        objNew.setBody(obj.getBody());
    }

    public Post fromDTO(PostDto objDto) {
        return new Post(objDto.getId(), objDto.getDate(), objDto.getTitle(), objDto.getBody(), objDto.getAuthor());
    }
}
