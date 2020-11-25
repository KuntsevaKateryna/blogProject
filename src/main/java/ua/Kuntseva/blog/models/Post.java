package ua.Kuntseva.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, annons, full_text;
    private int views;

    public Post() {
    }

    public Post(String title, String annons, String full_text) {
        this.title = title;
        this.annons = annons;
        this.full_text = full_text;
    }

        public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnons() {
        return annons;
    }

    public void setAnnons(String annons) {
        this.annons = annons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
