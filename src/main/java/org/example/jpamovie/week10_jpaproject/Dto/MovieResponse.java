package org.example.jpamovie.week09_jpaproject.Dto;

import org.example.jpamovie.week09_jpaproject.Entity.Movie;

public record MovieResponse(
        Long id,
        String title,
        String director,
        String genre,
        Double rating,
        Integer releaseYear,
        Integer runningTime
) {
    public static MovieResponse from(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getGenre(),
                movie.getRating(),
                movie.getReleaseYear(),
                movie.getRunningTime()
        );
    }
}