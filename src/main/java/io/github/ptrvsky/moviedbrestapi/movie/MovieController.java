package io.github.ptrvsky.moviedbrestapi.movie;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @PostMapping("/movies")
    public void addMovie(@RequestBody Movie newMovie) {
        repository.save(newMovie);
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        return repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PutMapping("/movies/{id}")
    public void setMovie(@RequestBody Movie newMovie, @PathVariable int id) {
        repository.findById(id)
                .map(movie -> {
                    movie.setName(newMovie.getName());
                    movie.setReleaseYear(newMovie.getReleaseYear());
                    return repository.save(movie);
                }).orElseGet(() -> {
                    newMovie.setId(id);
                    return repository.save(newMovie);
                });
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/movies/{id}/name")
    public String getMovieName(@PathVariable int id) {
        return repository.findById(id).get().getName();
    }

    @GetMapping("/movies/{id}/releaseYear")
    public int getMovieReleaseYear(@PathVariable int id) {
        return repository.findById(id).get().getReleaseYear();
    }
}
