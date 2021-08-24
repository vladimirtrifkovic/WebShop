package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Author;
import com.example.demo.model.Music;
import com.example.demo.service.AuthorService;
import com.example.demo.service.MusicService;

@Controller
public class MusicController {

	@Autowired
	private MusicService musicService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/musics")
	public String getMusics(Model model) {
		List<Author> authorList = authorService.authors();
		model.addAttribute("authorList", authorList);
		
		List<Music> musicList = musicService.getMusic();
		model.addAttribute("musics", musicList);
		
		return "music";
	}
	
	@PostMapping("/musics/addNew")
	public String addMusic(Music music) {
		musicService.addMusic(music);
		
		return "redirect:/musics";
	}
	
	@RequestMapping("/musics/findById")
	@ResponseBody
	public Music findMusicById(Integer id) {
		return musicService.getMusicById(id);
	}
	
	@RequestMapping(value = "/musics/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Music music) {
		musicService.addMusic(music);
		
		return "redirect:/musics";
	}
	
	@RequestMapping(value = "/musics/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		musicService.deleteMusic(id);
		
		return "redirect:/musics";
	}
	
}
