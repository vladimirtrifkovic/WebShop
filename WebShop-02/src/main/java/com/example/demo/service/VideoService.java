package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Video;
import com.example.demo.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
	
	public List<Video> getVideos() {
		return videoRepository.findAll();
	}
	
	public Video findVideoById(Integer id) {
		return videoRepository.findById(id).get();
	}
	
	public void addVideo(Video video) {
		videoRepository.save(video);
	}
	
	public void deleteVideo(Integer id) {
		videoRepository.deleteById(id);
	}
}
