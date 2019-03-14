package io.github.ptrvsky.moviedbrestapi.movie;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Data
@Entity
public class Movie {

    private @Id @GeneratedValue int id;
    private String name;
    private int releaseYear;

    public Movie() {
    }

    public Movie(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

}
