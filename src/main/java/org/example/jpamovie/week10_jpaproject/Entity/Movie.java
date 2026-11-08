package org.example.jpamovie.week10_jpaproject.Entity;

import jakarta.persistence.*;

@Entity // ① Q1.Entity는 Java 코드와 DB 테이블을 매핑시키는 역할을 한다.
@Table(name = "movies") //① Q1.Table은 특정 DB 테이블 이름과 연결할 수 있는 역할을 한다.
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* ① Q1. @Entity, @Id, @GeneratedValue는 각각 어떤 역할을 하는가?
         @Entity는 어떤 클래스를 해당 JPA기술을 사용하겠다고 지정하는 역할을 한다.
         @Id는 해당 필드의 기본키값을 설정하는 역할을 한다.
         @GeneratedValue는 자동으로 (primary key)를 설정하는 역할을 한다.
       ① Q2. Entity 클래스와 데이터베이스 테이블은 어떻게 연결되는가?
        Entitiy Class와 DB Table은  JPA의 ORM 기술로 매핑, 연결이 된다. */
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 100)
    private String director;

    @Column(length = 50)
    private String genre;

    @Column
    private Double rating;

    @Column
    private Integer releaseYear;

    @Column
    private Integer runningTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }
}
