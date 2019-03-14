package io.github.ptrvsky.moviedbrestapi.actor;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Actor {

    private @Id @GeneratedValue int id;
    private String name;
    private @JsonFormat(pattern = "dd/MM/yyyy") LocalDate DOB;

    public Actor() {
    }

    public Actor(String name, LocalDate DOB) {
        this.name = name;
        this.DOB = DOB;
    }
}
