package com.esk.desafio.dio.EskPeopleApi.resources;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import com.esk.desafio.dio.EskPeopleApi.domain.Post;
import com.esk.desafio.dio.EskPeopleApi.dto.PeopleDto;
import com.esk.desafio.dio.EskPeopleApi.services.PeopleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/peoples")
public class PeopleResource {

    @Autowired
    private PeopleService peopleService;

    @GetMapping
    @ApiOperation(value="Retorna todos people")
    public ResponseEntity<List<PeopleDto>> findAll() {
        List<People> list = peopleService.findAll();
        List<PeopleDto> listDto = list.stream().map(p -> new PeopleDto(p)).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Busca por id")
    public ResponseEntity<PeopleDto> findById(@PathVariable String id) {
        People obj = peopleService.findById(id);
        PeopleDto objDto = new PeopleDto(obj);
        return ResponseEntity.ok(objDto);
    }

    @PostMapping
    @ApiOperation(value="Insere People")
    public ResponseEntity<Void> insert(@RequestBody PeopleDto objDto) {
        People obj = peopleService.fromDTO(objDto);
        obj = peopleService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value="Remove people por id")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        peopleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value="Atualiza people")
    public ResponseEntity<PeopleDto> update(@PathVariable String id, @RequestBody PeopleDto objDto) {
        People obj = peopleService.fromDTO(objDto);
        obj.setId(id);
        peopleService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    @ApiOperation(value="Busca posts do people")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        People obj = peopleService.findById(id);
        return ResponseEntity.ok(obj.getPosts());
    }
}
