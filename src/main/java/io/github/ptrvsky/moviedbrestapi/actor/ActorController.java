package io.github.ptrvsky.moviedbrestapi.actor;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ActorController {
    private final ActorRepository repository;

    public ActorController(ActorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/actors")
    public List<Actor> getAllActors() {
        return repository.findAll();
    }

    @PostMapping("/actors")
    public void addActor(@RequestBody Actor newActor) {
        repository.save(newActor);
    }

    @GetMapping("/actors/{id}")
    public Actor getActor(@PathVariable int id) {
        return repository.findById(id).orElseThrow(() -> new ActorNotFoundException(id));
    }

    @PutMapping("/actors/{id}")
    public void setActor(@RequestBody Actor newActor, @PathVariable int id) {
        repository.findById(id)
                .map(actor -> {
                    actor.setName(newActor.getName());
                    actor.setDOB(newActor.getDOB());
                    return repository.save(actor);
                }).orElseGet(() -> {
            newActor.setId(id);
            return repository.save(newActor);
        });
    }

    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/actors/{id}/name")
    public String getActorName(@PathVariable int id) {
        return repository.findById(id).get().getName();
    }

    @GetMapping("/actors/{id}/dob")
    public LocalDate getActorDOB(@PathVariable int id) {
        return repository.findById(id).get().getDOB();
    }
}
