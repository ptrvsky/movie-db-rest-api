package io.github.ptrvsky.moviedbrestapi.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
