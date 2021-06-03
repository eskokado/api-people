package com.esk.desafio.dio.EskPeopleApi.dto;

import com.esk.desafio.dio.EskPeopleApi.domain.People;

public class PeopleDto {
    private String id;
    private String name;
    private String email;

    public PeopleDto() {

    }

    public PeopleDto(People people) {
        this.id = people.getId();
        this.name = people.getName();
        this.email = people.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
