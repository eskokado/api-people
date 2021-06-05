package com.esk.desafio.dio.EskPeopleApi.dto;

import com.esk.desafio.dio.EskPeopleApi.domain.Post;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

public class PostDto {
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto author;

    public PostDto() {
    }

    public PostDto(String id, Date date, String title, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public PostDto(Post p) {
        this.id = p.getId();
        this.date = p.getDate();
        this.title = p.getTitle();
        this.body = p.getBody();
        this.author = p.getAuthor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
