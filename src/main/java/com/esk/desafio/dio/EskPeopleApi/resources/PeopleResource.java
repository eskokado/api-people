package com.esk.desafio.dio.EskPeopleApi.resources;

import com.esk.desafio.dio.EskPeopleApi.domain.People;
import com.esk.desafio.dio.EskPeopleApi.dto.PeopleDto;
import com.esk.desafio.dio.EskPeopleApi.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/peoples")
public class PeopleResource {

    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public ResponseEntity<List<PeopleDto>> findAll() {
        List<People> list = peopleService.findAll();
        List<PeopleDto> listDto = list.stream().map(p -> new PeopleDto(p)).collect(Collectors.toList());
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PeopleDto> findById(@PathVariable String id) {
        People obj = peopleService.findById(id);
        PeopleDto objDto = new PeopleDto(obj);
        return ResponseEntity.ok(objDto);
    }
}
