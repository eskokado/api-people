package com.esk.desafio.dio.EskPeopleApi.dto;

import com.esk.desafio.dio.EskPeopleApi.domain.People;

public class AuthorDto {
    private String id;
    private String name;

    public AuthorDto() {}

    public AuthorDto(People people) {
        this.id = people.getId();
        this.name = people.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
