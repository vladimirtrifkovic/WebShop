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
import com.example.demo.model.Video;
import com.example.demo.service.ActorService;
import com.example.demo.service.VideoService;

@Controller
public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@Autowired
	private ActorService actorService;
	
	@GetMapping("/videos")
	public String getVideos(Model model) {
		List<Actor> actorList = actorService.getActors();
		model.addAttribute("actorList", actorList);
		
		List<Video> videoList = videoService.getVideos();
		model.addAttribute("videos", videoList);
		
		return "video";
	}
	
	@PostMapping("/videos/addNew")
	public String addVideo(Video video) {
		videoService.addVideo(video);
		
		return "redirect:/videos";
	}
	
	@RequestMapping("/videos/findById")
	@ResponseBody
	public Video findVideoById(Integer id) {
		return videoService.findVideoById(id);
	}
	
	@RequestMapping(value = "/videos/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Video video) {
		videoService.addVideo(video);
		
		return "redirect:/videos";
	}
	
	@RequestMapping(value = "/videos/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		videoService.deleteVideo(id);
		
		return "redirect:/videos";
	}
	
}
