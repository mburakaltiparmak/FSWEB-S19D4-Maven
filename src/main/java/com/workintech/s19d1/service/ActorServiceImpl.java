package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.exception.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@NoArgsConstructor
@AllArgsConstructor
public class ActorServiceImpl implements ActorService{
    private ActorRepository actorRepository;
    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
      return actorRepository.findById(id).orElseThrow(()->new ApiException("Actor is not found with id:" + " " +id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor update(Long id, Actor updatedActor) {
        Actor toBeUpdatedActor = findById(id);
        toBeUpdatedActor.setFirstName(updatedActor.getFirstName());
        toBeUpdatedActor.setLastName(updatedActor.getLastName());
        toBeUpdatedActor.setGender(updatedActor.getGender());
        toBeUpdatedActor.setBirthDate(updatedActor.getBirthDate());
        toBeUpdatedActor.setMovieList(updatedActor.getMovieList());

        return actorRepository.save(toBeUpdatedActor);
    }
    @Override
    public void delete(Actor actor) {
        actorRepository.delete(actor);


    }
}
