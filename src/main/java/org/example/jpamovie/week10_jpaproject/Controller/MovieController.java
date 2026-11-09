package org.example.jpamovie.week10_jpaproject.Controller;
 import org.example.jpamovie.week10_jpaproject.Dto.MovieRequest;
 import org.example.jpamovie.week10_jpaproject.Dto.MovieResponse;
 import org.example.jpamovie.week10_jpaproject.Service.MovieService;
 import jakarta.validation.Valid;
 import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.List;

 import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<MovieResponse> create(@Valid @RequestBody MovieRequest request) {
        MovieResponse created = service.create(request);
        return ResponseEntity.created(URI.create("/api/movies/" + created.id())).body(created);
    }

    @GetMapping
    public List<MovieResponse> findAll() { return service.findAll(); }
    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable Long id) {
                return service.findById(id); }

    @PutMapping("/{id}")
    public MovieResponse update(@PathVariable Long id, @Valid @RequestBody MovieRequest request) {
                       return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
                     service.delete(id);
        return ResponseEntity.noContent().build();
    }




    @GetMapping("/search/genre")
    public ResponseEntity<List<MovieResponse>> searchByGenre(
            @RequestParam String genre) {

        return ResponseEntity.ok(service.findByGenre(genre));
    }


    @GetMapping("/search/genre-rating")
    public ResponseEntity<List<MovieResponse>> searchByGenreAndRating(
            @RequestParam String genre,
            @RequestParam Double rating) {

        return ResponseEntity.ok(
                service.findByGenreAndRating(genre, rating));
    }

    @GetMapping("/search/genre-sorted")
    public ResponseEntity<List<MovieResponse>> searchByGenreSorted(
            @RequestParam String genre) {

        return ResponseEntity.ok(service.findByGenreSorted(genre));
    }

    @GetMapping("/search/title")
    public ResponseEntity<List<MovieResponse>> searchByTitle(
            @RequestParam String keyword) {

        return ResponseEntity.ok(service.findByTitleKeyword(keyword));
    }
}
