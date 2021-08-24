package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	public List<Actor> getActors() {
		return actorRepository.findAll();
	}
	
	public Actor findActorById(Integer id) {
		return actorRepository.findById(id).get();
	}
	
	public void addActor(Actor actor) {
		actorRepository.save(actor);
	}
	
	public void deleteActor(Integer id) {
		actorRepository.deleteById(id);
	}
}
