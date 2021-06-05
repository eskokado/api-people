package com.esk.desafio.dio.EskPeopleApi.domain;

import com.esk.desafio.dio.EskPeopleApi.dto.AuthorDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "post")
public class Post {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto author;

    public Post() {
    }

    public Post(String id, Date date, String title, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
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
