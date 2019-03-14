package io.github.ptrvsky.moviedbrestapi.movie;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(int id) {
        super("There is no movie with id " + id);
    }

}
