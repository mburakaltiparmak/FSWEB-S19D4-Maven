package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.dto.ActorResponse;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.util.Converter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/actor")
@CrossOrigin(origins = "*")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
    @GetMapping
    public List<ActorResponse> findAll(){
        List<Actor> actors = actorService.findAll();
        return Converter.actorResponseConvert(actors);
    }

    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable("id") Long id){
        Actor actor = actorService.findById(id);
        return Converter.actorResponseConvert(actor);
    }

    @PostMapping
    public ActorResponse save(@RequestBody ActorRequest actorRequest){
        Actor createdActor = actorRequest.getActor();
        List<Movie> movies = actorRequest.getMovies();
        for(Movie movie : movies){
            createdActor.addMovie(movie);
        }
        Actor savedActor = actorService.save(createdActor);
        return Converter.actorCreateResponseConvert(savedActor);
    }

    @PutMapping("/{id}")
    public ActorResponse update(@PathVariable("id") Long id, @RequestBody Actor actor){
        Actor updatedActor = actorService.findById(id);
        actor.setMovieList(updatedActor.getMovieList());
        actor.setFirstName(updatedActor.getFirstName());
        actor.setLastName(updatedActor.getLastName());
        actor.setGender(updatedActor.getGender());
        actor.setId(updatedActor.getId());
        actorService.save(actor);
        return Converter.actorResponseConvert(actor);
    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable("id") Long id){
        Actor deletedActor =  actorService.findById(id);
        actorService.delete(deletedActor);
        return Converter.actorResponseConvert(deletedActor);
    }
}