package com.esk.desafio.dio.EskPeopleApi.resources;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import com.esk.desafio.dio.EskPeopleApi.domain.Post;
import com.esk.desafio.dio.EskPeopleApi.dto.PeopleDto;
import com.esk.desafio.dio.EskPeopleApi.dto.PostDto;
import com.esk.desafio.dio.EskPeopleApi.services.PeopleService;
import com.esk.desafio.dio.EskPeopleApi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        List<Post> list = postService.findAll();
        List<PostDto> listDto = list.stream().map(p -> new PostDto(p)).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable String id) {
        Post obj = postService.findById(id);
        PostDto objDto = new PostDto(obj);
        return ResponseEntity.ok(objDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PostDto objDto) {
        Post obj = postService.fromDTO(objDto);
        obj = postService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDto> update(@PathVariable String id, @RequestBody PostDto objDto) {
        Post obj = postService.fromDTO(objDto);
        obj.setId(id);
        postService.update(obj);
        return ResponseEntity.noContent().build();
    }
}