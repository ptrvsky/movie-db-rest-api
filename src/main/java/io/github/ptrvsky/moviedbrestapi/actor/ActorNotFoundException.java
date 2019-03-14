package io.github.ptrvsky.moviedbrestapi.actor;

public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException(int id) {
        super("There is no actor with id " + id);
    }
}
