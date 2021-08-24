package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Music;
import com.example.demo.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	private MusicRepository musicRepository;
	
	public List<Music> getMusic() {
		return musicRepository.findAll();
	}
	
	public Music getMusicById(Integer id) {
		return musicRepository.findById(id).get();
	}
	
	public void addMusic(Music music) {
		musicRepository.save(music);
	}
	
	public void deleteMusic(Integer id) {
		musicRepository.deleteById(id);
	}

}
