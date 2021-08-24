package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;

@Controller
public class ActorController {

	@Autowired
	private ActorService actorService;
	
	@GetMapping("/actors")
	public String getActors(Model model) {
		List<Actor> actorList = actorService.getActors();
		model.addAttribute("actors", actorList);
		
		return "actor";
	}
	
	@PostMapping("/actors/addNew")
	public String addActor(Actor actor) {
		actorService.addActor(actor);
		
		return "redirect:/actors";
	}
	
	@RequestMapping(value = "/actors/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateActor(Actor actor) {
		actorService.addActor(actor);
		
		return "redirect:/actors";
	}
	
	@RequestMapping("/actors/findById")
	@ResponseBody
	public Actor findActor(Integer id) {
		return actorService.findActorById(id);
	}
	
	@RequestMapping(value = "actors/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteActor(Integer id) {
		actorService.deleteActor(id);
		
		return "redirect:/actors";
	}
	
}
