package org.example.jpamovie.week010_jpaproject.Service;

import org.example.jpamovie.week10_jpaproject.Dto.MovieRequest;
import org.example.jpamovie.week10_jpaproject.Dto.MovieResponse;
import org.example.jpamovie.week10_jpaproject.Entity.Movie;
import org.example.jpamovie.week10_jpaproject.Repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository=repository;
    }
    public MovieResponse create(MovieRequest request) {
        Movie movie=new Movie();
         movie.setTitle(request.title());
         movie.setDirector(request.director());
           movie.setGenre(request.genre());
           movie.setRating(request.rating());
           movie.setReleaseYear(request.releaseYear());
            movie.setRunningTime(request.runningTime());

        Movie saved=repository.save(movie);
        return MovieResponse.from(saved);
    }

    public List<MovieResponse> findAll() {
        return repository.findAll().stream().map(MovieResponse::from).toList();
    }

    public MovieResponse findById(Long id) {
        return MovieResponse.from(findEntity(id));
    }
    /*③  Q7. save()를 호출하면 새로운 데이터 등록과 기존 데이터 수정이 어떻게 처리되는가?
          새로운 객체 Entity라면 내부적으로 persist()를 호출하여 정보를 저장하고,
          기존에 있는 Entity라면 내부적으로 merge()를 통해 데이터를 수정한다

          Q8.


    * */
    public MovieResponse update(Long id, MovieRequest request) {
        Movie movie=findEntity(id);
         movie.setTitle(request.title());
         movie.setDirector(request.director());
         movie.setGenre(request.genre());
         movie.setRating(request.rating());
          movie.setReleaseYear(request.releaseYear());
          movie.setRunningTime(request.runningTime());

        return MovieResponse.from(repository.save(movie));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found: " + id);
        }
        repository.deleteById(id);
    }

    private Movie findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Movie not found: " + id));
    }
}

public List<MovieResponse> findByGenre(String genre) {

    List<Movie> movies=repository.findByGenre(genre);
    List<MovieResponse>result=new ArrayList<>();
    for (Movie movie:movies){
        result.add(MovieResponse.from(movie));
        }
                    return result;
            }
