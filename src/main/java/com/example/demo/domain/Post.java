package com.example.demo.domain;

import com.example.demo.dto.AutorDTO;
import com.example.demo.dto.ComentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Fernanda on 11/06/2018.
 */
@Document
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;

    private AutorDTO autor;
    private List<ComentDTO> comments = new ArrayList<>();



    public Post() {

    }


    public Post(String id, Date date, String title, String body, AutorDTO autor) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.autor = autor;
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

    public AutorDTO getAutor() {
        return autor;
    }
    public List<ComentDTO> getComments() {
        return comments;
    }

    public void setComments(List<ComentDTO> comments) {
        this.comments = comments;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        return id != null ? id.equals(post.id) : post.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
